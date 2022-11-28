package dao;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;
import model.ProductBuy;

public interface ProductBuyDao extends Remote {
	public boolean createProductBuy(ProductBuy productBuy) throws RemoteException;	
	public boolean deleteProductBuy(String idProductBuy) throws RemoteException;
	public boolean updateProductBuy(ProductBuy productBuy) throws RemoteException; 
	public List<ProductBuy> getProductBuys() throws RemoteException; 
	public ProductBuy getProductBuy(String idProductBuy) throws RemoteException;
	public List<ProductBuy> getProductBuyOfIdBill(String idBill) throws RemoteException; 
}
