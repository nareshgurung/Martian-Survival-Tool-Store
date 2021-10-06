package getAll;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import net.revature.models.Categories;
import util.HibernateSessionFactory;

public class FromCategories {
	public static List<Categories> getAll(){
		Session session = new HibernateSessionFactory().getSession();
		Transaction tx = null;
		List<net.revature.models.Categories> list = null;
		
		
		try {
			tx = session.beginTransaction();
			list = session.createQuery("FROM Categories", Categories.class).getResultList();
		} catch (HibernateException e) {
			if (tx!=null) tx.rollback();
			e.printStackTrace(); 
		} finally {
			session.close(); 
		}
		return list;
	}
}
