
package com.cg.retailstore.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity

@Table(name = "retailer_table")
public class Retailer {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column
	private long retailer_id;

	@Column
	private String retailer_name;

	@Column
	private String email;

	/*
	 * @OneToMany(cascade=CascadeType.ALL)
	 * 
	 * @JoinColumn(name="retailer_id")
	 * 
	 * private List<Customer> customer ;
	 */

//requested product

	/*
	 * public List<Customer> getCustomer() { return customer; }
	 * 
	 * public void setCustomer(List<Customer> customer) { this.customer = customer;
	 * }
	 */

	public Retailer() {
		super();
	}

	public long getRetailer_id() {
		return retailer_id;
	}

	public void setRetailer_id(long retailer_id) {
		this.retailer_id = retailer_id;
	}

	public String getRetailer_name() {
		return retailer_name;
	}

	public void setRetailer_name(String retailer_name) {
		this.retailer_name = retailer_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

}
