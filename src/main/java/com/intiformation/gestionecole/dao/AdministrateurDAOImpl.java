package com.intiformation.gestionecole.dao;

import java.util.List;



import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.gestionecole.modele.Administrateur;

/**
 * <pre>
 * 	Implémentation concrète des méthodes Administrateur
 * </pre>
 * 
 * @author Arthur.GA
 *
 */
@Repository
@EnableTransactionManagement
public class AdministrateurDAOImpl implements IAdministrateurDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * <pre>
	 * Ajout d'un administrateur dans la BDD <br/>
	 * </pre>
	 * 
	 * @param pAdministrateur
	 *            : Administrateur à ajouter
	 */
	@Override
	@Transactional
	public void add(Administrateur pAdministrateur) {
		Session session = this.sessionFactory.getCurrentSession();
		try {


			session.save(pAdministrateur);
		} catch (HibernateException e) {
			System.out.println("....(AdministrateurDAOImpl) Erreurr lors de l'ajout d'un Administrateur");
			throw e;
		}
	}// end add

	/**
	 * <pre>
	 * 	Modif d'un administrateur dans la BDD <br/>
	 * </pre>
	 * 
	 * @param pAdministrateur
	 *            : Administrateur modifier
	 */
	
	@Override
	@Transactional
	public void update(Administrateur pAdministrateur) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			
			session.update(pAdministrateur);
		} catch (HibernateException e) {
			System.out.println("....(AdministrateurDAOImpl) Erreurr lors de la mise à jours d'un Administrateur");
			throw e;
		}

	}// end update

	/**
	 * <pre>
	 * 	Suppréssion d'un administrateur dans la BDD <br/>
	 * </pre>
	 * 
	 * @param pIdAdministrateur
	 *            : Administrateur à supprimer
	 */
	
	@Override
	@Transactional
	public void delete(Long pIdAdministrateur) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
		
			Administrateur adminToDelte = getById(pIdAdministrateur);
			session.delete(adminToDelte);
		} catch (Exception e) {
			System.out.println("....(AdministrateurDAOImpl) Erreurr lors de la suppréssion d'un Administrateur");
			throw e;
		}
	}// end delete

	/**
	 * <pre>
	 * 	Récupération d'un administrateur dans la BDD par son id <br/>
	 * </pre>
	 */

	@Override
	@Transactional(readOnly=true)
	public Administrateur getById(Long pIdAdministrateur) {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			
			Administrateur admin = session.find(Administrateur.class, pIdAdministrateur);
			return admin;
		} catch (HibernateException e) {
			System.out.println("....(AdministrateurDAOImpl) Erreurr lors de la recherche d'un Administrateur par son id");
			throw e;
		}
		
	}// end getById

	/**
	 * <pre>
	 * 	Récupération des administrateurs dans la BDD <br/>
	 * </pre>
	 */
	
	@Override
	@Transactional(readOnly=true)
	public List<Administrateur> getAll() {
		Session session = this.sessionFactory.getCurrentSession();
		try {
			
			Query query = session.createQuery("FROM Administrateur");
			List<Administrateur> listeAdmin = query.list();
			return listeAdmin;
			
		} catch (HibernateException e) {
			System.out.println("....(AdministrateurDAOImpl) Erreurr lors de la récupération de la liste des Administrateurs");
			throw e;
		}
		
	}// end getAll

	/**
	 * Permet de vérifier si un identifiant est libre <br/>
	 * Retourne vrai si un identifiant correspond <br/>
	 * Recherche pour tout type de personne (etu/ens/admin)
	 * 
	 */
	@Override
	@Transactional(readOnly=true)
	public boolean identifiantIsExist(String pIdentifiantAdmin) {
		
		Session session = this.sessionFactory.getCurrentSession();
		try {
			
			Query query = session.createQuery("SELECT count(p.identifiant) FROM Personne p WHERE p.identifiant= :pIdentifant");
			query.setParameter("pIdentifant", pIdentifiantAdmin);
			Long result = (Long) query.getSingleResult();
			return result == 1L;
			
		} catch (HibernateException e) {
			System.out.println("....(AdministrateurDAOImpl) Erreurr lors de la recherche d'un identifiant");
			throw e;
		}

	}

}// end class
