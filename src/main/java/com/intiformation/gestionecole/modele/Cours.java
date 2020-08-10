package com.intiformation.gestionecole.modele;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="cours")
public class Cours {
	
	/*__________________________ props __________________________*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_cours")
	private long idCours;
	
	@Column(name="libelle")
	private String libelle;
	
	@Column(name="date")
	@DateTimeFormat(pattern = "jj/mm/aaaa")
	@Temporal(TemporalType.DATE)
	private Date date;
	
	@Column(name="duree")
	private int duree;
	
	@Column(name="description")
	private String description;

	@ManyToOne
	@JoinColumn(name="promotion_id", referencedColumnName="id_promotion")
	private Promotion promotion;
	
	
	@ManyToOne
	@JoinColumn(name="matiere_id", referencedColumnName="id_matiere")
	private Matiere matiere;
	
	/*__________________________ ctors __________________________*/
	
	public Cours() {
	}


	public Cours(long idCours, String libelle, Date date, int duree, String description, Promotion promotion,
			Matiere matiere) {
		super();
		this.idCours = idCours;
		this.libelle = libelle;
		this.date = date;
		this.duree = duree;
		this.description = description;
		this.promotion = promotion;
		this.matiere = matiere;
	}
	
	public Cours(String libelle, Date date, int duree, String description, Promotion promotion, Matiere matiere) {
		super();
		this.libelle = libelle;
		this.date = date;
		this.duree = duree;
		this.description = description;
		this.promotion = promotion;
		this.matiere = matiere;
	}
	
	


	public Cours(String libelle, Date date) {
		super();
		
		this.libelle = libelle;
		this.date = date;
	}

	/*_____________________ getters/setters _____________________*/
	public long getIdCours() {
		return idCours;
	}

	public void setIdCours(long idCours) {
		this.idCours = idCours;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuree() {
		return duree;
	}

	public void setDuree(int duree) {
		this.duree = duree;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

}
