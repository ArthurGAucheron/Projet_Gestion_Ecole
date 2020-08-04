package com.intiformation.gestionecole.modele;

import java.util.Arrays;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
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

	@Column(name = "promotion")
	private Long idPromo;

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
	public Etudiant(long idPersonne, String identifiant, String motdePasse, String nom, String prenom, String email,
			byte[] photo, Date dateNaissance, Long idPromo) {
		super(idPersonne, identifiant, motdePasse, nom, prenom, email);
		this.photo = photo;
		this.dateNaissance = dateNaissance;
		this.idPromo = idPromo;
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
	public Etudiant(String identifiant, String motdePasse, String nom, String prenom, String email, byte[] photo,
			Date dateNaissance, Long idPromo) {
		super(identifiant, motdePasse, nom, prenom, email);
		this.photo = photo;
		this.dateNaissance = dateNaissance;
		this.idPromo = idPromo;
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

	public Long getIdPromo() {
		return idPromo;
	}

	public void setIdPromo(Long idPromo) {
		this.idPromo = idPromo;
	}

	@Override
	public String toString() {
		return "Etudiant [Photo=" + Arrays.toString(photo) + ", DateNaissance=" + dateNaissance + ", idPromo=" + idPromo
				+ ", IdPromo=" + getIdPromo() + ", Identifiant=" + getIdentifiant() + ", MotdePasse=" + getMotdePasse()
				+ ", Nom=" + getNom() + ", Prenom=" + getPrenom() + ", Email=" + getEmail() + ", IdPersonne="
				+ getIdPersonne() + "]";
	}

}
