package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "listProduct")
public class Product implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String idProduct;
	
	@Column(name = "Name")
	private String name;
	
	@Column(name = "Type")
	private String type;
	
	@Column(name = "Price")
	private double price;
	
	@Column(name = "Amount")
	private int amount;
	
	@Column(name = "Supplier")
	private String supplier;
	
	@Column(name = "Status")
	private String status;
	/**
	 * @return the idProduct
	 */
	public String getIdProduct() {
		return idProduct;
	}
	/**
	 * @param idProduct the idProduct to set
	 */
	public void setIdProduct(String idProduct) {
		this.idProduct = idProduct;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}
	/**
	 * @param price the price to set
	 */
	public void setPrice(double price) {
		this.price = price;
	}
	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	/**
	 * @return the supplier
	 */
	public String getSupplier() {
		return supplier;
	}
	/**
	 * @param supplier the supplier to set
	 */
	public void setSupplier(String supplier) {
		this.supplier = supplier;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	public Product(String idProduct, String name, String type, double price, int amount, String supplier,
			String status) {
		super();
		this.idProduct = idProduct;
		this.name = name;
		this.type = type;
		this.price = price;
		this.amount = amount;
		this.supplier = supplier;
		this.status = status;
	}
	public Product() {
		super();
	}
	@Override
	public String toString() {
		return "Product [idProduct=" + idProduct + ", name=" + name + ", type=" + type + ", price=" + price
				+ ", amount=" + amount + ", supplier=" + supplier + ", status=" + status + "]";
	}
	
	
	
}
