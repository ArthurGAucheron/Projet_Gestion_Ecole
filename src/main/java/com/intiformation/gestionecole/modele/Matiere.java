package com.intiformation.gestionecole.modele;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.intiformation.gestionecole.modele.Cours;


/**
 * modele de données pour une Matiere
 * @author cam
 *
 */
@Entity
@Table(name="matieres")
public class Matiere implements Serializable {

	/* ______Propriétés________ */

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_matiere")
	private Long idMatiere;
	
	@Column(name="libelle")
	private String libelle;
	
	@OneToMany (mappedBy="matiere", cascade = CascadeType.REMOVE)
	@Column(name="liste_cours")
	private List<Cours> listeCours;

	/* ______Constructeurs________ */

	public Matiere() {
	}

	public Matiere(String libelle,List<Cours> listeCours) {
		super();
		this.libelle = libelle;
		this.listeCours = listeCours;
	}	

	public Matiere(String libelle) {
		super();
		this.libelle = libelle;
	}

	/* ______Getters/Setters________ */

	public Long getIdMatiere() {
		return idMatiere;
	}

	public void setIdMatiere(Long idMatiere) {
		this.idMatiere = idMatiere;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public List<Cours> getListeCours() {
		return listeCours;
	}

	public void setListeCours(List<Cours> listeCours) {
		this.listeCours = listeCours;
	}

	/* ______toString()________ */
	
	@Override
	public String toString() {
		return "[" + idMatiere + " " + libelle + "]";
	}


	



	

}// end class