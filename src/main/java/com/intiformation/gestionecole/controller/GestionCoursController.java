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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.gestionecole.modele.Cours;
import com.intiformation.gestionecole.modele.Matiere;
import com.intiformation.gestionecole.modele.Promotion;
import com.intiformation.gestionecole.service.CoursServiceImpl;
import com.intiformation.gestionecole.service.MatiereServiceImpl;
import com.intiformation.gestionecole.service.PromotionServiceImpl;

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
	
	@Autowired
	private PromotionServiceImpl promotionService;
	public void setPromotionService(PromotionServiceImpl promotionService) {
		this.promotionService = promotionService;
	}


	@RequestMapping(value="/cours/liste", method=RequestMethod.GET)
	public String recupererListeCours(ModelMap model) {
		
		List<Cours> listeCours = coursService.findAll();
		
		model.addAttribute("attribut_liste_cours_bdd", listeCours);
		
		return "gestion-cours";
	
	}// end recupererListeMatiere
	
	
	@RequestMapping(value="/formadd/cours", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireAjout() {
		
		Cours cours = new Cours();
		List<Matiere> matieresList = matiereService.findAll();
		List<Promotion> promotionsList = promotionService.findAll();
		
		Map<String, Object> donneesCommande = new HashMap<String, Object>();
		donneesCommande.put("attributCours", cours);
		donneesCommande.put("attributMatiere", matieresList);
		donneesCommande.put("attributPromotion", promotionsList);
		
		return  new ModelAndView("ajouter-cours",donneesCommande);
	} // afficherFormulaireAjout
	
	@PostMapping(value="/cours/add")
	public String ajoutCours(@ModelAttribute("attributCours")Cours pCours) {
		
			coursService.ajouter(pCours);
			
			return "redirect:/cours/liste";
		}

	
	
	
}// end class
