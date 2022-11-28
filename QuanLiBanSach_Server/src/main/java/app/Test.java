package app;

import java.util.Calendar;
import java.util.Date;
import java.util.Set;
import java.util.TreeSet;

import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.hql.ast.origin.hql.parse.HQLParser.new_key_return;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;
import org.hibernate.ogm.boot.OgmSessionFactoryBuilder;
import org.hibernate.ogm.cfg.OgmProperties;
import org.hibernate.service.ServiceRegistry;

import model.Account;
import model.Bill;
import model.Employee;
import model.Product;
import model.ProductBuy;



public class Test {
public static void main(String[] args) {
	ServiceRegistry serviceRegistry =  new StandardServiceRegistryBuilder()
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
	OgmSessionFactory sessionFactory	= metadata.getSessionFactoryBuilder()
			.unwrap(OgmSessionFactoryBuilder.class)
			.build();
	OgmSession session = sessionFactory.getCurrentSession();
	Transaction tr = session.beginTransaction();
	try {
		Employee employee = new Employee("12345678", "phong",  new  Date(2001, Calendar.JULY, 10), "Fghfg", "fghfgh", "fghgfh", "dfhgfhf", "dfgdfg", "dfgfdg", "dfg") ;
		Product product = new Product("Pro123", "DSFfdsd", "Sdfsdf", 0, 0, "Sfsdfs", "Sdfsdf");
		Account account = new Account(employee, "sdfsd", "sdfsdf", "sdfsdf");
		Bill bill = new Bill("jhhj", employee, "kkkk", new  Date(2001-1900, Calendar.JULY, 10), 100000);
		ProductBuy buy = new ProductBuy("ProBuy01",bill, product, "May tinh", 1000, 10, 0);
		ProductBuy buy1 = new ProductBuy("ProBuy02",bill, product, "May tinh bang", 1000, 10, 0);
		session.save(employee);
		session.save(product);
		session.save(account);
		session.save(bill);
		session.save(buy);
		session.save(buy1);
		tr.commit();
	} catch (Exception e) {
		// TODO: handle exception
		e.printStackTrace();
		tr.rollback();
	}
}
}
