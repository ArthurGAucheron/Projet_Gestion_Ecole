package com.intiformation.gestionecole.presentation;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.intiformation.gestionecole.modele.Matiere;
import com.intiformation.gestionecole.service.MatiereServiceImpl;

public class AppTestDAO {

	public static void main(String[] args) {

		// instanciation du conteneur IoC de spring
		ApplicationContext conteneurIoCSpring = new ClassPathXmlApplicationContext("applicationContext.xml");
		

		
		//recup du bean de la couche service
		MatiereServiceImpl matiereService = (MatiereServiceImpl) conteneurIoCSpring.getBean("matiereServiceBean");
		
		//ajout à la bdd
		Matiere matiere1 = new Matiere();
		Matiere matiere2 = new Matiere();
		Matiere matiere3 = new Matiere();
		
		matiereService.ajouter(matiere1);
		matiereService.ajouter(matiere2);
		matiereService.ajouter(matiere3);
		
		List<Matiere> listeMatieres = matiereService.findAll();
		
		System.out.println("\n+++++++++++++++++++++++++++++++++++++++++++++++");
		for (Matiere mat : listeMatieres) {
			System.out.println("\t > " +mat);
		}
		System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
		
		
	}//end main

}//end class
