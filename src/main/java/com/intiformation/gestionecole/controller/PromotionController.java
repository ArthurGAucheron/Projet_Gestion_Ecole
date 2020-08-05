package com.intiformation.gestionecole.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.intiformation.gestionecole.modele.Cours;
import com.intiformation.gestionecole.modele.Etudiant;
import com.intiformation.gestionecole.modele.Matiere;
import com.intiformation.gestionecole.service.ICoursService;
import com.intiformation.gestionecole.service.IEtudiantService;
import com.intiformation.gestionecole.service.IPromotionService;

@Controller
public class PromotionController {


	// déclaration de la couche service
		@Autowired // injection du bean de la couche service dans cette prop
		@Qualifier("promotionServiceBean")
		private IPromotionService promotionService;
		
		@Autowired 
		@Qualifier("etudiantServiceBean")
		private IEtudiantService etudiantService;

		@Autowired 
		@Qualifier("coursServiceBean")
		private ICoursService coursService;

		// setter pour injection spring
		public void setMatiereService(@Qualifier("promotionServiceBean") IPromotionService promotionService) {
			this.promotionService = promotionService;
		}

		public void setMatiereService(@Qualifier("etudiantServiceBean") IEtudiantService etudiantService) {
			this.etudiantService = etudiantService;
		}
		
		public void setCoursService(@Qualifier("coursServiceBean") ICoursService coursService) {
			this.coursService = coursService;
		}
		
		/*
		 * +++++++++ Méthodes gestionnaires du controleur ++++++++++
		 */
		
		@GetMapping(value = "/promotions/liste")
		public String recupererListePromotionsBdd(ModelMap model) {

			// recup de la liste des promos dans la bd via le service
						
			List<Etudiant> listeEtudiantsBDD = etudiantService.findAll();
			List<Cours> listeCoursBDD = coursService.findAll();

			// renvoi de la liste vers la vue via l'objet model
			model.addAttribute("attribut_liste_etudiants", listeEtudiantsBDD);
			model.addAttribute("attribut_liste_cours", listeCoursBDD);

			// renvoi du nom logique de la vue
			return "liste-promotions";

		}// end recupererListeCoursBdd()
		
		@GetMapping(value = "/matieres/add-matiere-form")
		public ModelAndView afficherFormulaireAjout() {

			// définition d'un objet de commande qui va permettre la liaison avec les champs
			// du formulaire

			// objet vide
			Matiere matiere = new Matiere();

			// affectation d'un nom à cet objet
			String nomObjetCommande = "matiereCommand";

			// envoi de l'objet de commande vers la vue (page du formulaire)
			Map<String, Object> dataCommand = new HashMap<>();
			dataCommand.put(nomObjetCommande, matiere);

			// definition du nom logique de la vue
			String viewName = "ajouter-matiere";

			// envoi de l'objet ModelAndVienw vers la servlet DispatcherServlet

			return new ModelAndView(viewName, dataCommand);

		}// end afficherFormulaireAjout()

	
}//end class
