package com.intiformation.gestionecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;


import com.intiformation.gestionecole.dao.IGeneriqueDAO;
import com.intiformation.gestionecole.modele.Cours;

@Service("coursServiceBean")
public class CoursServiceImpl implements IGeneriqueService<Cours> {

	
	@Autowired
	@Qualifier("coursDAOBean")
	private IGeneriqueDAO<Cours> coursDAO;
	
	public void setCoursDAO(IGeneriqueDAO<Cours> coursDAO) {
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