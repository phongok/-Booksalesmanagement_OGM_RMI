package app;

import java.rmi.RemoteException;
import java.util.List;

import dao.ProductBuyDao;
import dao.ProductBuyDaoImlp;
import model.Bill;
import model.Product;
import model.ProductBuy;

public class kkk {

	public static void main(String[] args) throws RemoteException {
		// TODO Auto-generated method stub
		ProductBuyDao productBuyDao = new ProductBuyDaoImlp();
//		Bill bill = new Bill("HD01", null, null, null, 0);
//		Product product = new Product("Pro123", "DSFfdsd", "Sdfsdf", 0, 0, "Sfsdfs", "Sdfsdf");
//		ProductBuy buy = new ProductBuy("ProBuy01",bill, product, "May tinh", 1000, 10, 0);
//		productBuyDao.createProductBuy(buy);
		
		List<ProductBuy> productBuys = productBuyDao.getProductBuyOfIdBill("HD01");
		
		for (ProductBuy productBuy : productBuys) {
			System.out.println(productBuy);
		}

	}

}
