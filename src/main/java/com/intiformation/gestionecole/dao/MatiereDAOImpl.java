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

import com.intiformation.gestionecole.modele.Matiere;

@Repository
@EnableTransactionManagement
public class MatiereDAOImpl implements IMatiereDAO {

	// déclaration de la session factory (hibernate)
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	@Transactional
	public void add(Matiere pMatiere) {

		Session session = this.sessionFactory.getCurrentSession();

		try {
			session.save(pMatiere);

		} catch (HibernateException e) {

			System.out.println("(MatiereDAOImpl) Erreur lors de l'ajout ...........;");
			throw e;

		} // end catch

	}// end add()

	@Override
	@Transactional
	public void update(Matiere pMatiere) {
		Session session = this.sessionFactory.getCurrentSession();

		try {
			session.update(pMatiere);

		} catch (HibernateException e) {

			System.out.println("(MatiereDAOImpl) Erreur lors de la modif ...........;");

			throw e;

		} // end catch

	}// end update

	@Override
	@Transactional
	public void delete(Long pIdMatiere) {
		Session session = this.sessionFactory.getCurrentSession();

		try {
			Matiere matiereToDelete = getById(pIdMatiere);
			session.delete(matiereToDelete);

		} catch (HibernateException e) {

			System.out.println("(MatiereDAOImpl) Erreur lors de la suppression ...........;");

			throw e;

		} // end catch

	}//end delete()

	@Override
	@Transactional (readOnly=true)
	public Matiere getById(Long pIdMatiere) {
		try {
			Session session = this.sessionFactory.getCurrentSession();
			Matiere mat = session.find(Matiere.class, pIdMatiere);
			return mat;
		} catch (Exception e) {

			System.out.println("(MatiereDAOImpl) Erreur lors de la recupération  by Id ...........;");
			throw e;
		} // end catch
	}//end getById()

	@Override
	@Transactional (readOnly=true)
	public List<Matiere> getAll() {
		try {
			Session session = this.sessionFactory.openSession();
			Query query = session.createQuery("FROM Matiere");
			List<Matiere> listeMatieresBDD = query.list();
			return listeMatieresBDD;
		} catch (Exception e) {

			System.out.println("(MatiereDAOImpl) Erreur lors de la recupération de la liste dans la BDD  ...........;");
			throw e;
		} // end catch
	}//end getAll()

}//end class