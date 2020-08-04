package com.intiformation.gestionecole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.intiformation.gestionecole.modele.Matiere;
import com.intiformation.gestionecole.service.IGeneriqueService;

@Controller
public class MatiereController {

	// déclaration de la couche service
	@Autowired // injection du bean de la couche service dans cette prop
	@Qualifier("matiereServiceBean")
	private IGeneriqueService<Matiere> matiereService;

	// setter pour injection spring
	public void setMatiereService(@Qualifier("matiereServiceBean")IGeneriqueService<Matiere> matiereService) {
		this.matiereService = matiereService;
	}
	
	
	@RequestMapping(value = "/matieres/liste", method = RequestMethod.GET)
	public String recupererListeMatieresBdd(ModelMap model) {

		// recup de la liste des employes dans la bd via le service
		List<Matiere> listeMatieresBDD = matiereService.findAll();

		// renvoi de la liste vers la vue via l'objet model
		model.addAttribute("attribut_liste_matieres", listeMatieresBDD);

		// renvoi du nom logique de la vue
		return "liste-matieres";

	}// end recupererListeEmployesBdd()

}// end class
