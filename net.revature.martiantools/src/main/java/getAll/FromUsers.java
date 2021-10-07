package getAll;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Repository;

import net.revature.models.Users;
import net.revature.util.HibernateSessionFactory;

@Repository("usersRepository")

public class FromUsers {
	
	
	
	@PersistenceContext
	private EntityManager entityManager;
	
	public List<Users> getAll(){
		
			return entityManager.createQuery("FROM Users", Users.class).getResultList();
			
//		Session session = new HibernateSessionFactory().getSession();
//		Transaction tx = null;
//		List<net.revature.models.Users> list = null;
//		
//		
//		try {
//			tx = session.beginTransaction();
//			list = session.createQuery("FROM Users", Users.class).getResultList();
//		} catch (HibernateException e) {
//			if (tx!=null) tx.rollback();
//			e.printStackTrace(); 
//		} finally {
//			session.close(); 
//		}
//		return list;
	}
	
//	public Users getByUsername(Users obj) {
//		
//	Session session = new Hib
//		
//	}
}
