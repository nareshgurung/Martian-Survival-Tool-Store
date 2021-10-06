package com.revature.repository;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import net.revature.models.Users;
import net.revature.utils.HibernateUtil;

public class UsersRepository {

	public UsersRepository() {
		
	}
	public List<Users> getAllUsers() {
		Transaction tx = null;
		Query<Users> uList = null;
		try {
			Session ses=HibernateUtil.getSession();
			tx = ses.beginTransaction();
			uList = ses.createQuery("from Users", Users.class);
			tx.commit();
			
		}catch(HibernateException e) {
			tx.rollback();
			System.out.println("no data");
			e.printStackTrace();
		}
		return uList.list();
	}
}
