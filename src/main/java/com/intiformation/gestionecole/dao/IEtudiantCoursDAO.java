package com.intiformation.gestionecole.dao;

import java.util.List;

import com.intiformation.gestionecole.modele.EtudiantCours;

public interface IEtudiantCoursDAO extends IGeneriqueDAO<EtudiantCours>{

	public List<EtudiantCours> getAllByCourId(Long pIdCours);
	
	public List<EtudiantCours> getAllByEtudiantId (Long pIdEtudiant);
	
}
