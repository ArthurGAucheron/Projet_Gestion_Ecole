package com.intiformation.gestionecole.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.gestionecole.modele.Enseignant;
import com.intiformation.gestionecole.modele.Matiere;

/**
 * 
 * @author Arthur.GA
 *
 */
@Repository
public class EnseignantDAOImpl implements IEnseignantDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Transactional
	@Override
	public void add(Enseignant pEnseignant) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			session.save(pEnseignant);
		} catch (HibernateException e) {
			System.out.println("....(EnseignantDAOImpl) Erreurr lors de l'ajout d'un Enseignant");
			throw e;
		}
	}

	@Transactional
	@Override
	public void update(Enseignant pEnseignant) {
		Session session = this.sessionFactory.getCurrentSession();
		try {

			session.update(pEnseignant);
		} catch (HibernateException e) {
			System.out.println("....(EnseignantDAOImpl) Erreurr lors de la mise à jours d'un Enseignant");
			throw e;
		}

	}// end update

	@Transactional
	@Override
	public void delete(Long pIdEnseignant) {
		Session session = this.sessionFactory.getCurrentSession();
		try {

			Enseignant enseignantToDelte = getById(pIdEnseignant);
			session.delete(enseignantToDelte);
		} catch (Exception e) {
			System.out.println("....(EnseignantDAOImpl) Erreurr lors de la suppréssion d'un Enseignant");
			throw e;
		}
	}// end delete

	@Transactional
	@Override
	public Enseignant getById(Long pIdEnseignant) {
		Session session = this.sessionFactory.openSession();
		try {

			Enseignant enseignant = session.find(Enseignant.class, pIdEnseignant);
			return enseignant;
		} catch (HibernateException e) {
			System.out.println("....(EnseignantDAOImpl) Erreurr lors de la recherche d'un Enseignant par son id");
			throw e;
		}
	}// end getById

	@Transactional(readOnly = true)
	@Override
	public List<Enseignant> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			
			Query query = session.createQuery("FROM Enseignant");
			List<Enseignant> listeEnseignant = query.list();
			return listeEnseignant;
			
		} catch (HibernateException e) {
			System.out.println("....(EnseignantDAOImpl) Erreurr lors de la récupération de la liste des Enseignants");
			throw e;
		}
		
	}// end getAll

	@Override
	@Transactional(readOnly=true)
	public Enseignant getIdentite(String pIdentifiant) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Query query = session.createQuery("FROM Personne WHERE identifiant = :p_identifiant");
			query.setParameter("p_identifiant", pIdentifiant);
			Enseignant ens = (Enseignant) query.uniqueResult();
			return ens;
		} catch (Exception e) {

			System.out.println("(EnseignantDAOImpl) Erreur lors de la recupération de l'identité de l'enseignant dans la BDD  ...........;");
			throw e;
		} // end catch
	}//end getIdentite
}// end class
