package model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@IdClass(Account_PK.class)
@Table(name = "listAccount")
public class Account implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@OneToOne
	@JoinColumn(name = "idEmloyee")
	private Employee employee;

	@Column(name = "Type")
	private String type;

	@Column(name = "Status")
	private String status;

	@Column(name = "Password")
	private String password;

	/**
	 * @return the idAccount
	 */
	public Employee getIdAccount() {
		return employee;
	}

	/**
	 * @param idAccount the idAccount to set
	 */
	public void setIdAccount(Employee idAccount) {
		this.employee = idAccount;
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

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	public Account() {
		super();
	}

	public Account(Employee employee, String type, String status, String password) {
		super();
		this.employee = employee;
		this.type = type;
		this.status = status;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [employee=" + employee + ", type=" + type + ", status=" + status + ", password=" + password
				+ "]";
	}

}
