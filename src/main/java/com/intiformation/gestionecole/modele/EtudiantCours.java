package com.intiformation.gestionecole.modele;

import javax.persistence.Column;

public class EtudiantCours {
	
	/*__________________________ props __________________________*/
	@Column(name="absence")
	private boolean absence;
	
	@Column(name="motif")
	private String motif;
	
	@Column(name="id_etudiant")
	private long idEtudiant;
	
	@Column(name="id_cours")
	private long idCours;
	
	/*__________________________ ctors __________________________*/
	/**
	 * ctor vide
	 */
	public EtudiantCours() {
	}

	/**
	 * ctor chargé avec toutes les props
	 * @param absence
	 * @param motif
	 * @param idEtudiant
	 * @param idCours
	 */
	public EtudiantCours(boolean absence, String motif, long idEtudiant, long idCours) {
		super();
		this.absence = absence;
		this.motif = motif;
		this.idEtudiant = idEtudiant;
		this.idCours = idCours;
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

	public long getIdEtudiant() {
		return idEtudiant;
	}

	public void setIdEtudiant(long idEtudiant) {
		this.idEtudiant = idEtudiant;
	}

	public long getIdCours() {
		return idCours;
	}

	public void setIdCours(long idCours) {
		this.idCours = idCours;
	}
	
}
