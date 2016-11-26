package com.Demo.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;


public class HibernateUtil {
	private static Session session;
	private static SessionFactory sessionfactory;

	public static Session getSession() {
		//�������ö���
				Configuration config = new Configuration().configure();
				//��������ע�����
				ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
				//������������
				sessionfactory = config.buildSessionFactory(serviceRegistry);
				//�����Ự����
				session = sessionfactory.openSession();
			
				
				
		return session;
	}
}
