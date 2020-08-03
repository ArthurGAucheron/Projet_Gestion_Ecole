package com.intiformation.gestionecole.modele;

import javax.persistence.DiscriminatorColumn;
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
			String email, Long adresseId) {
		super(idPersonne, identifiant, motdePasse, nom, prenom, email, adresseId);
		// TODO Auto-generated constructor stub
	}

	public Administrateur(String identifiant, String motdePasse, String nom, String prenom, String email,
			Long adresseId) {
		super(identifiant, motdePasse, nom, prenom, email, adresseId);
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Administrateur => Identifiant = " + getIdentifiant() + " | MotdePasse = " + getMotdePasse()
				+ " | Nom=" + getNom() + " | Prenom=" + getPrenom() + " | Email=" + getEmail()
				+ " | Id Personne()=" + getIdPersonne() + " | Adresse id =" + getAdresseId() + "]";
	}

	

	

	
	/*_____________________________________________________ Getters/Setters _______________________________________________________*/
	
	
	
	
}// end class
