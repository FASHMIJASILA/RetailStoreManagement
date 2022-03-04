package com.cg.retailstore.service;

import java.util.List;

import com.cg.retailstore.model.Customer;
import com.cg.retailstore.model.Products;
import com.cg.retailstore.model.Supplier;

public interface ICustomerService {

	List<Customer> getAllCustomers();

	Customer saveCustomer(Customer customer);

	Customer getCustomerById(long customer_id);

	Customer updateCustomer(Customer customer);

	void deleteCustomerById(long customer_id);
}
