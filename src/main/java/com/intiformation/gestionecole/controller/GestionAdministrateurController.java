package com.intiformation.gestionecole.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.gestionecole.modele.Administrateur;
import com.intiformation.gestionecole.modele.Adresse;
import com.intiformation.gestionecole.service.AdministrateurServiceImpl;
import com.intiformation.gestionecole.service.AdresseServiceImpl;
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
								@ModelAttribute("attributAdresse")@Validated Adresse pAdresse) {
		
		adresseService.ajouter(pAdresse);
		adminService.ajouter(pAdmin);
		
		
		return "redirect:/admin/listeadmin";
	}// end ajouteAdmin
	
}// end class
