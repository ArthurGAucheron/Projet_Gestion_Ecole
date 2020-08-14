package com.intiformation.gestionecole.modele;

import java.util.Arrays;
import java.util.Base64;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@DiscriminatorValue("ROLE_ETU")
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
	
	@OneToMany(cascade=CascadeType.DETACH, mappedBy="etudiant")
	private List<EtudiantCours> etudiantCours;

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


	


	public List<EtudiantCours> getEtudiantCours() {
		return etudiantCours;
	}


	public void setEtudiantCours(List<EtudiantCours> etudiantCours) {
		this.etudiantCours = etudiantCours;
	}


	public String getBase64() {
		if (this.photo != null) {
			return this.base64 = Base64.getEncoder().encodeToString(this.photo);
		} else {
			return base64;
		}
		
	}


	public void setBase64(String base64) {
		this.base64 = base64;
	}

	

}