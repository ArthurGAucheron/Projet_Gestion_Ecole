package com.intiformation.gestionecole.dao;

import com.intiformation.gestionecole.modele.Enseignant;
/**
 * 
 * @author Arthur.GA et cam
 *
 */
public interface IEnseignantDAO extends IGeneriqueDAO<Enseignant>{

	Enseignant getIdentite(String pIdentifiant);

	
	
}// end class
