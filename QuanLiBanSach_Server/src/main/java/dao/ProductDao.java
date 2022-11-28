package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.Product;

public interface ProductDao  extends Remote {
	public boolean createProduct(Product product) throws RemoteException;	
	public boolean deleteProduct(String idProduct) throws RemoteException;
	public boolean updateProduct(Product product) throws RemoteException; 
	public List<Product> getProducts() throws RemoteException; 
	public Product getProduct(String idProduct) throws RemoteException;
}
