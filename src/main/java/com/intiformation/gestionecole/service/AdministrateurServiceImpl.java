package com.intiformation.gestionecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.gestionecole.dao.IAdministrateurDAO;
import com.intiformation.gestionecole.modele.Administrateur;

/**
 * <pre>
 * Implémentation concrète de la couche service
 * <pre>
 * @author Arthur.GA
 *
 */
@Service("adminServiceBean")
public class AdministrateurServiceImpl implements IAdministrateurService{

	@Autowired
	private IAdministrateurDAO adminDAO;
	
	public void setAdminDAO(IAdministrateurDAO adminDAO) {
		this.adminDAO = adminDAO;
	}

	@Override
	public void ajouter(Administrateur pAdministrateur) {
	adminDAO.add(pAdministrateur);
	}

	@Override
	public void modifier(Administrateur pAdministrateur) {
		adminDAO.update(pAdministrateur);
	}

	@Override
	public void supprimer(Long pIdAdministrateur) {		
		adminDAO.delete(pIdAdministrateur);
	}

	@Override
	public Administrateur findById(Long pIdAdministrateur) {
		return adminDAO.getById(pIdAdministrateur);
	}

	@Override
	public List<Administrateur> findAll() {
		return adminDAO.getAll();
	}

	
	
}// end class
