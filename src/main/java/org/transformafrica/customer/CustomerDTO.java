package org.transformafrica.customer;

public class CustomerDTO {

	private String sName;
	private String name;
	private String idNumber;

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public String getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(String idNumber) {
		this.idNumber = idNumber;
	}

	public Boolean isDataValid() {

		if (name == null) {
			return false;
		}
		if (sName == null) {
			return false;
		}
		if (idNumber == null) {
			return false;
		}
		return true;

	}

}
