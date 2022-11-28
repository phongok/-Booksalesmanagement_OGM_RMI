package model;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Account_PK implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String employee;

	public Account_PK() {
		super();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((employee == null) ? 0 : employee.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account_PK other = (Account_PK) obj;
		if (employee == null) {
			if (other.employee != null)
				return false;
		} else if (!employee.equals(other.employee))
			return false;
		return true;
	}

}
