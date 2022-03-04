package com.cg.retailstore.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.retailstore.model.Customer;
import com.cg.retailstore.model.Products;
import com.cg.retailstore.model.Supplier;
import com.cg.retailstore.repository.ICustomerRepository;
import com.cg.retailstore.repository.IProductRepository;

@Service
public class CustomerServiceImpl implements ICustomerService {

	@Autowired
	private ICustomerRepository customerRepository;

	public CustomerServiceImpl(ICustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public List<Customer> getAllCustomers() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public Customer getCustomerById(long customer_id) {
		// TODO Auto-generated method stub
		return customerRepository.findById(customer_id).get();
	}

	@Override
	public Customer updateCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public void deleteCustomerById(long customer_id) {
		// TODO Auto-generated method stub
		customerRepository.deleteById(customer_id);
	}

}
