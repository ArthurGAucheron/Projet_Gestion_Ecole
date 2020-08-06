package com.intiformation.gestionecole.dao;

import org.springframework.stereotype.Repository;

import com.intiformation.gestionecole.modele.Administrateur;
/**
 * <pre>
 * Interface de la DAO spécifique à la catégorie Administrateur qui hérite de IGeneriqueDAO
 * Déclare les méthodes spécifiques
 * </pre>
 * @author Arthur.GA
 *
 */
public interface IAdministrateurDAO  extends IGeneriqueDAO<Administrateur>{

	/**
	 * Retourn true si l'iendifiant existe dans la bdd
	 * @return
	 */
	public boolean identifiantIsExist(String pIdentifiantAdmin);
		
	

}// end interface
