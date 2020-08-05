package com.intiformation.gestionecole.service;

import java.util.List;

import com.intiformation.gestionecole.dao.CoursDAOImpl;
import com.intiformation.gestionecole.modele.Cours;

public class CoursServiceImpl implements ICoursService {

	private CoursDAOImpl coursDAO;
	
	public void setCoursDAO(CoursDAOImpl coursDAO) {
		this.coursDAO = coursDAO;
	}

	@Override
	public void ajouter(Cours pCours) {
		coursDAO.add(pCours);
	}

	@Override
	public void modifier(Cours pCours) {
		coursDAO.update(pCours);
	}

	@Override
	public void supprimer(Long pIdCours) {
		coursDAO.delete(pIdCours);
	}

	@Override
	public Cours findById(Long pIdCours) {
		return coursDAO.getById(pIdCours);
	}

	@Override
	public List<Cours> findAll() {
		return coursDAO.getAll();
	}
	
	

}
