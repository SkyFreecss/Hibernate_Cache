package com.Demo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class HibernateUtil {
	private static final SessionFactory sessionfactory = new Configuration().configure().buildSessionFactory();
	
	public HibernateUtil()
	{
		
	}

	public static Session getSession() {
		return sessionfactory.openSession();
	}
}
