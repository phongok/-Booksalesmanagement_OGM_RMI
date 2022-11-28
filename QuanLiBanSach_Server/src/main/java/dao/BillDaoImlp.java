package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import model.Bill;
import util.HibernateUtil;

public class BillDaoImlp extends UnicastRemoteObject implements BillDao {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OgmSessionFactory sessionFactory;
	
	public BillDaoImlp() throws RemoteException {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}


	public boolean createBill(Bill bill) throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.save(bill);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return false;
	}

	public boolean deleteBill(String idBill) throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.remove(session.find(Bill.class, idBill));
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateBill(Bill bill) throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.update(bill);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return false;
	}

	public List<Bill> getBills() throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "db.listBill.find({})";
			List<Bill> bills = session.createNativeQuery(query, Bill.class).getResultList();
			tr.commit();
			return bills;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return null;
	}

	public Bill getBill(String idBill) throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			Bill bill = session.find(Bill.class, idBill);
			tr.commit();
			return bill;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return null;
	}

}
