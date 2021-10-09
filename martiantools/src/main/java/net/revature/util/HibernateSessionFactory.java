package net.revature.util;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
public class HibernateSessionFactory {

	private SessionFactory sessionFactory;
	
	public Session getSession() {
    	Properties props = new Properties();
    	FileReader fr;
		try {
			fr = new FileReader("src/main/resources/connection.properties");
	    	props.load(fr);
		} catch (IOException e) {
			e.printStackTrace();
		}
    	
		if(sessionFactory == null) {
			sessionFactory = new Configuration().configure()
					.setProperty("hibernate.connection.url", props.getProperty("endpoint"))
					.setProperty("hibernate.connection.username", props.getProperty("userName"))
					.setProperty("hibernate.connection.password", props.getProperty("password"))
					.buildSessionFactory();
		}
		
		return sessionFactory.getCurrentSession();
	}
}
