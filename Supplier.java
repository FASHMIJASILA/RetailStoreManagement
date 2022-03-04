
package com.cg.retailstore.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity

@Table(name = "supplier_table")
public class Supplier {

	@Id

	@GeneratedValue(strategy = GenerationType.AUTO)

	@Column
	private long supplier_id;

	@Column
	private String supplier_name;

	@Column
	private long supplier_phone;

	@Column
	private String supplier_email;

	@OneToOne
	@JoinColumn(foreignKey = @ForeignKey(name = "retailer_id"))

	private Retailer retailer;

	public long getSupplier_id() {
		return supplier_id;
	}

	public void setSupplier_id(long supplier_id) {
		this.supplier_id = supplier_id;
	}

	public String getSupplier_name() {
		return supplier_name;
	}

	public void setSupplier_name(String supplier_name) {
		this.supplier_name = supplier_name;
	}

	public long getSupplier_phone() {
		return supplier_phone;
	}

	public void setSupplier_phone(long supplier_phone) {
		this.supplier_phone = supplier_phone;
	}

	public String getSupplier_email() {
		return supplier_email;
	}

	public void setSupplier_email(String supplier_email) {
		this.supplier_email = supplier_email;
	}

	public Retailer getRetailer() {
		return retailer;
	}

	public void setRetailer(Retailer retailer) {
		this.retailer = retailer;
	}

}
