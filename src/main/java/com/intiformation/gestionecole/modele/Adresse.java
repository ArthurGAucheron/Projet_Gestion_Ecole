package com.intiformation.gestionecole.modele;
/**
 * <pre>
 * 	Classe entité adresse <br/>
 *  Relié à la classe entité Personne <br/>
 *  Une personne peut avoir 0 ou 1 adresse <br/>
 * </pre>
 * @author Arthur.GA
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="adresses")
public class Adresse {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_adresse")
	private Long idAdresse;
	
	@Column(name="rue")
	private String rue;
	
	@Column(name="code_postal")
	private String codePostal;
	
	@Column(name="ville")
	private String ville;

	@OneToOne(mappedBy="adresse")
	private Personne personne;
	
	public Adresse(Long idAdresse, String rue, String codePostal, String ville) {
		this.idAdresse = idAdresse;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	public Adresse(String rue, String codePostal, String ville) {
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}


	public Adresse() {
	}


	public Long getIdAdresse() {
		return idAdresse;
	}


	public void setIdAdresse(Long idAdresse) {
		this.idAdresse = idAdresse;
	}


	public String getRue() {
		return rue;
	}


	public void setRue(String rue) {
		this.rue = rue;
	}


	public String getCodePostal() {
		return codePostal;
	}


	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}


	public String getVille() {
		return ville;
	}


	public void setVille(String ville) {
		this.ville = ville;
	}


	public Personne getPersonne() {
		return personne;
	}


	public void setPersonne(Personne personne) {
		this.personne = personne;
	}


	
	
}// end classe
