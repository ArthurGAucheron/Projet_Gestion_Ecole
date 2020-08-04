package com.intiformation.gestionecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.gestionecole.dao.IAideDAO;
import com.intiformation.gestionecole.modele.Aide;

/**
 * 
 * @author Arthur.GA
 *
 */
@Service("aideServiceBean")
public class AideServiceImpl implements IAideService {

	@Autowired
	private IAideDAO aideDAO;

	public void setAideDAO(IAideDAO aideDAO) {
		this.aideDAO = aideDAO;
	}

	@Override
	public void ajouter(Aide pAide) {
		aideDAO.add(pAide);
	}

	@Override
	public void modifier(Aide pAide) {
		aideDAO.update(pAide);
	}

	@Override
	public void supprimer(Long pIdAide) {
		aideDAO.delete(pIdAide);
	}

	@Override
	public Aide findById(Long pIdAide) {
		return aideDAO.getById(pIdAide);
	}

	@Override
	public List<Aide> findAll() {
		return aideDAO.getAll();
	}

}// end class
