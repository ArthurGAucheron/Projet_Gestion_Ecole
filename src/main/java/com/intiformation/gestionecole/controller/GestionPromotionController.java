package com.intiformation.gestionecole.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;

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

@Controller
public class GestionPromotionController {

	@Autowired
	private PromotionServiceImpl promotionService;

	public void setMatiereService(PromotionServiceImpl promotionService) {
		this.promotionService = promotionService;
	}

	@RequestMapping(value = "/admin/listepromo", method = RequestMethod.GET)
	public String recupererListePromotion(ModelMap model) {

		Promotion promotion = new Promotion();
		List<Promotion> listePromotion = promotionService.findAll();

		model.addAttribute("attribut_liste_promotion_bdd", listePromotion);
		model.addAttribute("attributPromotion", promotion);

		return "gestion-promotion";

	}// end recupererListeMatiere


	@RequestMapping(value = "/admin/addpromo", method = RequestMethod.POST)
	public String ajoutMatiere(@ModelAttribute("attributPromotion") @Validated Promotion pPromotion) {

		promotionService.ajouter(pPromotion);

		return "redirect:/admin/listepromo";
	}

	@GetMapping(value = "/admin/formodifpromo/{idPromotion}")
	public ModelAndView afficherFormulaireModification(@RequestParam("idPromotion") Long pPromotionID) {

		Promotion promotionAModifier = promotionService.findById(pPromotionID);

		return new ModelAndView("modifier-promotion", "promotionModifCommand", promotionAModifier);

	}// end afficherFormulaireModification()

	@RequestMapping(value = "/admin/updatepromo", method = RequestMethod.POST)
	public String modifierPromotionBDD(@ModelAttribute("promotionModifCommand") Promotion pPromotionToUpdate, ModelMap model) {

		promotionService.modifier(pPromotionToUpdate);

		List<Promotion> listePromotionsBDD = promotionService.findAll();

		model.addAttribute("attribut_liste_promotions", listePromotionsBDD);

		return "redirect:/admin/listepromo";

	}// end modifierPromotionBDD()

	@GetMapping(value = "/admin/supp/promo/{promotion-id}")
	public String supprimerPromotionBdd(@PathVariable("promotion-id") Long pIdPromotion, ModelMap model) {

		promotionService.supprimer(pIdPromotion);

		List<Promotion> listePromotionsBDD = promotionService.findAll();

		model.addAttribute("attribut_liste_promotions", listePromotionsBDD);

		return "redirect:/admin/listepromo";

	}// end supprimerMatiereBdd()

}// end class