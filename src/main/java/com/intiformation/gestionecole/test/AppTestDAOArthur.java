package com.intiformation.gestionecole.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intiformation.gestionecole.modele.Administrateur;
import com.intiformation.gestionecole.service.AdministrateurServiceImpl;
/**
 * AppTest DAO (classe Administrateur)
 * @author Arthur.GA
 *
 */
public class AppTestDAOArthur {

	public static void main(String[] args) {
		
		ApplicationContext conteneurSpring = new ClassPathXmlApplicationContext("applicationContext.xml");
		AdministrateurServiceImpl adminService = (AdministrateurServiceImpl) conteneurSpring.getBean("adminServiceBean");
		
	
		Administrateur admin1 = new Administrateur("George123", "123", "Dauphin", "George", "george@gmail.com", 2L);
		Administrateur admin2 = new Administrateur("Pierre123", "321", "Lion", "Pierre", "pierre@gmail.com", 1L);

		adminService.ajouter(admin1);
		adminService.ajouter(admin2);
		
		List<Administrateur> listeAdmin = adminService.findAll();
		
		System.out.println("\nListe des Administrateur dans la bdd +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		for (Administrateur admin : listeAdmin) {
			System.out.println("\t > " + admin.toString());
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
	
		admin1.setPrenom("Rachid");
		admin1.setIdentifiant("Rachid123");
		
		adminService.modifier(admin1);
		Administrateur adminModifié = adminService.findById(1L);
		System.out.println("\nListe des Administrateur dans la bdd +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\t > " + adminModifié.toString());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		adminService.supprimer(2L);
		List<Administrateur> listeAdmin2 = adminService.findAll();
		
		System.out.println("\nListe des Administrateur dans la bdd après suppréssion id 2 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		for (Administrateur admin : listeAdmin2) {
			System.out.println("\t > " + admin.toString());
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
	
	}// end main
	
}// end class
