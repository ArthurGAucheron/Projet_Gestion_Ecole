package com.intiformation.gestionecole.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * <pre>
 * 	Controller de la page gestion-controller.jsp
 * <pre>
 * @author arthu
 *
 */

@Controller
public class GestionPersonnelController {

	@RequestMapping(value="/admin/gestionpersonnel", method=RequestMethod.GET )
	public String goToGestionPersonnel() {
	
		// renvoie du nom Logique
		return "gestion-personnel";
		
		
	}// end goToGestionPersonnel()
	
}// end class
