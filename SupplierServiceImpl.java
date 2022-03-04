package com.cg.retailstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.retailstore.model.Retailer;
import com.cg.retailstore.model.Supplier;
import com.cg.retailstore.repository.IRetailerRepository;
import com.cg.retailstore.repository.ISupplierRepository;

@Service
public class SupplierServiceImpl implements ISupplierService {

	private ISupplierRepository supplierRepository;

	public SupplierServiceImpl(ISupplierRepository supplierRepository) {
		super();
		this.supplierRepository = supplierRepository;
	}

	@Override
	public List<Supplier> getAllSuppliers() {
		// TODO Auto-generated method stub
		return supplierRepository.findAll();
	}

	@Override
	public Supplier saveSupplier(Supplier suppliers) {
		// TODO Auto-generated method stub
		return supplierRepository.save(suppliers);
	}

	@Override
	public Supplier getSupplierById(long supplier_id) {
		// TODO Auto-generated method stub
		return supplierRepository.findById(supplier_id).get();
	}

	@Override
	public Supplier updateSupplier(Supplier supplier) {
		// TODO Auto-generated method stub
		return supplierRepository.save(supplier);

	}

	@Override
	public void deleteSupplierById(long supplier_id) {
		// TODO Auto-generated method stub
		supplierRepository.deleteById(supplier_id);
	}

}
