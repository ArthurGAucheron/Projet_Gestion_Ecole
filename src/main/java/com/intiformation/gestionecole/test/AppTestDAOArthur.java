package com.intiformation.gestionecole.test;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intiformation.gestionecole.modele.Administrateur;
import com.intiformation.gestionecole.modele.Adresse;
import com.intiformation.gestionecole.service.AdministrateurServiceImpl;
import com.intiformation.gestionecole.service.AdresseServiceImpl;
/**
 * AppTest DAO (classe Administrateur)
 * @author Arthur.GA
 *
 */
public class AppTestDAOArthur {

	public static void main(String[] args) {
		
		ApplicationContext conteneurSpring = new ClassPathXmlApplicationContext("applicationContextForTest.xml");
		AdministrateurServiceImpl adminService = (AdministrateurServiceImpl) conteneurSpring.getBean("adminServiceBean");
		AdresseServiceImpl adresseService = (AdresseServiceImpl) conteneurSpring.getBean("adresseServiceBean");
		
		Adresse adresse1 = new Adresse("cul de sac", "56000", "Poitiers");
		Adresse adresse2 = new Adresse("cul de sac", "56000", "Poitiers");
		
		adresseService.ajouter(adresse1);
		adresseService.ajouter(adresse2);
		
		
		
		
		Administrateur admin1 = new Administrateur("George123", "123", "Dauphin", "George", "george@gmail.com", adresse1);
		Administrateur admin2 = new Administrateur("Pierre123", "321", "Lion", "Pierre", "pierre@gmail.com", adresse2);

		adminService.ajouter(admin1);
		adminService.ajouter(admin2);
		
		List<Adresse> listeAdresse = adresseService.findAll();
		System.out.println("\nListe des adresse dans la bdd +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		for (Adresse adresse : listeAdresse) {
			System.out.println("\t > " + adresse.getRue() + " " + adresse.getVille() + " " + adresse.getCodePostal());
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		List<Administrateur> listeAdmin = adminService.findAll();
		
		System.out.println("\nListe des Administrateur dans la bdd +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		for (Administrateur admin : listeAdmin) {
			System.out.println("\t > " + admin.getPrenom() + " " + admin.getNom() + " " + admin.getIdentifiant() + " " + 
					admin.getEmail() + " " + admin.getMotdePasse());
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
	
		admin1.setPrenom("Rachid");
		admin1.setIdentifiant("Rachid123");
		
		adminService.modifier(admin1);
		Administrateur adminModifié = adminService.findById(1L);
		System.out.println("\nListe des Administrateur dans la bdd +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		System.out.println("\t > " + adminModifié.getPrenom() + " " + adminModifié.getNom() + " " + adminModifié.getIdentifiant() + " " + 
				adminModifié.getEmail() + " " + adminModifié.getMotdePasse());
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
		
		adminService.supprimer(2L);
		List<Administrateur> listeAdmin2 = adminService.findAll();
		
		System.out.println("\nListe des Administrateur dans la bdd après suppréssion id 2 +++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
		for (Administrateur admin : listeAdmin2) {
			System.out.println("\t > " + admin.getPrenom() + " " + admin.getNom() + " " + admin.getIdentifiant() + " " + 
					admin.getEmail() + " " + admin.getMotdePasse());
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++\n");
	
	}// end main
	
}// end class
