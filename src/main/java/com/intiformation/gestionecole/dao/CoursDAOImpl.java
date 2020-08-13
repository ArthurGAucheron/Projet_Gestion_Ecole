package com.intiformation.gestionecole.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.gestionecole.modele.Cours;
import com.intiformation.gestionecole.modele.Enseignant;
import com.intiformation.gestionecole.modele.Etudiant;
import com.intiformation.gestionecole.modele.Matiere;
import com.intiformation.gestionecole.modele.Promotion;


@Repository
@EnableTransactionManagement
public class CoursDAOImpl implements ICoursDAO {

	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
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
	@Transactional
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
	@Transactional
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
	@Transactional (readOnly=true)
	public Cours getById(Long pIdCours) {

		Session session = this.sessionFactory.getCurrentSession();

		try {

			Cours cours = session.find(Cours.class, pIdCours);
			return cours;

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de la récupération par id du cours (CoursDAOImpl) ...");
			throw e;

		}

	}// end getById() - cours

	@Override
	@Transactional(readOnly=true)
	public List<Cours> getAll() {

		Session session = this.sessionFactory.getCurrentSession();

		try {

			Query query = session.createQuery("FROM Cours");
			List<Cours> listeCoursBdd = query.list();
			return listeCoursBdd;

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de la récupération des cours (CoursDAOImpl) ...");
			throw e;

		}

	}// end getAll() - cours

	@Override
	@Transactional
	public List<Cours> getCoursEns(Long pIdEns) {
		Session session = this.sessionFactory.getCurrentSession();

		try {
			
			MatiereDAOImpl matDAO = new MatiereDAOImpl(sessionFactory);  
			Matiere mat = matDAO.getByIdEns(pIdEns);
			Long pIDMat = mat.getIdMatiere();
			Query query = session.createQuery("FROM Cours WHERE matiere.idMatiere = :p_id_mat");
			query.setParameter("p_id_mat", pIDMat);
			List<Cours> listeCoursEnsBdd = query.list();
			return listeCoursEnsBdd;

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de la récupération par Enseignant du cours (CoursDAOImpl) ...");
			throw e;

		}//end catch
	}//end getCoursEns
	
	@Override
	@Transactional (readOnly=true)
	public List<Cours> getCoursEtu(Long pIdEtu) {
		Session session = this.sessionFactory.getCurrentSession();

try {
			
			EtudiantDAOImpl etuDAO = new EtudiantDAOImpl(sessionFactory);  
			Etudiant etu = etuDAO.getById(pIdEtu);
			Long pIDPromo = etu.getPromotion().getIdPromotion();
			Query query = session.createQuery("FROM Cours WHERE promotion.idPromotion = :p_id_promo");
			query.setParameter("p_id_promo", pIDPromo);
			List<Cours> listeCoursEtuBdd = query.list();
			return listeCoursEtuBdd;

		} catch (HibernateException e) {

			System.out.println("... Erreur lors de la récupération par Etudiant du cours (CoursDAOImpl) ...");
			throw e;

		}//end catch
	}//end getCoursEns

}//end class