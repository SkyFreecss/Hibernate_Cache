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
		//创建配置对象
				Configuration config = new Configuration().configure();
				//创建服务注册对象
				ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(config.getProperties()).buildServiceRegistry();
				//创建工厂对象
				sessionfactory = config.buildSessionFactory(serviceRegistry);
				//创建会话对象
				session = sessionfactory.openSession();
			
				
				
		return session;
	}
}
