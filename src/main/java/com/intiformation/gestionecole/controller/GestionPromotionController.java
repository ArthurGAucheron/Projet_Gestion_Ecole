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

import com.intiformation.gestionecole.modele.Administrateur;
import com.intiformation.gestionecole.modele.Adresse;
import com.intiformation.gestionecole.modele.Matiere;
import com.intiformation.gestionecole.modele.Promotion;
import com.intiformation.gestionecole.service.MatiereServiceImpl;
import com.intiformation.gestionecole.service.PromotionServiceImpl;

@Controller
public class GestionPromotionController {

	@Autowired
	private PromotionServiceImpl promotionService;

	public void setMatiereService(PromotionServiceImpl promotionService) {
		this.promotionService = promotionService;
	}

	@RequestMapping(value = "/promotions/liste", method = RequestMethod.GET)
	public String recupererListePromotion(ModelMap model) {

		Promotion promotion = new Promotion();
		List<Promotion> listePromotion = promotionService.findAll();

		model.addAttribute("attribut_liste_promotion_bdd", listePromotion);
		model.addAttribute("attributPromotion", promotion);

		return "gestion-promotion";

	}// end recupererListeMatiere


	@RequestMapping(value = "/promotions/add", method = RequestMethod.POST)
	public String ajoutMatiere(@ModelAttribute("attributPromotion") @Validated Promotion pPromotion) {

		promotionService.ajouter(pPromotion);

		return "redirect:/promotions/liste";
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