package com.intiformation.gestionecole.modele;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
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
	
	
	
	@OneToOne(cascade=CascadeType.DETACH)
	@JoinColumn(name="matiere_id")
	private Matiere matiere;
	
	@ManyToMany(cascade=CascadeType.DETACH)
	@JoinColumn(name="promotion_id")
	private List<Promotion> promotions;

	public Enseignant() {
	}

	public Enseignant(Long idPersonne, String identifiant, String motdePasse, String nom, String prenom, String email,
			Adresse adresse) {
		super(idPersonne, identifiant, motdePasse, nom, prenom, email, adresse);
	
	}

	public Enseignant(String identifiant, String motdePasse, String nom, String prenom, String email, Adresse adresse) {
		super(identifiant, motdePasse, nom, prenom, email, adresse);
	}


	
}// end class
