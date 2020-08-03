package com.intiformation.gestionecole.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.intiformation.gestionecole.dao.MatiereDAOImpl;
import com.intiformation.gestionecole.modele.Matiere;

@Service("matiereServiceBean")
public class MatiereServiceImpl implements IGeneriqueService<Matiere> {

	//déclaration de la couche DAO
	
	private MatiereDAOImpl matiereDAO ;
	
	public void setMatiereDAO (MatiereDAOImpl matiereDAOImpl) {
		this.matiereDAO = matiereDAOImpl ;
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
		// TODO Auto-generated method stub
		return matiereDAO.getAll();
	}

}
