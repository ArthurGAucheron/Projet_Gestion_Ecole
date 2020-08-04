package com.intiformation.gestionecole.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intiformation.gestionecole.dao.IAdresseDAO;
import com.intiformation.gestionecole.modele.Adresse;
/**
 * <pre>
 * Implémentation concrète de la couche service
 * <pre>
 * @author Arthur.GA
 *
 */
@Service("adresseServiceBean")
public class AdresseServiceImpl implements IAdresseService {

	@Autowired
	IAdresseDAO adresseDAO;
	
	
	public void setAdresseDAO(IAdresseDAO adresseDAO) {
		this.adresseDAO = adresseDAO;
	}

	@Override
	public void ajouter(Adresse pAdresse) {
		adresseDAO.add(pAdresse);
	}

	@Override
	public void modifier(Adresse pAdresse) {
		adresseDAO.update(pAdresse);
	}

	@Override
	public void supprimer(Long pIdAdresse) {
		adresseDAO.delete(pIdAdresse);
	}

	@Override
	public Adresse findById(Long pIdAdresse) {

		return adresseDAO.getById(pIdAdresse);
	}

	@Override
	public List<Adresse> findAll() {
		return adresseDAO.getAll();
	}

}// end class
