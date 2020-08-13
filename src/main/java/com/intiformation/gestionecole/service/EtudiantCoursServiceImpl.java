package com.intiformation.gestionecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.gestionecole.dao.IEtudiantCoursDAO;
import com.intiformation.gestionecole.modele.EtudiantCours;

@Service
public class EtudiantCoursServiceImpl implements IEtudiantCoursService{
	
	@Autowired
	private IEtudiantCoursDAO etudiantCoursDAO;
	
	public void setEtudiantCoursDAO(IEtudiantCoursDAO etudiantCoursDAO) {
		this.etudiantCoursDAO = etudiantCoursDAO;
	}

	
	@Override
	public void ajouter(EtudiantCours pEtudiantCours) {
		etudiantCoursDAO.add(pEtudiantCours);
	}

	@Override
	public void modifier(EtudiantCours pEtudiantCours) {
		etudiantCoursDAO.update(pEtudiantCours);	
	}

	@Override
	public void supprimer(Long pIdEtudiantCours) {
		etudiantCoursDAO.delete(pIdEtudiantCours);	
	}

	@Override
	public EtudiantCours findById(Long pIdEtudiantCours) {
		return etudiantCoursDAO.getById(pIdEtudiantCours);
	}

	@Override
	public List<EtudiantCours> findAll() {
		return etudiantCoursDAO.getAll();
	}


	@Override
	public List<EtudiantCours> findAllByCourId(Long pIdCours) {
		return etudiantCoursDAO.getAllByCourId(pIdCours);
	}


	@Override
	public List<EtudiantCours> findAllByEtudiantId(Long pIdEtudiant) {
		return etudiantCoursDAO.getAllByEtudiantId(pIdEtudiant);
	}

}
