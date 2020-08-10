package com.intiformation.gestionecole.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.gestionecole.modele.Cours;
import com.intiformation.gestionecole.modele.Etudiant;

@Repository("EtudiantDAOBean")
public class EtudiantDAOImpl implements IEtudiantDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	@Transactional
	public void add(Etudiant pEtudiant) {
		
		Session session = this.sessionFactory.getCurrentSession();

		try {

			session.save(pEtudiant);

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de l'ajout de l'étudiant (EtudiantDAOImpl) ...");
			throw e;

		}
		
	}//end add() - étudiant

	@Override
	@Transactional
	public void update(Etudiant pEtudiant) {
		
		Session session = this.sessionFactory.getCurrentSession();

		try {

			session.update(pEtudiant);

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de la modificatiob de l'étudiant (EtudiantDAOImpl) ...");
			throw e;

		}
		
	}//end update() - étudiant

	@Override
	@Transactional
	public void delete(Long pIdEtudiant) {
		
		Session session = this.sessionFactory.getCurrentSession();
		
		try {
		
			Etudiant etudiant = getById(pIdEtudiant);
			session.delete(etudiant);
			
		} catch (Exception e) {
			
			System.out.println(".... Erreur lors de la suppression de l'étudiant (EtudiantDAOImpl)...");
			throw e;
			
		}
		
	}//end delete() - étudiant

	@Override
	@Transactional(readOnly=true)
	public Etudiant getById(Long pIdEtudiant) {

		Session session = this.sessionFactory.openSession();

		try {

			Etudiant etudiant = session.find(Etudiant.class, pIdEtudiant);
			return etudiant;

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de la récupération par id del'étudiant (EtudiantDAOImpl) ...");
			throw e;

		}

	}//end getById() - étudiant

	@Override
	@Transactional(readOnly=true)
	public List<Etudiant> getAll() {

		Session session = this.sessionFactory.openSession();

		try {

			Query query = session.createQuery("FROM Cours");
			List<Etudiant> listeEtudiantsBdd = query.list();
			return listeEtudiantsBdd;

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de la récupération des étudiants (CoursDAOImpl) ...");
			throw e;

		}

	}//end getAll() - étudiant

}
