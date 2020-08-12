package com.intiformation.gestionecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.gestionecole.dao.EtudiantDAOImpl;
import com.intiformation.gestionecole.dao.IEtudiantDAO;
import com.intiformation.gestionecole.modele.Etudiant;

@Service
public class EtudiantServiceImpl implements IEtudiantService {

	@Autowired
	private IEtudiantDAO etudiantDAO;

	public void setEtudiantDAO(EtudiantDAOImpl etudiantDAO) {
		this.etudiantDAO = etudiantDAO;
	}

	@Override
	public void ajouter(Etudiant pEtudiant) {
		etudiantDAO.add(pEtudiant);
	}

	@Override
	public void modifier(Etudiant pEtudiant) {
		etudiantDAO.update(pEtudiant);
	}

	@Override
	public void supprimer(Long pIdEtudiant) {
		etudiantDAO.delete(pIdEtudiant);
	}

	@Override
	public Etudiant findById(Long pIdEtudiant) {
		return etudiantDAO.getById(pIdEtudiant);
	}

	@Override
	public List<Etudiant> findAll() {
		return etudiantDAO.getAll();
	}

}
