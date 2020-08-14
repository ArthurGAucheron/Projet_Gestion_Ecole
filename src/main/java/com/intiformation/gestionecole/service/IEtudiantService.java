package com.intiformation.gestionecole.service;

import java.util.List;

import com.intiformation.gestionecole.modele.Etudiant;

public interface IEtudiantService extends IGeneriqueService<Etudiant> {

	public List<Etudiant> findAllEtudiantsOfAPromotion (Long pIdPromo);

	public Etudiant findIdentite(String pIdentifiant);
}
