package com.intiformation.gestionecole.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.web.servlet.ModelAndView;

import com.intiformation.gestionecole.modele.Cours;
import com.intiformation.gestionecole.modele.Matiere;
import com.intiformation.gestionecole.modele.Promotion;
import com.intiformation.gestionecole.service.CoursServiceImpl;
import com.intiformation.gestionecole.service.MatiereServiceImpl;
import com.intiformation.gestionecole.service.PromotionServiceImpl;
import com.intiformation.gestionecole.validator.CoursValidator;

@Controller
public class GestionCoursController {

	@Autowired
	private CoursServiceImpl coursService;

	public void setCoursService(CoursServiceImpl coursService) {
		this.coursService = coursService;
	}

	// declaration du validator
	@Autowired
	private CoursValidator coursValidator;

	// setter du validateur
	public void setCoursValidator(CoursValidator coursValidator) {
		this.coursValidator = coursValidator;
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

	@RequestMapping(value = {"/admin/listecours","/ens/listecours"}, method = RequestMethod.GET)
	public String recupererListeCours(ModelMap model) {

		List<Cours> listeCours = coursService.findAll();

		model.addAttribute("attribut_liste_cours_bdd", listeCours);

		return "gestion-cours";

	}// end recupererListeCours
	
	
	@RequestMapping(value = "/etu/mesCours", method = RequestMethod.GET)
	public String recupererListeCoursParEtu(ModelMap model) {

		Long pIdEtu = (long) 5 /*à récuperer comme attribut de session;*/;
		List<Cours> listeCoursEtu = coursService.findCoursEtu(pIdEtu);

		model.addAttribute("attribut_liste_cours_bdd_ParEtu", listeCoursEtu);

		return "etu-mesCours";

	}// end recupererListeCours
	
	@RequestMapping(value ="/ens/mesCours", method = RequestMethod.GET)
	public String recupererListeCoursParEns(ModelMap model) {

		Long pIdEns = (long) 1 /*à récuperer comme attribut de session;*/;
		List<Cours> listeCoursEns = coursService.findCoursEns(pIdEns);

		model.addAttribute("attribut_liste_cours_bdd_ParEns", listeCoursEns);

		return "ens-mesCours";

	}// end recupererListeCours
	
	

	@RequestMapping(value = "/cours/formcours", method = RequestMethod.GET)
	public ModelAndView afficherFormulaireAjout() {

		Cours cours = new Cours();
		List<Matiere> matieresList = matiereService.findAll();
		List<Promotion> promotionsList = promotionService.findAll();

		Map<String, Object> donneesCommande = new HashMap<String, Object>();
		donneesCommande.put("attributCours", cours);
		donneesCommande.put("attributMatiere", matieresList);
		donneesCommande.put("attributPromotion", promotionsList);

		return new ModelAndView("ajouter-cours", donneesCommande);
	} // afficherFormulaireAjout

	@PostMapping(value = "/cours/addcours")
	public String ajoutCours(@ModelAttribute("attributCours") @Validated Cours pCours, ModelMap model,
			BindingResult resultatValidation) {

		coursValidator.validate(pCours, resultatValidation);

		if (resultatValidation.hasErrors()) {

			return "ajouter-cours";

		} else {
			coursService.ajouter(pCours);

			model.addAttribute("attribut_liste_cours", coursService.findAll());

			return "redirect:/cours/listecours";

		} // end else
	}// end ajoutCours

	@GetMapping(value = "/cours/formmodifcours/{coursId}")
	public ModelAndView afficherFormulaireModification(@RequestParam("coursId") Long pCoursID) {

		Cours coursAModifier = coursService.findById(pCoursID);

		return new ModelAndView("modif-cours", "coursModifCommand", coursAModifier);

	}// end afficherFormulaireModification()

	@RequestMapping(value = "/cours/updatecours", method = RequestMethod.POST)
	public String modifierCoursBDD(@ModelAttribute("coursModifCommand") Cours pCoursToUpdate, ModelMap model) {

		coursService.modifier(pCoursToUpdate);

		List<Cours> listeCoursBDD = coursService.findAll();

		model.addAttribute("attribut_liste_cours", listeCoursBDD);

		return "redirect:/cours/listecours";

	}// end modifierCoursBDD()

	@GetMapping(value="/cours/supp/cours/{coursId}")
	public String supprimerCoursBdd(@PathVariable("coursId") Long pIdCours, ModelMap model) {

		matiereService.supprimer(pIdCours);

		List<Cours> listeCoursBDD = coursService.findAll();

		model.addAttribute("attribut_liste_cours", listeCoursBDD);

		return "redirect:/cours/listecours";

	}// end supprimerCoursBdd()

}// end class
