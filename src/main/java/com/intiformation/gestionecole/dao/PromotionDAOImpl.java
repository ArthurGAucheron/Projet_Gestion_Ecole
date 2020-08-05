package com.intiformation.gestionecole.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.ReadOnlyProperty;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.Transactional;

import com.intiformation.gestionecole.modele.Promotion;

@Repository
@EnableTransactionManagement
@Transactional
public class PromotionDAOImpl implements IPromotionDAO {

	// déclaration de la session factory (hibernate)
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public void add(Promotion pPromotion) {
		Session session = this.sessionFactory.getCurrentSession();

		try {
			session.save(pPromotion);

		} catch (HibernateException e) {

			System.out.println("(PromotionDAOImpl) Erreur lors de l'ajout ...........;");
			throw e;

		} // end catch

	}// end add()

	@Override
	public void update(Promotion pPromotion) {
		Session session = this.sessionFactory.getCurrentSession();

		try {
			session.update(pPromotion);

		} catch (HibernateException e) {

			System.out.println("(PromotionDAOImpl) Erreur lors de la modif ...........;");

			throw e;

		} // end catch

	}// end update

	@Override
	public void delete(Long pIdPromotion) {
		Session session = this.sessionFactory.getCurrentSession();

		try {
			Promotion promotionToDelete = getById(pIdPromotion);
			session.delete(promotionToDelete);

		} catch (HibernateException e) {

			System.out.println("(PromotionDAOImpl) Erreur lors de la suppression ...........;");

			throw e;

		} // end catch

	}// end delete()

	@Override
	@ReadOnlyProperty
	public Promotion getById(Long pIdPromotion) {
		try {
			Session session = this.sessionFactory.openSession();
			Promotion promo = session.find(Promotion.class, pIdPromotion);
			return promo;
		} catch (Exception e) {

			System.out.println("(PromotionDAOImpl) Erreur lors de la recupération  by Id ...........;");
			throw e;
		} // end catch
	}// end getById()

	@Override
	@ReadOnlyProperty
	public List<Promotion> getAll() {
		try {
			Session session = this.sessionFactory.openSession();
			Query query = session.createQuery("FROM Promotion");
			List<Promotion> listePromotionsBDD = query.list();
			return listePromotionsBDD;
		} catch (Exception e) {

			System.out.println("(PromotionDAOImpl) Erreur lors de la recupération de la liste dans la BDD  ...........;");
			throw e;
		} // end catch
	}// end getAll()

}// end class