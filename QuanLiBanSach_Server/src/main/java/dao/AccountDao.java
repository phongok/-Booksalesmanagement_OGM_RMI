package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import model.Account;

public interface AccountDao  extends Remote {
	public boolean createAccount(Account account) throws RemoteException;	
	public boolean deleteAccount(String idAccount) throws RemoteException;
	public boolean updateAccount(Account account) throws RemoteException; 
	public List<Account> getAccounts() throws RemoteException; 
	public Account getAccount(String idAccount) throws RemoteException;
}
