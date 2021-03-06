package com.intiformation.gestionecole.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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


import com.intiformation.gestionecole.modele.Enseignant;
import com.intiformation.gestionecole.modele.Matiere;
import com.intiformation.gestionecole.service.EnseignantServiceImpl;
import com.intiformation.gestionecole.service.MatiereServiceImpl;

@Controller
public class GestionMatiereController {

	@Autowired
	private MatiereServiceImpl matiereService;

	public void setMatiereService(MatiereServiceImpl matiereService) {
		this.matiereService = matiereService;
	}
	
	@Autowired
	private EnseignantServiceImpl enseignantService;
	public void setEnseignantService(EnseignantServiceImpl enseignantService) {
		this.enseignantService = enseignantService;
	}

	@RequestMapping(value = "/admin/listemat", method = RequestMethod.GET)
	public String recupererListeMatiere(ModelMap model) {

		List<Matiere> listeMatiere = matiereService.findAll();

		model.addAttribute("attribut_liste_matiere_bdd", listeMatiere);

		return "gestion-matiere";

	}// end recupererListeMatiere

	@RequestMapping(value = "/admin/formatiere", method = RequestMethod.GET)
	public ModelAndView afficherFormulaireAjout() {

		Matiere matiere = new Matiere();
		List<Enseignant> listeEnseignant = enseignantService.findAll();

		Map<String, Object> donneesCommande = new HashMap<String, Object>();
		donneesCommande.put("attributMatiere", matiere);
		donneesCommande.put("attributEnseignant", listeEnseignant);

		return new ModelAndView("ajouter-matiere", donneesCommande);
	} // afficherFormulaireAjout

	@RequestMapping(value = "/admin/addmatiere", method = RequestMethod.POST)
	public String ajoutMatiere(@ModelAttribute("attributMatiere") @Validated Matiere pMatiere) {

		matiereService.ajouter(pMatiere);

		return "redirect:/admin/listemat";
	}

	@GetMapping(value = "/admin/formodifmat/{idMatiere}")
	public ModelAndView afficherFormulaireModification(@PathVariable("idMatiere") Long pMatiereID) {

		Matiere matiereAModifier = matiereService.findById(pMatiereID);
		List<Enseignant> listeEnseignant = enseignantService.findAll();
		Map<String, Object> donneesCommande = new HashMap<String, Object>();
		donneesCommande.put("matiereModifCommand", matiereAModifier);
		donneesCommande.put("attributEnseignant", listeEnseignant);
		
		return new ModelAndView("modif-matiere", donneesCommande );

	}// end afficherFormulaireModification()

	@RequestMapping(value = "/admin/updatemat", method = RequestMethod.POST)
	public String modifierMatiereBDD(@ModelAttribute("matiereModifCommand") Matiere pMatiereToUpdate, ModelMap model) {

		matiereService.modifier(pMatiereToUpdate);

		List<Matiere> listeMatieresBDD = matiereService.findAll();

		model.addAttribute("attribut_liste_matieres", listeMatieresBDD);

		return "redirect:/admin/listemat";

	}// end modifierMatiereBDD()

	@GetMapping(value = "/admin/supp/mat/{matiere-id}")
	public String supprimerMatiereBdd(@PathVariable("matiere-id") Long pIdMatiere, ModelMap model) {

		matiereService.supprimer(pIdMatiere);

		List<Matiere> listeMatieresBDD = matiereService.findAll();

		model.addAttribute("attribut_liste_matieres", listeMatieresBDD);

		return "redirect:/admin/listemat";

	}// end supprimerMatiereBdd()

}// end class
