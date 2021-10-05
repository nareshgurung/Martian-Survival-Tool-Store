package net.revature.martiantools.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	
	private static SessionFactory sessionFactory;
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			
			try {
			sessionFactory = new Configuration().configure()
					.setProperty("hibernate.connection.url", "jdbc:mariadb://database-1.c0dfrhw8olgo.us-east-2.rds.amazonaws.com:3306/project-2")
					.setProperty("hibernate.connection.username", "Carolina")
					.setProperty("hibernate.connection.password", "carolinaPassword").buildSessionFactory();
			

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return sessionFactory;
	}
	
	
	
}