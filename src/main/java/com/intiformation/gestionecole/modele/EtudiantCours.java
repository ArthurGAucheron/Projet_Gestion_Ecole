package com.intiformation.gestionecole.modele;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "etudiantsCours")
public class EtudiantCours {
	
	/*__________________________ props __________________________*/
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_etudiants_cours")
	private long idEtudiantsCours;
	
	@Column(name="absence")
	private boolean absence;
	
	@Column(name="motif")
	private String motif;
	
	@ManyToOne
	@JoinColumn(name="etudiant_id", referencedColumnName="id_personne")
	private Etudiant etudiant;
	
	@ManyToOne
	@JoinColumn(name="cours_id", referencedColumnName="id_cours")
	private Cours cours;
	
	/*__________________________ ctors __________________________*/
	/**
	 * ctor vide
	 */
	public EtudiantCours() {
	}
	
	public EtudiantCours(Etudiant etudiant, Cours cours) {
		this.etudiant = etudiant;
		this.cours = cours;
	}

	/**
	 * ctor sans id
	 * @param absence
	 * @param motif
	 * @param etudiant
	 * @param cours
	 */
	public EtudiantCours(boolean absence, String motif, Etudiant etudiant, Cours cours) {
		this.absence = absence;
		this.motif = motif;
		this.etudiant = etudiant;
		this.cours = cours;
	}
	
	/**
	 * ctor chargé avec toutes les props
	 * @param idEtudiantsCours
	 * @param absence
	 * @param motif
	 * @param etudiant
	 * @param cours
	 */
	public EtudiantCours(long idEtudiantsCours, boolean absence, String motif, Etudiant etudiant, Cours cours) {
		super();
		this.idEtudiantsCours = idEtudiantsCours;
		this.absence = absence;
		this.motif = motif;
		this.etudiant = etudiant;
		this.cours = cours;
	}

	/*_________________________ getters _________________________*/
	public boolean isAbsence() {
		return absence;
	}

	public void setAbsence(boolean absence) {
		this.absence = absence;
	}

	public String getMotif() {
		return motif;
	}

	public void setMotif(String motif) {
		this.motif = motif;
	}

	public Etudiant getEtudiant() {
		return etudiant;
	}

	public void setEtudiant(Etudiant etudiant) {
		this.etudiant = etudiant;
	}

	public Cours getCours() {
		return cours;
	}

	public void setCours(Cours cours) {
		this.cours = cours;
	}

	public long getIdEtudiantsCours() {
		return idEtudiantsCours;
	}

	public void setIdEtudiantsCours(long idEtudiantsCours) {
		this.idEtudiantsCours = idEtudiantsCours;
	}

	
	
}
