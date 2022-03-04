package com.cg.retailstore.service;

import java.util.List;

import com.cg.retailstore.exception.ProductNotFoundException;
import com.cg.retailstore.model.Customer;
import com.cg.retailstore.model.Products;

public interface IProductService {

	List<Products> getAllProducts();

	Products saveProducts(Products products);

	Products getProductsById(long products_id) throws ProductNotFoundException;

	Products updateProducts(Products products);

	void deleteProductsById(long products_id);
}
