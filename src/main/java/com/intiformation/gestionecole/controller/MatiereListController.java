package com.intiformation.gestionecole.controller;


import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.intiformation.gestionecole.modele.Matiere;
import com.intiformation.gestionecole.service.MatiereServiceImpl;

@Controller
@RequestMapping("/matiereList*")
public class MatiereListController {

	// declaration du service (dao)
	private MatiereServiceImpl matiereServiceImpl;

	@Autowired // ctor pr injection
	public MatiereListController(MatiereServiceImpl matiereServiceImpl) {
		this.matiereServiceImpl = matiereServiceImpl;
	}

	@GetMapping
	public String generateList(Model model) {

		List<Matiere> matieres = Collections.emptyList();
		
		matieres = matiereServiceImpl.findAll();

		model.addAttribute("matieresAttribute", matieres);

		return "matiereList";

	}// end generateList()

}// end class
