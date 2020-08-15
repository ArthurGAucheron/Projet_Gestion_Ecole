package com.intiformation.gestionecole.modele;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;


/**
 * modele de données pour une Matiere
 * @author cam
 *
 */
@Entity
@Table(name="matieres")
public class Matiere {

	/* ______Propriétés________ */

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_matiere")
	private Long idMatiere;
	
	@Column(name="libelle")
	private String libelle;
	
	@Column(name="liste_cours")
	@OneToMany(cascade=CascadeType.DETACH, mappedBy="matiere", fetch=FetchType.EAGER)
	private List<Cours> listeCours;

	
	@OneToOne (cascade=CascadeType.DETACH)
	@JoinColumn(name="enseignant_id",referencedColumnName = "id_personne")
	private Enseignant enseignant;
	
	@ManyToMany(cascade=CascadeType.DETACH)
	@JoinColumn(name="promotion_id")
	private List<Promotion> promotions;
	

	/* ______Constructeurs________ */

	public Matiere() {
	}

	

	public Matiere(Long idMatiere, String libelle, List<Cours> listeCours, Enseignant enseignant,List<Promotion> promotions) {
		super();
		this.idMatiere = idMatiere;
		this.libelle = libelle;
		this.listeCours = listeCours;
		this.enseignant = enseignant;
		this.promotions = promotions ;
	}



	public Matiere(String libelle, List<Cours> listeCours, Enseignant enseignant,List<Promotion> promotions) {
		super();
		this.libelle = libelle;
		this.listeCours = listeCours;
		this.enseignant = enseignant;
		this.promotions = promotions;
	}



	/* ______Getters/Setters________ */

	public Long getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(Long idMatiere) {
		this.idMatiere = idMatiere;
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



	public Enseignant getEnseignant() {
		return enseignant;
	}



	public void setEnseignant(Enseignant enseignant) {
		this.enseignant = enseignant;
	}



	public List<Promotion> getPromotions() {
		return promotions;
	}



	public void setPromotions(List<Promotion> promotions) {
		this.promotions = promotions;
	}




	
	
	

}// end class
