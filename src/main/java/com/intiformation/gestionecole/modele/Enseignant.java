package com.intiformation.gestionecole.modele;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * modèle de données pour un Enseignant, hérite de la classe abstraite
 * 'Personne'
 * 
 * @author cam
 *
 */
@Entity
@Table(name = "enseignants")
@DiscriminatorValue("ens")
public class Enseignant extends Personne {

	public Enseignant() {
	}

	public Enseignant(Long idPersonne, String identifiant, String motdePasse, String nom, String prenom, String email,
			Adresse adresse) {
		super(idPersonne, identifiant, motdePasse, nom, prenom, email, adresse);
		// TODO Auto-generated constructor stub
	}

	public Enseignant(String identifiant, String motdePasse, String nom, String prenom, String email, Adresse adresse) {
		super(identifiant, motdePasse, nom, prenom, email, adresse);
		// TODO Auto-generated constructor stub
	}

}// end class
