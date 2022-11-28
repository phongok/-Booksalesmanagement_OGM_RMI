package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.Employee;

public interface EmployeeDao extends Remote {

	public boolean createEmployee(Employee employee) throws RemoteException;

	public boolean deleteEmployee(String idEmployee) throws RemoteException;

	public boolean updateEmployee(Employee employee) throws RemoteException;

	public List<Employee> getEmployees() throws RemoteException;

	public Employee getEmployee(String idEmployee) throws RemoteException;

}
