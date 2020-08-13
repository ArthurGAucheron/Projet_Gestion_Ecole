package com.intiformation.gestionecole.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.gestionecole.modele.Etudiant;
import com.intiformation.gestionecole.modele.EtudiantCours;

@Repository
public class EtudiantCoursDAOImpl implements IEtudiantCoursDAO{
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void add(EtudiantCours pEtudiantCours) {
		
		Session session = this.sessionFactory.getCurrentSession();

		try {

			session.save(pEtudiantCours);

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de l'ajout de EtudiantCours (EtudiantCoursDAOImpl) ...");
			throw e;

		}
		
	}

	@Override
	@Transactional
	public void update(EtudiantCours pEtudiantCours) {
		
		Session session = this.sessionFactory.getCurrentSession();

		try {

			session.update(pEtudiantCours);

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de la modificatiob de EtudiantCours (EtudiantCoursDAOImpl) ...");
			throw e;

		}
		
	}

	@Override
	@Transactional
	public void delete(Long pIdEtudiantCours) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		try {
		
			EtudiantCours etudiantCours = getById(pIdEtudiantCours);
			session.delete(etudiantCours);
			
		} catch (Exception e) {
			
			System.out.println(".... Erreur lors de la suppression de EtudiantCours (EtudiantDAOImpl)...");
			throw e;
			
		}
		
	}

	@Override
	@Transactional(readOnly=true)
	public EtudiantCours getById(Long pIdEtudiantCours) {
		
		Session session = this.sessionFactory.getCurrentSession();

		try {

			EtudiantCours etudiantCours = session.find(EtudiantCours.class, pIdEtudiantCours);
			return etudiantCours;

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de la récupération par id de EtudiantCours (EtudiantDAOImpl) ...");
			throw e;

		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<EtudiantCours> getAll() {
		
		Session session = this.sessionFactory.getCurrentSession();

		try {

			Query query = session.createQuery("FROM EtudiantCours");
			List<EtudiantCours> listeEtudiantsCoursBdd = query.list();
			return listeEtudiantsCoursBdd;

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de la récupération de la liste EtudiantCours (EtudiantDAOImpl) ...");
			throw e;

		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<EtudiantCours> getAllByCourId(Long pIdCours) {
		Session session = this.sessionFactory.getCurrentSession();
		
		try {

			Query query = session.createQuery("FROM EtudiantCours WHERE cours.idCours = :p_id_cours");
			query.setParameter("p_id_cours", pIdCours);
			List<EtudiantCours> listeEtudiantCoursBdd = query.list();
			return listeEtudiantCoursBdd;

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de la récupération de EtudiantCours (EtudiantDAOImpl) ...");
			throw e;

		}
	}

	@Override
	@Transactional(readOnly=true)
	public List<EtudiantCours> getAllByEtudiantId(Long pIdEtudiant) {
		Session session = this.sessionFactory.getCurrentSession();
		
		try {

			Query query = session.createQuery("FROM EtudiantCours WHERE etudiant.idPersonne = :p_id_etudiant AND absence = 1");
			query.setParameter("p_id_etudiant", pIdEtudiant);
			List<EtudiantCours> listeEtudiantCoursBdd = query.list();
			return listeEtudiantCoursBdd;

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de la récupération de EtudiantCours (EtudiantDAOImpl) ...");
			throw e;

		}
	}

}
