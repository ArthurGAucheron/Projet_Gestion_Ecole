package com.intiformation.gestionecole.modele;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("etu")
@Table(name = "etudiants")
public class Etudiant extends Personne {

	/* __________________________ props __________________________ */
	@Column(name = "photo")
	private byte[] photo;

	@Column(name = "date_de_naissance")
	private Date dateNaissance;

	@ManyToOne
	@JoinColumn(name="promotion_id", referencedColumnName="id_promotion")
	private Promotion promotion;

	/* __________________________ ctors __________________________ */
	/**
	 * ctor vide
	 */
	
	
	public Etudiant() {
	}

	public Etudiant(byte[] photo, Date dateNaissance, Long idPromo) {
		super();
		
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

	@Override
	public String toString() {
		return "Etudiant [Photo=" + Arrays.toString(photo) + ", DateNaissance=" + dateNaissance + ", idPromo=" + promotion
				+ ", IdPromo=" + getPromotion() + ", Identifiant=" + getIdentifiant() + ", MotdePasse=" + getMotdePasse()
				+ ", Nom=" + getNom() + ", Prenom=" + getPrenom() + ", Email=" + getEmail() + ", IdPersonne="
				+ getIdPersonne() + "]";
	}

}
