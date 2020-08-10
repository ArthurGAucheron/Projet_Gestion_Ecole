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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


import com.intiformation.gestionecole.modele.Promotion;

import com.intiformation.gestionecole.service.PromotionServiceImpl;

import com.intiformation.gestionecole.validator.PromotionValidator;

@Controller
public class GestionPromotionController {

	@Autowired
	private PromotionServiceImpl promotionService;

	public void setMatiereService(PromotionServiceImpl promotionService) {
		this.promotionService = promotionService;
	}
	
	// declaration du validator
		@Autowired
		private PromotionValidator promotionValidator;

		// setter du validateur
		public void setCoursValidator(PromotionValidator promotionValidator) {
			this.promotionValidator = promotionValidator;
		}

	@RequestMapping(value = "/promotions/liste", method = RequestMethod.GET)
	public String recupererListePromotion(ModelMap model) {

		List<Promotion> listePromotion = promotionService.findAll();

		model.addAttribute("attribut_liste_promotion_bdd", listePromotion);

		return "gestion-promotion";

	}// end recupererListeMatiere

	@RequestMapping(value = "/formadd/promotion", method = RequestMethod.GET)
	public ModelAndView afficherFormulaireAjout() {

		Promotion promotion = new Promotion();

		Map<String, Object> donneesCommande = new HashMap<String, Object>();
		donneesCommande.put("attributPromotion", promotion);

		return new ModelAndView("ajouter-promotion", donneesCommande);
	} // afficherFormulaireAjout

	@RequestMapping(value = "/promotions/add", method = RequestMethod.POST)
	public String ajoutPromotion(@ModelAttribute("attributPromotion") @Validated Promotion pPromotion,ModelMap model,
			BindingResult resultatValidation) {

		promotionValidator.validate(pPromotion, resultatValidation);

		if (resultatValidation.hasErrors()) {

			return "ajouter-promotion";

		} else {
			promotionService.ajouter(pPromotion);

			model.addAttribute("attribut_liste_promotions", promotionService.findAll());

			return "redirect:/promotions/liste";

		} // end else
	}

	@GetMapping(value = "/promotions/update-promotion-form")
	public ModelAndView afficherFormulaireModification(@RequestParam("idPromotion") Long pPromotionID) {

		Promotion promotionAModifier = promotionService.findById(pPromotionID);

		return new ModelAndView("modifier-promotion", "promotionModifCommand", promotionAModifier);

	}// end afficherFormulaireModification()

	@RequestMapping(value = "/promotions/update", method = RequestMethod.POST)
	public String modifierPromotionBDD(@ModelAttribute("promotionModifCommand") Promotion pPromotionToUpdate, ModelMap model) {

		promotionService.modifier(pPromotionToUpdate);

		List<Promotion> listePromotionsBDD = promotionService.findAll();

		model.addAttribute("attribut_liste_promotions", listePromotionsBDD);

		return "redirect:/promotions/liste";

	}// end modifierPromotionBDD()

	@GetMapping(value = "/promotions/delete/{promotion-id}")
	public String supprimerPromotionBdd(@PathVariable("promotion-id") Long pIdPromotion, ModelMap model) {

		promotionService.supprimer(pIdPromotion);

		List<Promotion> listePromotionsBDD = promotionService.findAll();

		model.addAttribute("attribut_liste_promotions", listePromotionsBDD);

		return "redirect:/promotions/liste";

	}// end supprimerMatiereBdd()

}// end class