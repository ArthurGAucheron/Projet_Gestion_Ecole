package com.intiformation.gestionecole.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.intiformation.gestionecole.dao.PromotionDAOImpl;
import com.intiformation.gestionecole.modele.Promotion;

@Service("promotionServiceBean")
public class PromotionServiceImpl implements IGeneriqueService<Promotion> {

	// déclaration de la couche DAO

	private PromotionDAOImpl promotionDAO;

	@Override
	public void ajouter(Promotion pPromotion) {
		promotionDAO.add(pPromotion);

	}

	@Override
	public void modifier(Promotion pPromotion) {
		promotionDAO.update(pPromotion);

	}

	@Override
	public void supprimer(Long pIdPromotion) {
		promotionDAO.delete(pIdPromotion);

	}

	@Override
	public Promotion findById(Long pIdPromotion) {
		return promotionDAO.getById(pIdPromotion);
	}

	@Override
	public List<Promotion> findAll() {
		return promotionDAO.getAll();
	}

}// end class
