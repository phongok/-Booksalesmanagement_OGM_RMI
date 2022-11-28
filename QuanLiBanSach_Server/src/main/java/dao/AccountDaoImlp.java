package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import model.Account;
import util.HibernateUtil;

public class AccountDaoImlp extends UnicastRemoteObject implements AccountDao {
	
	private OgmSessionFactory sessionFactory;
	public AccountDaoImlp() throws RemoteException {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean createAccount(Account account) throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.save(account);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		session.close();
		return false;
	}

	public boolean deleteAccount(String idAccount) throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.remove(session.find(Account.class, idAccount));
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateAccount(Account account) throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.update(account);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return false;
	}

	public List<Account> getAccounts() throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "db.listAccount.find({})";
			List<Account> accounts = session.createNativeQuery(query, Account.class).getResultList();
			tr.commit();
			return accounts;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return null;
	}

	public Account getAccount(String idAccount) throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			Account account = session.find(Account.class, idAccount);
			tr.commit();
			return account;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return null;
	}

}
