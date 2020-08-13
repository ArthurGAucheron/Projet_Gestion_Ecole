package com.intiformation.gestionecole.modele;


import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * Classe adminisatrateur ui hérite de Personne
 * @author Arthur.GA
 *
 */
@Entity
@Table(name="administrateurs")
@DiscriminatorValue("admin")
public class Administrateur extends Personne{

	/*________________________________________________________ Propriétés _______________________________________________________*/

	/*_____________________________________________________ Constructeurs _______________________________________________________*/
	public Administrateur() {
	}

	public Administrateur(Long idPersonne, String identifiant, String motdePasse, String nom, String prenom,
			String email, Adresse adresse) {
		super(idPersonne, identifiant, motdePasse, nom, prenom, email, adresse);
	}

	public Administrateur(String identifiant, String motdePasse, String nom, String prenom, String email,
			Adresse adresse) {
		super(identifiant, motdePasse, nom, prenom, email, adresse);
	}

}
	
	
	/*_____________________________________________________ Getters/Setters _______________________________________________________*/
	
	
	
	