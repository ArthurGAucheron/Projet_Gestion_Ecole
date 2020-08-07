package com.intiformation.gestionecole.service;

import java.util.Collection;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.intiformation.gestionecole.dao.IMatiereDAO;
import com.intiformation.gestionecole.modele.Cours;
import com.intiformation.gestionecole.modele.Matiere;

@Service("matiereServiceBean")
public class MatiereServiceImpl implements IMatiereService {

	// déclaration de la couche DAO

	@Autowired
	@Qualifier("matiereDAOBean")
	private IMatiereDAO matiereDAO;

	public void setMatiereDAO(@Qualifier("matiereDAOBean") IMatiereDAO matiereDAO) {
		this.matiereDAO = matiereDAO;
	}

	@Override
	public void ajouter(Matiere pMatiere) {
		matiereDAO.add(pMatiere);

	}

	@Override
	public void modifier(Matiere pMatiere) {
		matiereDAO.update(pMatiere);

	}

	@Override
	public void supprimer(Long pIdMatiere) {
		matiereDAO.delete(pIdMatiere);

	}

	@Override
	public Matiere findById(Long pIdMatiere) {
		return matiereDAO.getById(pIdMatiere);
	}

	@Override
	public List<Matiere> findAll() {
		return matiereDAO.getAll();
	}


}
