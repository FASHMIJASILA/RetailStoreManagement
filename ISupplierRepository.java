package com.cg.retailstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.retailstore.model.Supplier;

public interface ISupplierRepository extends JpaRepository<Supplier,Long>{

	
	
}
