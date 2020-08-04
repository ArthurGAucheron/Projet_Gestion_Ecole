package com.intiformation.gestionecole.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.gestionecole.modele.Aide;
/**
 * 
 * @author Arthur.GA
 *
 */
@Repository
public class AideDAOImpl implements IAideDAO{

	@Autowired
	SessionFactory sessionFactory;
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public void add(Aide pAide) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(pAide);
		} catch (HibernateException e) {
			System.out.println("....(AideDAOImpl) Erreurr lors de l'ajout d'une aide");
			throw e;
		}
	}// end add()

	@Transactional
	@Override
	public void update(Aide pAide) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(pAide);
		} catch (HibernateException e) {
			System.out.println("....(AideDAOImpl) Erreurr lors de la mise à jours d'une aide");
			throw e;
		}
	}// end update()

	@Transactional
	@Override
	public void delete(Long pIdAide) {

		Session session = this.sessionFactory.getCurrentSession();
		try {

			Aide aideToDelete = getById(pIdAide);
			session.delete(aideToDelete);
		} catch (Exception e) {
			System.out.println("....(AideDAOImpl) Erreurr lors de la suppréssion d'une aide");
			throw e;
		}

	}// end delete

	@Transactional(readOnly = true)
	@Override
	public Aide getById(Long pIdAide) {
		Session session = this.sessionFactory.getCurrentSession();
		try {

			Aide aide = session.find(Aide.class, pIdAide);
			return aide;
		} catch (HibernateException e) {
			System.out.println("....(AideDAOImpl) Erreurr lors de la recherche d'une aide par son id");
			throw e;
		}
	}// end getByID

	@Transactional(readOnly = true)
	@Override
	public List<Aide> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		try {

			Query query = session.createQuery("FROM Aide");
			List<Aide> listeAide = query.list();
			return listeAide;

		} catch (HibernateException e) {
			System.out.println("....(AideDAOImpl) Erreurr lors de la récupération de la liste des aides");
			throw e;
		}
	}// end getAll()
}// end class
