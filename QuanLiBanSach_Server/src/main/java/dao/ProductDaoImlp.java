package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;
import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;
import model.Product;
import util.HibernateUtil;

public class ProductDaoImlp extends UnicastRemoteObject implements ProductDao {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private OgmSessionFactory sessionFactory;

	public ProductDaoImlp() throws RemoteException {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	public boolean createProduct(Product product) throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.save(product);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		session.close();
		return false;
	}

	public boolean deleteProduct(String idProduct) throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.remove(session.find(Product.class, idProduct));
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateProduct(Product product) throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.update(product);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return false;
	}

	public List<Product> getProducts() throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "db.listProduct.find({})";
			List<Product> products = session.createNativeQuery(query, Product.class).getResultList();
			tr.commit();
			return products;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return null;
	}

	public Product getProduct(String idProduct) throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			Product product = session.find(Product.class, idProduct);
			tr.commit();
			return product;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return null;
	}

}
