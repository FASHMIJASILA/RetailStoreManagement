package com.cg.retailstore.model;

import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "cart_table")
public class Cart {
	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column
	private long cart_id;

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
	@JoinColumn(name = "user_id")
	private UserDetails userDetails;

	public UserDetails getUserDetails() {
		return userDetails;
	}

	public void setUserDetails(UserDetails userDetails) {
		this.userDetails = userDetails;
	}

	public long getCart_id() {
		return cart_id;
	}

	public void setCart_id(long cart_id) {
		this.cart_id = cart_id;
	}

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

}
