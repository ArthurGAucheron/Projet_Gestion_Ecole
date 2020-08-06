package com.intiformation.gestionecole.controller;

import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.gestionecole.modele.Cours;
import com.intiformation.gestionecole.modele.Matiere;
import com.intiformation.gestionecole.service.ICoursService;
import com.intiformation.gestionecole.service.IMatiereService;

@Controller
public class CoursController {

	// déclaration de la couche service
	@Autowired // injection du bean de la couche service dans cette prop
	@Qualifier("matiereServiceBean")
	private IMatiereService matiereService;

	@Autowired // injection du bean de la couche service dans cette prop
	@Qualifier("coursServiceBean")
	private ICoursService coursService;

	// setter pour injection spring
	public void setMatiereService(@Qualifier("matiereServiceBean") IMatiereService matiereService) {
		this.matiereService = matiereService;
	}

	public void setCoursService(@Qualifier("coursServiceBean") ICoursService coursService) {
		this.coursService = coursService;
	}

	/*
	 * +++++++++ Méthodes gestionnaires du controleur ++++++++++
	 */


	@RequestMapping(value = "/cours/liste", method = RequestMethod.GET)
	public String recupererListeCoursBdd(ModelMap model) {

		// recup de la liste des employes dans la bd via le service
		List<Cours> listeCoursBDD = coursService.findAll();

		// renvoi de la liste vers la vue via l'objet model
		model.addAttribute("attribut_liste_cours", listeCoursBDD);

		// renvoi du nom logique de la vue
		return "liste-cours";

	}// end recupererListeCoursBdd()


	@GetMapping(value = "/cours/add-cours-form")
	public ModelAndView afficherFormulaireAjout(ModelMap model) {

		// définition d'un objet de commande qui va permettre la liaison avec les champs
		// du formulaire
		model.addAttribute("attribut_liste_matieres", matiereService.findAll());

		// objet vide
		Cours cours = new Cours();
		Matiere matiere = new Matiere() ;

		// affectation d'un nom à cet objet
		String nomObjetCommande = "coursCommand";
		String nomMatiereCommande = "matiereCommand";

		// envoi de l'objet de commande vers la vue (page du formulaire)
		Map<String, Object> dataCommand = new HashMap<>();
		dataCommand.put(nomObjetCommande, cours);
		dataCommand.put(nomMatiereCommande, matiere);

		// definition du nom logique de la vue
		String viewName = "ajouter-cours";

		// envoi de l'objet ModelAndVienw vers la servlet DispatcherServlet

		return new ModelAndView(viewName, dataCommand);

	}// end afficherFormulaireAjout()


	@PostMapping(value = "/cours/add")
	public String ajouterCoursBDD(@ModelAttribute("coursCommand") Cours pCours, @ModelAttribute("matiereCommand")Matiere pMatiere, ModelMap model) {

		// Ajout à la bdd via la couche service
		
		
		
		pCours.setMatiere(pMatiere);
		coursService.ajouter(pCours);
		

		// redirection vers la page liste-matieres.jsp
		// recup de la nouvelle liste
		model.addAttribute("attribut_liste_cours", coursService.findAll());

		// => redirection vers la page d'accueil
		return "redirect:/cours/liste";

	}// ajouterMatiereBDD

}// end class
