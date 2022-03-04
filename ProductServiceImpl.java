package com.cg.retailstore.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.retailstore.exception.ProductNotFoundException;
import com.cg.retailstore.exception.UserNotFoundException;
import com.cg.retailstore.model.Customer;
import com.cg.retailstore.model.Products;
import com.cg.retailstore.repository.ICustomerRepository;
import com.cg.retailstore.repository.IProductRepository;

@Service
public class ProductServiceImpl implements IProductService {

	private IProductRepository productRepository;

	public ProductServiceImpl(IProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}

	@Override
	public List<Products> getAllProducts() {
		// TODO Auto-generated method stub
		return productRepository.findAll();
	}

	@Override
	public Products saveProducts(Products products) {
		// TODO Auto-generated method stub
		return productRepository.save(products);
	}

	@Override
	public Products getProductsById(long products_id) throws ProductNotFoundException{
		// TODO Auto-generated method stub
		
		return productRepository.findById(products_id).get();
		
		

	}

	@Override
	public Products updateProducts(Products products) {
		// TODO Auto-generated method stub
		return productRepository.save(products);
	}

	@Override
	public void deleteProductsById(long products_id) {
		// TODO Auto-generated method stub

		productRepository.deleteById(products_id);

	}

}
