package org.transformafrica.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import io.quarkus.panache.common.Parameters;

@Entity
@Table(name = "CUSTOMERS")
public class Customer extends PanacheEntity {

	@Column(name = "surname")
	private String sName;
	@Column(name = "name")
	private String name;
	@Column(name = "id_number")
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

	public static List<Customer> getCustomerByIDNumber(String idNumber) {

		return find("idNumber=:idNumber ", Parameters.with("idNumber", idNumber)).list();
	}

}
