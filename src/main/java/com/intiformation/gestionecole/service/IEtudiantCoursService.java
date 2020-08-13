package com.intiformation.gestionecole.service;

import java.util.List;

import com.intiformation.gestionecole.modele.EtudiantCours;

public interface IEtudiantCoursService extends IGeneriqueService<EtudiantCours> {

	public List<EtudiantCours> findAllByCourId(Long pIdCours);
	
	public List<EtudiantCours> findAllByEtudiantId (Long pIdEtudiant);
}
