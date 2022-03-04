package com.cg.retailstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.retailstore.model.Customer;
import com.cg.retailstore.model.Products;

public interface IProductRepository extends JpaRepository<Products,Long>{

	

}
