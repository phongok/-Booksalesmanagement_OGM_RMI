package util;

import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.ogm.boot.OgmSessionFactoryBuilder;
import org.hibernate.ogm.cfg.OgmProperties;
import org.hibernate.service.ServiceRegistry;

import model.Account;
import model.Bill;
import model.Employee;
import model.Product;
import model.ProductBuy;

public class HibernateUtil {
	private static HibernateUtil instance = null;
	private OgmSessionFactory sessionFactory;
	
	private HibernateUtil() {
		
		ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
				.applySetting(OgmProperties.ENABLED, true)
				.configure()
				.build();
		
		Metadata metadata = new MetadataSources(serviceRegistry)
				.addAnnotatedClass(Employee.class)
				.addAnnotatedClass(Product.class)
				.addAnnotatedClass(Account.class)
				.addAnnotatedClass(Bill.class)
				.addAnnotatedClass(ProductBuy.class)
				.getMetadataBuilder()
				.build();
		
		sessionFactory = metadata
				.getSessionFactoryBuilder()
				.unwrap(OgmSessionFactoryBuilder.class)
				.build();
		
	}
	
	public synchronized static HibernateUtil getInstance() {
		if(instance == null)
			instance = new HibernateUtil();
		return instance;
	}
	
	public OgmSessionFactory getSessionFactory() {
		return sessionFactory;
	}
	
	public void close() {
		sessionFactory.close();
	}
}
