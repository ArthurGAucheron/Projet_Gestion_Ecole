package com.intiformation.gestionecole.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.gestionecole.modele.Cours;
import com.intiformation.gestionecole.modele.Matiere;
import com.intiformation.gestionecole.service.CoursServiceImpl;
import com.intiformation.gestionecole.service.MatiereServiceImpl;

@Controller
public class GestionCoursController {

	
	@Autowired
	private CoursServiceImpl coursService;

	public void setCoursService(CoursServiceImpl coursService) {
		this.coursService = coursService;
	}
	
	@Autowired
	private MatiereServiceImpl matiereService;
	public void setMatiereService(MatiereServiceImpl matiereService) {
		this.matiereService = matiereService;
	}


	@RequestMapping(value="/liste/cours", method=RequestMethod.GET)
	public String recupererListeCours(ModelMap model) {
		
		List<Cours> listeCours = coursService.findAll();
		
		model.addAttribute("attribut_liste_cours_bdd", listeCours);
		
		return "gestion-cours";
	
	}// end recupererListeMatiere
	
	
	@RequestMapping(value="/formadd/cours", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireAjout() {
		
		Cours cours = new Cours();
		List<Matiere> matieresList = matiereService.findAll();
		
		Map<String, Object> donneesCommande = new HashMap<String, Object>();
		donneesCommande.put("attributCours", cours);
		donneesCommande.put("attributMatiere", matieresList);
		
		return  new ModelAndView("ajouter-cours",donneesCommande);
	} // afficherFormulaireAjout
	
	@RequestMapping(value="/cours/add",method=RequestMethod.POST)
	public String ajoutCours(@ModelAttribute("attributCours")@Validated Cours pCours) {
		
			coursService.ajouter(pCours);
			
			return "redirect:/liste/cours";
		}

	
	
	
}// end class
