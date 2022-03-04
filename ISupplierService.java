package com.cg.retailstore.service;

import java.util.List;

import com.cg.retailstore.model.Retailer;
import com.cg.retailstore.model.Supplier;

public interface ISupplierService {

	List<Supplier> getAllSuppliers();

	Supplier saveSupplier(Supplier suppliers);

	Supplier getSupplierById(long supplier_id);

	Supplier updateSupplier(Supplier supplier);

	void deleteSupplierById(long supplier_id);
}
