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
import com.intiformation.gestionecole.service.MatiereServiceImpl;

@Controller
public class GestionMatiereController {

	@Autowired
	private MatiereServiceImpl matiereService;

	public void setMatiereService(MatiereServiceImpl matiereService) {
		this.matiereService = matiereService;
	}

	@RequestMapping(value = "/matieres/liste", method = RequestMethod.GET)
	public String recupererListeMatiere(ModelMap model) {

		List<Matiere> listeMatiere = matiereService.findAll();

		model.addAttribute("attribut_liste_matiere_bdd", listeMatiere);

		return "gestion-matiere";

	}// end recupererListeMatiere

	@RequestMapping(value = "/formadd/matiere", method = RequestMethod.GET)
	public ModelAndView afficherFormulaireAjout() {

		Matiere matiere = new Matiere();

		Map<String, Object> donneesCommande = new HashMap<String, Object>();
		donneesCommande.put("attributMatiere", matiere);

		return new ModelAndView("ajouter-matiere", donneesCommande);
	} // afficherFormulaireAjout

	@RequestMapping(value = "/matieres/add", method = RequestMethod.POST)
	public String ajoutMatiere(@ModelAttribute("attributMatiere") @Validated Matiere pMatiere) {

		matiereService.ajouter(pMatiere);

		return "redirect:/matieres/liste";
	}

	@GetMapping(value = "/matieres/update-matiere-form")
	public ModelAndView afficherFormulaireModification(@RequestParam("idMatiere") Long pMatiereID) {

		Matiere matiereAModifier = matiereService.findById(pMatiereID);

		return new ModelAndView("modifier-matiere", "matiereModifCommand", matiereAModifier);

	}// end afficherFormulaireModification()

	@RequestMapping(value = "/matieres/update", method = RequestMethod.POST)
	public String modifierMatiereBDD(@ModelAttribute("matiereModifCommand") Matiere pMatiereToUpdate, ModelMap model) {

		matiereService.modifier(pMatiereToUpdate);

		List<Matiere> listeMatieresBDD = matiereService.findAll();

		model.addAttribute("attribut_liste_matieres", listeMatieresBDD);

		return "redirect:/matieres/liste";

	}// end modifierMatiereBDD()

	@GetMapping(value = "/matieres/delete/{matiere-id}")
	public String supprimerMatiereBdd(@PathVariable("matiere-id") Long pIdMatiere, ModelMap model) {

		matiereService.supprimer(pIdMatiere);

		List<Matiere> listeMatieresBDD = matiereService.findAll();

		model.addAttribute("attribut_liste_matieres", listeMatieresBDD);

		return "redirect:/matieres/liste";

	}// end supprimerMatiereBdd()

}// end class
