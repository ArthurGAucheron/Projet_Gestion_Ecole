package com.intiformation.gestionecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.intiformation.gestionecole.dao.CoursDAOImpl;
import com.intiformation.gestionecole.dao.ICoursDAO;
import com.intiformation.gestionecole.modele.Cours;

@Service
public class CoursServiceImpl implements ICoursService {

	@Autowired
	private ICoursDAO coursDAO;
	public void setCoursDAO(CoursDAOImpl coursDAO) {
		this.coursDAO = coursDAO;
	}

	public CoursServiceImpl() {
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
