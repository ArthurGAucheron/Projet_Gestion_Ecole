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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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
	
	@RequestMapping(value="/liste/matiere", method=RequestMethod.GET)
	public String recupererListeMatiere(ModelMap model) {
		
		List<Matiere> listeMatiere = matiereService.findAll();
		
		model.addAttribute("attribut_liste_matiere_bdd", listeMatiere);
		
		return "gestion-matiere";
	
	}// end recupererListeMatiere
	
	
	@RequestMapping(value="/formadd/matiere", method=RequestMethod.GET)
	public ModelAndView afficherFormulaireAjout() {
		
		Matiere matiere = new Matiere();
		
		Map<String, Object> donneesCommande = new HashMap<String, Object>();
		donneesCommande.put("attributMatiere", matiere);
		
	
		return  new ModelAndView("ajouter-matiere",donneesCommande);
	} // afficherFormulaireAjout
	
	@RequestMapping(value="/matieres/add",method=RequestMethod.POST)
	public String ajoutMatiere(@ModelAttribute("attributMatiere")@Validated Matiere pMatiere) {
		
			matiereService.ajouter(pMatiere);
			
			return "redirect:/liste/matiere";
		}

	
}// end class
