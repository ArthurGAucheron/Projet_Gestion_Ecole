package com.intiformation.gestionecole.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.gestionecole.modele.Aide;
import com.intiformation.gestionecole.service.AideServiceImpl;
import com.intiformation.gestionecole.validator.AideValidator;

/**
 * Controlleur de la Page Aide <br/>
 * La page Aide permet d'aider l'utilisateur à utiliser le site web <br/>
 * La page Web sera gérer par l'administrateur <br>
 * @author arthu
 *
 */
@Controller
public class GestionPageAideController {

	@Autowired
	private AideServiceImpl aideService;
	public void setAideService(AideServiceImpl aideService) {
		this.aideService = aideService;
	}
	
	@Autowired
	private AideValidator aideValidator;
	public void setAideValidator(AideValidator aideValidator) {
		this.aideValidator = aideValidator;
	}

	/**
	 * <pre>
	 * Permet d'afficher la page aide <br/>
	 * Permet de passer en attribut la liste des aides <br/>
	 * </pre>
	 * @return
	 */
	@RequestMapping(value="/aide", method=RequestMethod.GET)
	public String goToPageAide(ModelMap model) {
		
		Aide aide = new Aide();
		List<Aide> listeAide = aideService.findAll();
		
		model.addAttribute("attributAide", listeAide);
		model.addAttribute("AttributAideAjout",aide);
		
		
		return "gestion-aide";
	}// end goToPageAide
	
	@RequestMapping(value="/aide/admin/form" , method=RequestMethod.GET)
	public ModelAndView goToFormulaire() {
		
		Aide aide = new Aide();
		Map<String, Object> donneesAide = new HashMap<String, Object>();
		donneesAide.put("AttributAideAjout", aide);
		return new ModelAndView("ajouter-aide", donneesAide);
	}// end goToFormulaire
	
	@RequestMapping(value="aide/admin/add", method=RequestMethod.POST)
	public String ajouterAide(@ModelAttribute("AttributAideAjout")@Validated Aide pAide, BindingResult resultatValidation) {
		aideValidator.validate(pAide, resultatValidation);
		
		if (resultatValidation.hasErrors()) {
			return "aide";
		} else {
			
			aideService.ajouter(pAide);
			return "redirect:/aide";
		}
	}
	
	@RequestMapping(value="/aide/admin/delete/{idAide}", method=RequestMethod.GET)
	public String deleteAide(@PathVariable("idAide") Long pidAide) {
		
		aideService.supprimer(pidAide);
		
		return "redirect:/aide";
	}// end deleteAide()
	
	@RequestMapping(value="/aide/admin/update/{idAide}", method=RequestMethod.GET)
	public ModelAndView goToFormUpdate (@PathVariable("idAide") Long pidAide) {
		
		Aide aide = aideService.findById(pidAide);
		
		Map<String, Object> donneesAide = new HashMap<String, Object>();
		donneesAide.put("attributAideModif", aide);
	
		return new ModelAndView("/modif-aide", donneesAide);
	}// end goToFormUpdate
	
	@RequestMapping(value="/aide/admin/update", method=RequestMethod.POST)
	public String updateAide(@ModelAttribute("attributAideModif")@Validated Aide pAide) {
		
		aideService.modifier(pAide);
		
		return "redirect:/aide";
	}// end updateAide()
	
}// end class
