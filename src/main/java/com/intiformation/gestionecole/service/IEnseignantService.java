package com.intiformation.gestionecole.service;

import com.intiformation.gestionecole.modele.Enseignant;
/**
 * 
 * @author Arthur.GA et cam
 *
 */
public interface IEnseignantService extends IGeneriqueService<Enseignant>{
	
	public Enseignant findIdentite(String pIdentifiant);

}// end interface
