package com.intiformation.gestionecole.controller;

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
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.gestionecole.modele.Administrateur;
import com.intiformation.gestionecole.modele.Adresse;
import com.intiformation.gestionecole.service.AdministrateurServiceImpl;
import com.intiformation.gestionecole.service.AdresseServiceImpl;
import com.intiformation.gestionecole.validator.PersonneValidator;
/**
 * <pre>
 * 	Controller permettant de gérer les administrateurs
 * </pre>
 * @author arthu
 *
 */
@Controller
public class GestionAdministrateurController {

	@Autowired
	private AdministrateurServiceImpl adminService;
	public void setAdminService(AdministrateurServiceImpl adminService) {
		this.adminService = adminService;
	}
	
	@Autowired
	private AdresseServiceImpl adresseService;
	public void setAdresseService(AdresseServiceImpl adresseService) {
		this.adresseService = adresseService;
	}
	
	@Autowired
	private PersonneValidator personneValidator;
	public void setPersonneValidator(PersonneValidator personneValidator) {
		this.personneValidator = personneValidator;
	}
	
	BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

	@RequestMapping(value="/admin/listeadmin" , method=RequestMethod.GET)
	public String recupererListAdmin(ModelMap model) {
		
		List<Administrateur> listeAdminBDD = adminService.findAll();
		
		model.addAttribute("attribut_liste_admin_bdd", listeAdminBDD);
		
		return "gestion-administrateur";
		
	}// end recupererListAdmin()
	
	@RequestMapping(value="/admin/formadmin", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireAjout() {
		
		Administrateur admin = new Administrateur();
		Adresse adresse = new Adresse();
		
		Map<String, Object> donneesCommande = new HashMap<String, Object>();
		donneesCommande.put("attributAdmin", admin);
		donneesCommande.put("attributAdresse", adresse);
		
		return new ModelAndView("ajouter-admin", donneesCommande);
		
	}// end initaliserAdmin()
	
	@RequestMapping(value="/admin/addadmin",method=RequestMethod.POST)
	public String ajouteAdmin(@ModelAttribute("attributAdmin")@Validated Administrateur pAdmin,
								BindingResult resultatValidation) {
		
		personneValidator.validate(pAdmin, resultatValidation);
		
		if (resultatValidation.hasErrors()) {
			
			return "ajouter-admin";
			
		}else {
			pAdmin.setMotdePasse(passwordEncoder.encode(pAdmin.getMotdePasse()));
			adminService.ajouter(pAdmin);
			
			return "redirect:/admin/listeadmin";
		}
	}// end ajouteAdmin
	
	@RequestMapping(value="/admin/supp/admin/{adminId}", method=RequestMethod.GET)
	public String supprimerAdmin(@PathVariable("adminId") Long pIdAdmin) {
		
		adminService.supprimer(pIdAdmin);
		
		return "redirect:/admin/listeadmin";
	}// end supprimerAdmin() 
	
	@RequestMapping(value="/admin/formmodifadmin/{adminId}" , method=RequestMethod.GET)
	public ModelAndView afficherFormModifAdmin(@PathVariable("adminId") Long pIdAdmin ){
		
		Administrateur adminAModifier = adminService.findById(pIdAdmin);
		Adresse adresseAModifier = adminAModifier.getAdresse();
		Map<String, Object> donneesCommandeModif = new HashMap<String, Object>();
		donneesCommandeModif.put("attrtibutAdminModif",adminAModifier);
		donneesCommandeModif.put("attrtibutAdresseModif", adresseAModifier);
		
		return new ModelAndView("modif-admin",donneesCommandeModif);
	}// end afficherFormModifAdmin()
	
	@RequestMapping(value="/admin/updateadmin", method=RequestMethod.POST)
	public String modifierAdministrateur(@ModelAttribute("attrtibutAdminModif")@Validated Administrateur pAdmin	) {
	
			adminService.modifier(pAdmin);
			
			return "redirect:/admin/listeadmin";
	
		
	
	}// end class
	
	
}// end class
