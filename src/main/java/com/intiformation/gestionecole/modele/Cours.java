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
	private Date date;
	
	@Column(name="duree")
	private Date duree;
	
	@Column(name="description")
	private String description;

	@Column(name="id_promo")
	private Long idPromo;
	
	
	@ManyToOne
	@JoinColumn(name="matiere_id", referencedColumnName="id_matiere")
	private Matiere matiere;
	
	/*__________________________ ctors __________________________*/
	
	public Cours() {
	}

	public Cours(long idCours, String libelle, Date date, Date duree, String description, Long idPromo,
			Matiere matiere) {
		this.idCours = idCours;
		this.libelle = libelle;
		this.date = date;
		this.duree = duree;
		this.description = description;
		this.idPromo = idPromo;
		this.matiere = matiere;
	}

	
	public Cours(String libelle, Date date, Date duree, String description, Long idPromo, Matiere matiere) {
		this.libelle = libelle;
		this.date = date;
		this.duree = duree;
		this.description = description;
		this.idPromo = idPromo;
		this.matiere = matiere;
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

	public Date getDuree() {
		return duree;
	}

	public void setDuree(Date duree) {
		this.duree = duree;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Long getIdPromo() {
		return idPromo;
	}

	public void setIdPromo(Long idPromo) {
		this.idPromo = idPromo;
	}

	public Matiere getMatiere() {
		return matiere;
	}

	public void setMatiere(Matiere matiere) {
		this.matiere = matiere;
	}

}
