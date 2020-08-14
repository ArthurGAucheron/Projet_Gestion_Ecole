package com.intiformation.gestionecole.dao;

import java.util.List;

import com.intiformation.gestionecole.modele.Etudiant;

public interface IEtudiantDAO extends IGeneriqueDAO<Etudiant> {
	
	public List<Etudiant> getAllEtudiantsOfAPromotion (Long pIdPromo);

	Etudiant getIdentite(String pIdentifiant);

}
