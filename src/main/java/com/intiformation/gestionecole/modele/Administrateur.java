package com.intiformation.gestionecole.modele;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe adminisatrateur ui hérite de Personne
 * @author Arthur.GA
 *
 */
@Entity
@Table(name="administrateurs")
public class Administrateur extends Personne{

	/*________________________________________________________ Propriétés _______________________________________________________*/

	/*_____________________________________________________ Constructeurs _______________________________________________________*/
	public Administrateur() {
	}

	public Administrateur(long idPersonne, String identifiant, String motdePasse, String nom, String prenom,
			String email) {
		super(idPersonne, identifiant, motdePasse, nom, prenom, email);
	}

	public Administrateur(String identifiant, String motdePasse, String nom, String prenom, String email) {
		super(identifiant, motdePasse, nom, prenom, email);
	}

	

	
	/*_____________________________________________________ Getters/Setters _______________________________________________________*/
	
	
	
	
}// end class
