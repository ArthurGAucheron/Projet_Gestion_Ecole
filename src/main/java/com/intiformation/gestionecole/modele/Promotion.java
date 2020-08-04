package com.intiformation.gestionecole.modele;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * modele de données pour une Promotion
 * 
 * @author cam
 *
 */
public class Promotion {

	/* ______Propriétés________ */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_promotion")
	private Long idPromotion;

	@Column(name = "libelle")
	private String libelle;

	@Column(name = "liste_cours")
	private List<Cours> listeCours;

	@Column(name = "liste_etudiants")
	private List<Etudiant> listeEtudiants;

	/* ______Constructeurs________ */

	public Promotion() {
	}

	public Promotion(String libelle, List<Cours> listeCours, List<Etudiant> listeEtudiants) {
		super();
		this.libelle = libelle;
		this.listeCours = listeCours;
		this.listeEtudiants = listeEtudiants;
	}

	/* ______Getters/Setters________ */

	public Long getIdPromotion() {
		return idPromotion;
	}

	public void setIdPromotion(Long idPromotion) {
		this.idPromotion = idPromotion;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Cours> getListeCours() {
		return listeCours;
	}

	public void setListeCours(List<Cours> listeCours) {
		this.listeCours = listeCours;
	}

	public List<Etudiant> getListeEtudiants() {
		return listeEtudiants;
	}

	public void setListeEtudiants(List<Etudiant> listeEtudiants) {
		this.listeEtudiants = listeEtudiants;
	}

	/* ______toString()________ */
	@Override
	public String toString() {
		return "Promotion [idPromotion=" + idPromotion + ", libelle=" + libelle + ", listeCours=" + listeCours
				+ ", listeEtudiants=" + listeEtudiants + "]";
	}

}// end class