package com.intiformation.gestionecole.service;

import com.intiformation.gestionecole.modele.Etudiant;

public interface IEtudiantService extends IGeneriqueService<Etudiant> {
	
	public boolean etudiantIsExist(String pIdEtudiant);
	
}
