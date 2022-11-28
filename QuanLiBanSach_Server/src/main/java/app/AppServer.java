package app;

import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.registry.LocateRegistry;

import org.hibernate.hql.ast.origin.hql.parse.HQLParser.new_key_return;

import dao.AccountDao;
import dao.AccountDaoImlp;
import dao.BillDao;
import dao.BillDaoImlp;
import dao.EmployeeDao;
import dao.EmployeeDaoImlp;
import dao.ProductBuyDao;
import dao.ProductBuyDaoImlp;
import dao.ProductDao;
import dao.ProductDaoImlp;

public class AppServer {
	public static void main(String[] args) {
		SecurityManager securityManager = System.getSecurityManager();
		if(securityManager == null) {
			System.setProperty("java.security.policy", "rmi/policy.policy");
			System.setSecurityManager(new SecurityManager());
		}
		
		try {
			EmployeeDao employeeDao = new EmployeeDaoImlp();
			ProductDao productDao = new ProductDaoImlp();
			AccountDao accountDao = new AccountDaoImlp();
			BillDao billDao = new BillDaoImlp();
			ProductBuyDao productBuyDao = new ProductBuyDaoImlp();
			
			LocateRegistry.createRegistry(1000);
			
			
			Naming.bind("rmi://localhost:1000/employeeDao", employeeDao);
			Naming.bind("rmi://localhost:1000/productDao", productDao);
			Naming.bind("rmi://localhost:1000/accountDao", accountDao);
			Naming.bind("rmi://localhost:1000/billDao", billDao);
			Naming.bind("rmi://localhost:1000/productBuyDao", productBuyDao);
			
			
			System.out.println("Remote Object bound in RMIRegistry");
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
