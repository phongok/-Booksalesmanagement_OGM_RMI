package dao;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Bill;
public interface BillDao extends Remote{
	public boolean createBill(Bill bill) throws RemoteException;	
	public boolean deleteBill(String idBill) throws RemoteException;
	public boolean updateBill(Bill bill) throws RemoteException; 
	public List<Bill> getBills() throws RemoteException; 
	public Bill getBill(String idBill) throws RemoteException;
}
