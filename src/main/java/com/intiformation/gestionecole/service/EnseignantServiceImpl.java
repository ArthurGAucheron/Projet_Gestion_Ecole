package com.intiformation.gestionecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.gestionecole.dao.IEnseignantDAO;
import com.intiformation.gestionecole.modele.Enseignant;

@Service("enseignantServiceBean")
public class EnseignantServiceImpl implements IEnseignantService {

	@Autowired
	IEnseignantDAO enseignantDAO;
	public void setEnseignantDAO(IEnseignantDAO enseignantDAO) {
		this.enseignantDAO = enseignantDAO;
	}

	@Override
	public void ajouter(Enseignant pEnseignant) {
		enseignantDAO.add(pEnseignant);
		
	}

	@Override
	public void modifier(Enseignant pEnseignant) {
		enseignantDAO.update(pEnseignant);
	}

	@Override
	public void supprimer(Long pIdEnseignant) {
		enseignantDAO.delete(pIdEnseignant);
	}

	@Override
	public Enseignant findById(Long pIdEnseignant) {
		return enseignantDAO.getById(pIdEnseignant);
	}

	@Override
	public List<Enseignant> findAll() {
		return enseignantDAO.getAll();
	}

}// end class
