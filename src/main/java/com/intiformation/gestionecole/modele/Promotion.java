package com.intiformation.gestionecole.modele;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * modele de données pour une Promotion
 * 
 * @author cam
 *
 */
@Entity
@Table(name="promotions")
public class Promotion {

	/* ______Propriétés________ */

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_promotion")
	private Long idPromotion;

	@Column(name = "libelle")
	private String libelle;

	@Column(name="liste_cours")
	@OneToMany(cascade=CascadeType.ALL, mappedBy="promotion")
	private List<Cours> listeCours;

	@Column(name ="liste_etudiants")
	@OneToMany(cascade=CascadeType.ALL, mappedBy="promotion")
	private List<Etudiant> listeEtudiants;
	
	@ManyToMany(cascade=CascadeType.DETACH)
	@JoinColumn(name="enseignant_id")
	private List<Enseignant> enseignants;
	
	@ManyToMany(cascade=CascadeType.DETACH)
	@JoinColumn(name="matiere_id")
	private List<Matiere> matieres;

	/* ______Constructeurs________ */

	public Promotion() {
	}

	public Promotion(String libelle, List<Cours> listeCours, List<Etudiant> listeEtudiants,List<Enseignant> enseignants,List<Matiere> matieres) {
		super();
		this.libelle = libelle;
		this.listeCours = listeCours;
		this.listeEtudiants = listeEtudiants;
		this.enseignants=enseignants;
		this.matieres=matieres;
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
	

	public List<Enseignant> getEnseignants() {
		return enseignants;
	}

	public void setEnseignants(List<Enseignant> enseignants) {
		this.enseignants = enseignants;
	}

	public List<Matiere> getMatieres() {
		return matieres;
	}

	public void setMatieres(List<Matiere> matieres) {
		this.matieres = matieres;
	}

	/* ______toString()________ */
	@Override
	public String toString() {
		return "Promotion [idPromotion=" + idPromotion + ", libelle=" + libelle + ", listeCours=" + listeCours
				+ ", listeEtudiants=" + listeEtudiants + "]";
	}

}// end class
