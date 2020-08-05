package com.intiformation.gestionecole.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.gestionecole.modele.Administrateur;
import com.intiformation.gestionecole.modele.Adresse;
import com.intiformation.gestionecole.modele.Enseignant;
import com.intiformation.gestionecole.service.AdresseServiceImpl;
import com.intiformation.gestionecole.service.EnseignantServiceImpl;

/**
 * <pre>
 * 	Controller permettant de gérer les enseignants
 * </pre>
 * @author arthu
 *
 */
@Controller
public class GestionEnseignantController {

	@Autowired
	EnseignantServiceImpl enseignantService;

	public void setEnseignantService(EnseignantServiceImpl enseignantService) {
		this.enseignantService = enseignantService;
	}
	
	@Autowired
	AdresseServiceImpl adresseService;

	public void setAdresseService(AdresseServiceImpl adresseService) {
		this.adresseService = adresseService;
	}
	
	@RequestMapping(value="/admin/listeenseignant" , method=RequestMethod.GET)
	public String recupererListAdmin(ModelMap model) {
		
		List<Enseignant> listeEnseignantBD = enseignantService.findAll();
		
		model.addAttribute("attribut_liste_enseignant_bdd", listeEnseignantBD);
		
		return "gestion-enseignant";
		
	}// end recupererListAdmin()
	
	@RequestMapping(value="/admin/formens", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireAjout() {
		
		Enseignant ens = new Enseignant();
		Adresse adresse = new Adresse();
		
		Map<String, Object> donneesCommande = new HashMap<String, Object>();
		donneesCommande.put("attributEns", ens);
		donneesCommande.put("attributAdresse", adresse);
		
		return new ModelAndView("ajouter-enseignant", donneesCommande);
		
	}// end initaliserAdmin()
	
	@RequestMapping(value="/admin/addens",method=RequestMethod.POST)
	public String ajouteAdmin(@ModelAttribute("attributEns")@Validated Enseignant pEnseignant,
								@ModelAttribute("attributAdresse")@Validated Adresse pAdresse) {
		
		adresseService.ajouter(pAdresse);
		enseignantService.ajouter(pEnseignant);
		return "redirect:/admin/listeenseignant";
	}// end ajouteAdmin
	
	@RequestMapping(value="/admin/supp/ens/{ensId}", method=RequestMethod.GET)
	public String supprimerAdmin(@PathVariable("ensId") Long pIdEnseignant) {
		
		enseignantService.supprimer(pIdEnseignant);
		
		return "redirect:/admin/listeenseignant";
	}// end supprimerAdmin() 
	
	

	@RequestMapping(value="/admin/formmodifens/{ensId}" , method=RequestMethod.GET)
	public ModelAndView afficherFormModifAdmin(@PathVariable("ensId") Long pIdEnseignant ){
		
		Enseignant enseignantAModifier = enseignantService.findById(pIdEnseignant);
		Adresse adresseAModifier = enseignantAModifier.getAdresse();
		Map<String, Object> donneesCommandeModif = new HashMap<String, Object>();
		donneesCommandeModif.put("attrtibutEnseignantModif",enseignantAModifier);
		donneesCommandeModif.put("attrtibutAdresseModif", adresseAModifier);
		
		return new ModelAndView("modif-enseignant",donneesCommandeModif);
	}// end afficherFormModifAdmin()
	
	@RequestMapping(value="/admin/updateens", method=RequestMethod.POST)
	public String modifierAdministrateur(@ModelAttribute("attrtibutEnseignantModif")@Validated Enseignant pEnseignant, 
										 @ModelAttribute("attrtibutAdresseModif")@Validated Adresse pAdresse) {
		
		enseignantService.modifier(pEnseignant);
		
		
		return "redirect:/admin/listeenseignant";
	}// end class
}// end classe
