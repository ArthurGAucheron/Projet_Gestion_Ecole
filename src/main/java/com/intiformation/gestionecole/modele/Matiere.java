package com.intiformation.gestionecole.modele;

import java.io.Serializable;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.Transient;

import com.intiformation.gestionecole.modele.Cours;


/**
 * modele de données pour une Matiere
 * @author cam
 *
 */
@Entity
@Table(name="matieres")
@DynamicUpdate
public class Matiere implements Serializable {

	/* ______Propriétés________ */

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_matiere")
	private Long idMatiere;
	
	@Column(name="libelle")
	private String libelle;
	
	@OneToMany (mappedBy="matiere", targetEntity=Cours.class, fetch=FetchType.LAZY)
	private Set<Cours> listeCours;

	/* ______Constructeurs________ */

	public Matiere() {
	}

	public Matiere(String libelle,Set<Cours> listeCours) {
		super();
		this.libelle = libelle;
		this.listeCours = listeCours;
	}	
	
	public Matiere(Long idMatiere, String libelle) {
		super();
		this.idMatiere = idMatiere;
		this.libelle = libelle;
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

	public Set<Cours> getListeCours() {
		return listeCours;
	}

	public void setListeCours(Set<Cours> listeCours) {
		this.listeCours = listeCours;
	}

	/* ______toString()________ */
	
	@Override
	public String toString() {
		return "[" + idMatiere + " " + libelle + "]";
	}


	



	

}// end class