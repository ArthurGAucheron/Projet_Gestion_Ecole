package com.intiformation.gestionecole.service;


import com.intiformation.gestionecole.modele.Administrateur;
/**
 * Interface de la couche service, déclaration des méthodes unique à l'Administrateur
 * @author Arthur.GA
 *
 */
public interface IAdministrateurService extends IGeneriqueService<Administrateur> {
	
	/**
	 * Retourn true si l'iendifiant existe dans la bdd
	 * @return
	 */
	public boolean identifiantIsExist(String pIdentifiantAdmin);
	
}// end interface
