package com.intiformation.gestionecole.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.gestionecole.modele.Adresse;

/**
 * <pre>
 * Implémentation concrète de la couche DAO du modele Adresse
 * 
 * <pre>
 * 
 * @author Arthur.GA
 *
 */
@Repository
public class AdresseDAOImpl implements IAdresseDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public void add(Adresse pAdresse) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(pAdresse);
		} catch (HibernateException e) {
			System.out.println("....(AdresseDAOImpl) Erreurr lors de l'ajout d'une adresse");
			throw e;
		}
	}// end add()

	@Transactional
	@Override
	public void update(Adresse pAdresse) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.update(pAdresse);
		} catch (HibernateException e) {
			System.out.println("....(AdresseDAOImpl) Erreurr lors de la mise à jours d'une Adresse");
			throw e;
		}
	}// end update()

	@Transactional
	@Override
	public void delete(Long pIdAdresse) {

		Session session = this.sessionFactory.getCurrentSession();
		try {

			Adresse adresseToDelete = getById(pIdAdresse);
			session.delete(adresseToDelete);
		} catch (Exception e) {
			System.out.println("....(AdresseDAOImpl) Erreurr lors de la suppréssion d'une Adresse");
			throw e;
		}

	}// end delete

	@Transactional(readOnly = true)
	@Override
	public Adresse getById(Long pIdAdresse) {
		Session session = this.sessionFactory.getCurrentSession();
		try {

			Adresse adresse = session.find(Adresse.class, pIdAdresse);
			return adresse;
		} catch (HibernateException e) {
			System.out.println("....(AdresseDAOImpl) Erreurr lors de la recherche d'une Adresse par son id");
			throw e;
		}
	}// end getByID

	@Transactional(readOnly = true)
	@Override
	public List<Adresse> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		try {

			Query query = session.createQuery("FROM Adresse");
			List<Adresse> listeAdresse = query.list();
			return listeAdresse;

		} catch (HibernateException e) {
			System.out.println("....(AdresseDAOImpl) Erreurr lors de la récupération de la liste des Adresses");
			throw e;
		}
	}// end getAll()

}// end class
