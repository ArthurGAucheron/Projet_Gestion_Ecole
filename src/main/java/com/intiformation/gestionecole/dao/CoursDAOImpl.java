package com.intiformation.gestionecole.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;

import com.intiformation.gestionecole.modele.Cours;

public class CoursDAOImpl implements IGeneriqueDAO<Cours> {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Cours pCours) {

		Session session = this.sessionFactory.getCurrentSession();

		try {

			session.save(pCours);

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de l'ajout du cours (CoursDAOImpl) ...");
			throw e;

		}

	}// end add() - cours

	@Override
	public void update(Cours pCours) {

		Session session = this.sessionFactory.getCurrentSession();

		try {

			session.update(pCours);

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de la modification du cours (CoursDAOImpl) ...");
			throw e;

		}

	}// end update() - cours

	@Override
	public void delete(Long pIdCours) {

		Session session = this.sessionFactory.getCurrentSession();

		try {
			
			Cours cours = getById(pIdCours);
			session.delete(cours);
			
		} catch (HibernateException e) {

			System.out.println("... Erreur lors de la suppression du cours (CoursDAOImpl) ...");
			throw e;

		}

	}// end delete() - cours

	@Override
	public Cours getById(Long pIdCours) {

		Session session = this.sessionFactory.openSession();

		try {

			Cours cours = session.find(Cours.class, pIdCours);
			return cours;

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de la récupération par id du cours (CoursDAOImpl) ...");
			throw e;

		}

	}// end getById() - cours

	@Override
	public List<Cours> getAll() {

		Session session = this.sessionFactory.openSession();

		try {

			Query query = session.createQuery("FROM Cours");
			List<Cours> listeCoursBdd = query.list();
			return listeCoursBdd;

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de la récupération par id du cours (CoursDAOImpl) ...");
			throw e;

		}

	}// end getAll() - cours

}
