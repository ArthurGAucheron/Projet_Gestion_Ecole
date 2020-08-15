package com.intiformation.gestionecole.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.gestionecole.modele.Etudiant;
import com.intiformation.gestionecole.modele.Promotion;
import com.intiformation.gestionecole.service.AdresseServiceImpl;
import com.intiformation.gestionecole.service.EtudiantServiceImpl;
import com.intiformation.gestionecole.service.IEtudiantService;
import com.intiformation.gestionecole.service.PromotionServiceImpl;
import com.intiformation.gestionecole.validator.PersonneValidator;

@Controller
public class GestionEtudiantController {
	
	@Autowired
	private IEtudiantService etudiantService;

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

	@Autowired
	private PersonneValidator personneValidator;
	public void setPersonneValidator(PersonneValidator personneValidator) {
		this.personneValidator = personneValidator;
	}
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	/**
	 * fonction lancé à l'affichage de la page des étudiants
	 * @param modelMap
	 * @return
	 */
	@RequestMapping(value="/admin/listeetudiant", method=RequestMethod.GET)
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
	@RequestMapping(value="/admin/formetu", method=RequestMethod.GET)
	public ModelAndView ajouterEtudiant() {
		
		Etudiant etudiant = new Etudiant();
		List<Promotion> promotions = promotionService.findAll();
		
		Map<String, Object> donneesCommande = new HashMap<String, Object>();
		donneesCommande.put("etudiantAttribute", etudiant);
		donneesCommande.put("promotionAttribute", promotions);
		
		return new ModelAndView("ajouter-etudiant", donneesCommande);
		
	}//end ajouterEtudiant()
	
	/**
	 * ajoute l'étudiant à la bdd à partir des rensaignements du formulaire
	 * @param etudiant
	 * @param adresse
	 * @param promotion
	 * @return
	 */
	@RequestMapping(value="/admin/addetu", method=RequestMethod.POST)
	public String addEtudiant(@ModelAttribute("etudiantAttribute") Etudiant etudiant, @RequestParam("file") MultipartFile file,
			BindingResult resultatValidation) {
		
		personneValidator.validate(etudiant, resultatValidation);
		
		if (!file.isEmpty()) {
			try {
				etudiant.setPhoto(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if (resultatValidation.hasErrors()) {
			
			return "ajouter-etudiant";
		} else {

			etudiant.setMotdePasse(passwordEncoder.encode(etudiant.getMotdePasse()));
			etudiantService.ajouter(etudiant);
			
			return "redirect:/admin/listeetudiant";
		}
		
		
	}//end addEtudiant()
	
	@RequestMapping(value="/admin/supp/etu/{idEtudiant}", method=RequestMethod.GET)
	public String supprimerEtudiant(@PathVariable("idEtudiant") long idEtudiant) {
		
		etudiantService.supprimer(idEtudiant);
		
		return "redirect:/admin/listeetudiant";
		
	}//end supprimerEtudiant()
	
	/**
	 * fonction renvoyant vers la page "modifier-etudiant"
	 * 
	 * > affiche le formulaire
	 * @param idEtudiant
	 * @return
	 */
	@RequestMapping(value="/admin/formmodifetu/{idEtudiant}", method=RequestMethod.GET)
	public ModelAndView modifierEtudiant(@PathVariable("idEtudiant") long idEtudiant) {
		
		Etudiant etudiantModif = etudiantService.findById(idEtudiant);
		List<Promotion> promotions = promotionService.findAll();
		
		Map<String, Object> commandeModif = new HashMap<String, Object>();
		commandeModif.put("modifEtudiantAttribute", etudiantModif);
		commandeModif.put("promotionAttribute", promotions);
		
		return new ModelAndView("modif-etudiant", commandeModif);
		
	}//end modifierEtudiant()
	
	/**
	 * ajoute l'étudiant à la bdd à partir des rensaignements du formulaire
	 * @param etudiant
	 * @param adresse
	 * @param promotion
	 * @return
	 */
	@RequestMapping(value="/admin/updateetu", method=RequestMethod.POST)
	public String updateEtudiant(@ModelAttribute("etudiantAttribute")@Validated Etudiant etudiant,  @RequestParam("file") MultipartFile file) {
		
		if (!file.isEmpty()) {
			try {
				etudiant.setPhoto(file.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		etudiantService.modifier(etudiant);
		
		return "redirect:/admin/listeetudiant";
		
	}//end updateEtudiant()

}
