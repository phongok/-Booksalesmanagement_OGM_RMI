package dao;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

import org.hibernate.Transaction;
import org.hibernate.ogm.OgmSession;
import org.hibernate.ogm.OgmSessionFactory;

import model.Employee;
import util.HibernateUtil;

public class EmployeeDaoImlp extends UnicastRemoteObject implements EmployeeDao {
	private OgmSessionFactory sessionFactory;

	public EmployeeDaoImlp() throws RemoteException {
		sessionFactory = HibernateUtil.getInstance().getSessionFactory();
	}

	private static final long serialVersionUID = 1L;

	public boolean createEmployee(Employee employee) throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.save(employee);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}

		session.close();
		return false;
	}

	public boolean deleteEmployee(String idEmployee) throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			session.remove(session.find(Employee.class, idEmployee));
			tr.commit();
			return true;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return false;
	}

	public boolean updateEmployee(Employee employee) throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			session.update(employee);
			tr.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return false;
	}

	public List<Employee> getEmployees() throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.getTransaction();
		try {
			tr.begin();
			String query = "db.listEmployee.find({})";
			List<Employee> employees = session.createNativeQuery(query, Employee.class).getResultList();
			tr.commit();
			return employees;
		} catch (Exception e) {
			tr.rollback();
			e.printStackTrace();
		}
		return null;
	}

	public Employee getEmployee(String idEmployee) throws RemoteException {
		OgmSession session = sessionFactory.openSession();
		Transaction tr = session.beginTransaction();
		try {
			Employee employee = session.find(Employee.class, idEmployee);
			tr.commit();
			return employee;
		} catch (Exception e) {
			e.printStackTrace();
			tr.rollback();
		}
		session.close();
		return null;
	}

}
