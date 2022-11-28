package model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name = "listBill")
public class Bill implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	private String idBill;
	
	@ManyToOne
	@JoinColumn(name = "idEmloyee")
	
	private Employee employee;
	
	@Column(name = "NameCustomer")
	private String nameCustomer;
	
	@Column(name = "DateCreate")
	private Date datecreate;
	
	@Column(name = "Money")
	private double money;

	/**
	 * @return the idBill
	 */
	public String getIdBill() {
		return idBill;
	}

	/**
	 * @param idBill the idBill to set
	 */
	public void setIdBill(String idBill) {
		this.idBill = idBill;
	}

	/**
	 * @return the employee
	 */
	public Employee getEmployee() {
		return employee;
	}

	/**
	 * @param employee the employee to set
	 */
	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	/**
	 * @return the nameCustomer
	 */
	public String getNameCustomer() {
		return nameCustomer;
	}

	/**
	 * @param nameCustomer the nameCustomer to set
	 */
	public void setNameCustomer(String nameCustomer) {
		this.nameCustomer = nameCustomer;
	}

	/**
	 * @return the datecreate
	 */
	public Date getDatecreate() {
		return datecreate;
	}

	/**
	 * @param datecreate the datecreate to set
	 */
	public void setDatecreate(Date datecreate) {
		this.datecreate = datecreate;
	}

	/**
	 * @return the money
	 */
	public double getMoney() {
		return money;
	}

	/**
	 * @param money the money to set
	 */
	public void setMoney(double money) {
		this.money = money;
	}

	public Bill(String idBill, Employee employee, String nameCustomer, Date datecreate, double money) {
		super();
		this.idBill = idBill;
		this.employee = employee;
		this.nameCustomer = nameCustomer;
		this.datecreate = datecreate;
		this.money = money;
	}

	public Bill() {
		super();
	}

	@Override
	public String toString() {
		return "Bill [idBill=" + idBill + ", employee=" + employee + ", nameCustomer=" + nameCustomer + ", datecreate="
				+ datecreate + ", money=" + money + "]";
	}
	
	
	
}
