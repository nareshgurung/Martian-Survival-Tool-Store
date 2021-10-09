package net.revature.daos;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import net.revature.util.HibernateSessionFactory;

public class FromCategories {
	public static <T> List<T> getAll(String tableName, T table){
		Session session = new HibernateSessionFactory().getSession();
		Transaction tx = null;
		List<T> list = null;
		try {
			tx = session.beginTransaction();
			list = session.createQuery("FROM " + tableName).getResultList();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		return list;
	}
}
