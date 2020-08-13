package com.intiformation.gestionecole.modele;


import java.util.Base64;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@DiscriminatorValue("etu")
@Table(name = "etudiants")
public class Etudiant extends Personne {

	/* __________________________ props __________________________ */
	@Lob
	@Column(name = "photo")
	private byte[] photo;
	
	@Transient
	private String base64;

	@Column(name = "date_de_naissance")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dateNaissance;

	@ManyToOne(cascade=CascadeType.PERSIST)
	@JoinColumn(name="promotion_id", referencedColumnName="id_promotion")
	private Promotion promotion;
	
	@OneToOne(mappedBy="etudiant")
	private EtudiantCours etudiantCours;

	/* __________________________ ctors __________________________ */
	/**
	 * ctor vide
	 */
	
	
	public Etudiant() {
	}


	/**
	 * ctor chargé avec toutes les props
	 * 
	 * @param idPersonne
	 * @param identifiant
	 * @param motdePasse
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param photo
	 * @param dateNaissance
	 * @param idPromo
	 */
	public Etudiant(Long idPersonne, String identifiant, String motdePasse, String nom, String prenom, String email,
			Adresse adresse, byte[] photo, Date dateNaissance, Promotion promotion) {
		super(idPersonne, identifiant, motdePasse, nom, prenom, email, adresse);
		this.photo = photo;
		this.dateNaissance = dateNaissance;
		this.promotion = promotion;
	}
	

	/**
	 * ctor chargé sans l'id de l'étudiant
	 * 
	 * @param identifiant
	 * @param motdePasse
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param photo
	 * @param dateNaissance
	 * @param idPromo
	 */
	public Etudiant(String identifiant, String motdePasse, String nom, String prenom, String email, Adresse adresse, byte[] photo, Date dateNaissance, Promotion promotion) {
		super(identifiant, motdePasse, nom, prenom, email, adresse);
		this.photo = photo;
		this.dateNaissance = dateNaissance;
		this.promotion = promotion;
	}

	/* _____________________ getters/setters _____________________ */
	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public Promotion getPromotion() {
		return promotion;
	}

	public void setPromotion(Promotion promotion) {
		this.promotion = promotion;
	}


	public EtudiantCours getEtudiantCours() {
		return etudiantCours;
	}


	public void setEtudiantCours(EtudiantCours etudiantCours) {
		this.etudiantCours = etudiantCours;
	}


	public String getBase64() {
		return this.base64 = Base64.getEncoder().encodeToString(this.photo);
	}


	public void setBase64(String base64) {
		this.base64 = base64;
	}

	

}
