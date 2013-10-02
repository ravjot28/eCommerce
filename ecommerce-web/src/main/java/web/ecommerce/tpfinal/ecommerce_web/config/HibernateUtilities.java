package web.ecommerce.tpfinal.ecommerce_web.config;

import org.hibernate.HibernateException;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

public class HibernateUtilities {

	public static SessionFactory sessionFactory;
	public static ServiceRegistry serviceRegistry;
	
	
	static{
		try{
			Configuration configuration = new Configuration().configure();
			
			serviceRegistry = new ServiceRegistryBuilder().applySettings(configuration.getProperties()).buildServiceRegistry();
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
			
		}
		catch(HibernateException exeption){
			System.out.println("Problema creando sesion factory");
		}
	}
	
	public static SessionFactory getSessionFactory(){
		return sessionFactory;
	}
}
