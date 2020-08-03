package com.intiformation.gestionecole.modele;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import org.hibernate.annotations.Tables;


/**
 * <pre>
 * 
 * Classe mère des classes Enseignant / Administrateur / Etudiant
 * Classe entité
 * Stratégie : une table par classe
 * 
 * </pre>
 * @author Arthur.GA
 *
 */
@Entity
@Table(name="personnes")
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type_personne",discriminatorType=DiscriminatorType.STRING)
public abstract class Personne {
	
	/*________________________________________________________ Propriétés _______________________________________________________*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_personne")
	private Long   idPersonne;
	
	@Column(name="identifiant")
	private String identifiant;
	
	@Column(name="mote_de_passe")
	private String motdePasse;
	
	@Column(name="nom")
	private String nom;
	
	@Column(name="prenom")
	private String prenom;
	
	@Column(name="email")
	private String email;
	
	@Column(name="adresse_id")
	private Long adresseId;
	/*_____________________________________________________ Constructeurs _______________________________________________________*/
	
	public Personne() {
	}
	
	public Personne(Long idPersonne, String identifiant, String motdePasse, String nom, String prenom, String email,
			Long adresseId) {
		super();
		this.idPersonne = idPersonne;
		this.identifiant = identifiant;
		this.motdePasse = motdePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresseId = adresseId;
	}

	public Personne(String identifiant, String motdePasse, String nom, String prenom, String email, Long adresseId) {
		super();
		this.identifiant = identifiant;
		this.motdePasse = motdePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresseId = adresseId;
	}




	/*_____________________________________________________ Getters/Setters _______________________________________________________*/
	public String getIdentifiant() {
		return identifiant;
	}

	public void setIdentifiant(String identifiant) {
		this.identifiant = identifiant;
	}

	public String getMotdePasse() {
		return motdePasse;
	}

	public void setMotdePasse(String motdePasse) {
		this.motdePasse = motdePasse;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	public Long getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(Long idPersonne) {
		this.idPersonne = idPersonne;
	}

	public Long getAdresseId() {
		return adresseId;
	}

	public void setAdresseId(Long adresseId) {
		this.adresseId = adresseId;
	}

	@Override
	public String toString() {
		return "Personne [idPersonne=" + idPersonne + ", identifiant=" + identifiant + ", motdePasse=" + motdePasse
				+ ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", adresseId=" + adresseId + "]";
	}

	


	

}// end class

