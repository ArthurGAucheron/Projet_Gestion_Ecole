package com.intiformation.gestionecole.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.gestionecole.modele.Adresse;
import com.intiformation.gestionecole.modele.Etudiant;
import com.intiformation.gestionecole.modele.Promotion;
import com.intiformation.gestionecole.service.AdresseServiceImpl;
import com.intiformation.gestionecole.service.EtudiantServiceImpl;
import com.intiformation.gestionecole.service.PromotionServiceImpl;

public class GestionEtudiantController {
	
	@Autowired
	private EtudiantServiceImpl etudiantService;

	public void setEtudiantService(EtudiantServiceImpl etudiantService) {
		this.etudiantService = etudiantService;
	}
	
	@Autowired
	private AdresseServiceImpl adresseService;
	
	public void setAdresseService(AdresseServiceImpl adresseService) {
		this.adresseService = adresseService;
	}

	@Autowired
	private PromotionServiceImpl promotionService;
	
	public void setPromotionService(PromotionServiceImpl promotionService) {
		this.promotionService = promotionService;
	}

	/**
	 * fonction lancé à l'affichage de la page des étudiants
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/etu/listeetu", method=RequestMethod.GET)
	public String listeEtudiant(ModelMap modelMap) {
		
		List<Etudiant> listeEtudiantBdd = etudiantService.findAll();
		
		modelMap.addAttribute("liste_etudiant_attribute", listeEtudiantBdd);
		
		return "gestion-etudiant";
		
	}//end listeEtudiant()
	
	/**
	 * fonction renvoyant vers la page "ajouter-etudiant"
	 * 
	 * > affiche le formulaire
	 * @return
	 */
	@RequestMapping(value="/admin/formulaireetudiant", method=RequestMethod.GET)
	public ModelAndView ajouterEtudiant() {
		
		Etudiant etudiant = new Etudiant();
		Adresse adresse = new Adresse();
		Promotion promotion = new Promotion();
		
		Map<String, Object> donneesCommande = new HashMap<String, Object>();
		donneesCommande.put("etudiantAttribute", etudiant);
		donneesCommande.put("adresseAttribute", adresse);
		donneesCommande.put("promotionAttribute", promotion);
		
		return new ModelAndView("ajouter-etudiant", donneesCommande);
		
	}//end ajouterEtudiant()
	
	/**
	 * ajoute l'étudiant à la bdd à partir des rensaignements du formulaire
	 * @param etudiant
	 * @param adresse
	 * @param promotion
	 * @return
	 */
	@RequestMapping(value="/etu/addetu", method=RequestMethod.POST)
	public String addEtudiant(@ModelAttribute("etudiantAttribute")@Validated Etudiant etudiant, @ModelAttribute("adresseAttribute")@Validated Adresse adresse, @ModelAttribute("promotionAttribute")@Validated Promotion promotion) {
		
		adresseService.ajouter(adresse);
		promotionService.ajouter(promotion);
		etudiantService.ajouter(etudiant);
		
		return "redirect:/etu/listeetu";
		
	}//end addEtudiant()
	
	@RequestMapping(value="/etu/supp/idetu/{idEtudiant}", method=RequestMethod.GET)
	public String supprimerEtudiant(@PathVariable("idEtudiant") long idEtudiant) {
		
		etudiantService.supprimer(idEtudiant);
		
		return "redirect:/etu/listeetu";
		
	}//end supprimerEtudiant()
	
	/**
	 * fonction renvoyant vers la page "modifier-etudiant"
	 * 
	 * > affiche le formulaire
	 * @param idEtudiant
	 * @return
	 */
	@RequestMapping(value="/etu/formulairemodifetudiant/{idEtudiant}", method=RequestMethod.GET)
	public ModelAndView modifierEtudiant(@PathVariable("idEtudiant") long idEtudiant) {
		
		Etudiant etudiantModif = etudiantService.findById(idEtudiant);
		Adresse adresseModif = etudiantModif.getAdresse();
		Promotion promotionModif = etudiantModif.getPromo();
		
		Map<String, Object> commandeModif = new HashMap<String, Object>();
		commandeModif.put("modifEtudiantAttribute", etudiantModif);
		commandeModif.put("modifAdresseAttribute", adresseModif);
		commandeModif.put("modifPromotionAttribute", promotionModif);
		
		return new ModelAndView("modif-etudiant", commandeModif);
		
	}//end modifierEtudiant()
	
	/**
	 * ajoute l'étudiant à la bdd à partir des rensaignements du formulaire
	 * @param etudiant
	 * @param adresse
	 * @param promotion
	 * @return
	 */
	@RequestMapping(value="/etu/updateetu", method=RequestMethod.POST)
	public String updateEtudiant(@ModelAttribute("etudiantAttribute")@Validated Etudiant etudiant, @ModelAttribute("adresseAttribute")@Validated Adresse adresse, @ModelAttribute("promotionAttribute")@Validated Promotion promotion) {
		
		etudiantService.modifier(etudiant);
		
		return "redirect:/etu/listeetu";
		
	}//end updateEtudiant()

}
