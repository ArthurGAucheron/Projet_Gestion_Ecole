package com.intiformation.gestionecole.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.intiformation.gestionecole.modele.Cours;
import com.intiformation.gestionecole.service.CoursServiceImpl;

/**
 * controller test pour le fonctionnement des méthodes de la DAO
 * @author pifle
 *
 */
@Controller
@RequestMapping("/coursliste")
public class CoursListController {
	
	private CoursServiceImpl coursService;

	@Autowired
	public CoursListController(CoursServiceImpl coursService) {
		super();
		this.coursService = coursService;
	}
	
	@GetMapping
	public String generate(Model model) {
		
		List<Cours> listeCours = coursService.findAll();
		
		model.addAttribute("coursAttribute", listeCours);
		
		return "coursliste";
		
	}//end generate()

}
