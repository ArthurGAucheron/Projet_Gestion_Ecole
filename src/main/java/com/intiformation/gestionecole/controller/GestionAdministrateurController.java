package com.intiformation.gestionecole.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.intiformation.gestionecole.service.AdministrateurServiceImpl;

@Controller
public class GestionAdministrateurController {

	@Autowired
	private AdministrateurServiceImpl adminService;
	public void setAdminService(AdministrateurServiceImpl adminService) {
		this.adminService = adminService;
	}
	
	
	
}// end class
