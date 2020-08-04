package com.intiformation.gestionecole.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;

<<<<<<< HEAD

=======
>>>>>>> 642f7b4... implémentation du modele Aide et de sa couche service et DAO
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
@Inheritance(strategy=InheritanceType.TABLE_PER_CLASS)
public abstract class Personne {
	
	/*________________________________________________________ Propriétés _______________________________________________________*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_personne")
	private long   idPersonne;
	
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
	
	/*_____________________________________________________ Constructeurs _______________________________________________________*/
	
	public Personne() {
	}
	public Personne(long idPersonne, String identifiant, String motdePasse, String nom, String prenom, String email) {
		super();
		this.idPersonne = idPersonne;
		this.identifiant = identifiant;
		this.motdePasse = motdePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
	}
	
	public Personne(String identifiant, String motdePasse, String nom, String prenom, String email) {
		super();
		this.identifiant = identifiant;
		this.motdePasse = motdePasse;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
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



	public long getIdPersonne() {
		return idPersonne;
	}

	public void setIdPersonne(long idPersonne) {
		this.idPersonne = idPersonne;
	}

	

}// end class

