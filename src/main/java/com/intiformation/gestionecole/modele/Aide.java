package com.intiformation.gestionecole.modele;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * <pre>
 * 	Classe d'aide, elle permet d'avoir des infos sur l'utilisation des pages du site web
 * </pre>
 * @author Arthur.GA
 *
 */
@Entity
@Table(name="aides")
public class Aide {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id_aide")
	private Long idAide;
	
	@Column(name="page_libelle")
	private String pageLibelle;
	
	@Column(name="contenu")
	private String contenu;

	public Aide() {
	}
	
	public Aide(Long idAide, String pageLibelle, String contenu) {
		super();
		this.idAide = idAide;
		this.pageLibelle = pageLibelle;
		this.contenu = contenu;
	}

	public Aide(String pageLibelle, String contenu) {
		super();
		this.pageLibelle = pageLibelle;
		this.contenu = contenu;
	}

	public Long getIdAide() {
		return idAide;
	}

	public void setIdAide(Long idAide) {
		this.idAide = idAide;
	}

	public String getPageLibelle() {
		return pageLibelle;
	}

	public void setPageLibelle(String pageLibelle) {
		this.pageLibelle = pageLibelle;
	}

	public String getContenu() {
		return contenu;
	}

	public void setContenu(String contenu) {
		this.contenu = contenu;
	}
	
	
}// end class
