
package com.cg.retailstore.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "products_table")
public class Products {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column
	private long products_id;

	@Column
	private String products_name;

	@Column
	private String products_type;

	@Column
	private String products_quantity;

	@Column
	private long products_price;

	@OneToOne
	@JoinColumn(name = "customer_id")

	private Customer customer;

	public long getProducts_id() {
		return products_id;
	}

	public void setProducts_id(long products_id) {
		this.products_id = products_id;
	}

	public String getProducts_name() {
		return products_name;
	}

	public void setProducts_name(String products_name) {
		this.products_name = products_name;
	}

	public String getProducts_type() {
		return products_type;
	}

	public void setProducts_type(String products_type) {
		this.products_type = products_type;
	}

	public String getProducts_quantity() {
		return products_quantity;
	}

	public void setProducts_quantity(String products_quantity) {
		this.products_quantity = products_quantity;
	}

	public long getProducts_price() {
		return products_price;
	}

	public void setProducts_price(long products_price) {
		this.products_price = products_price;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}
