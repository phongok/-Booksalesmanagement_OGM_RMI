package app;


import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.util.List;

import dao.EmployeeDao;
import model.Employee;

public class TestClient {
	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			EmployeeDao employeeDao = (EmployeeDao) Naming.lookup("rmi://localhost:1000/employeeDao");
			List<Employee> employees = employeeDao.getEmployees();
			for (Employee employee : employees) {
				System.out.println(employee);
			}
			
			
			
			
		} catch (MalformedURLException | RemoteException | NotBoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
