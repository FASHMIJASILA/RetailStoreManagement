package com.cg.retailstore.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cg.retailstore.model.Customer;
import com.cg.retailstore.model.Retailer;
import com.cg.retailstore.service.ICustomerService;
import com.cg.retailstore.service.IProductService;

@Controller
public class CustomerController {

	private ICustomerService customerService;

	public CustomerController(ICustomerService customerService) {
		super();
		this.customerService = customerService;
	}

	// display list of customer and return mode and view
	@GetMapping("/customer")
	public String listCustomer(Model model) {
		model.addAttribute("listCustomers", customerService.getAllCustomers());
		return "customer";// returns to customer html
	}

	@GetMapping("/customer/new")
	public String addCustomer(Model model) {
		Customer customer = new Customer();
		System.out.println("customer controller");
		model.addAttribute("customer", customer);
		return "add-customer";
	}

	@PostMapping("/customer")
	public String saveCustomer(@ModelAttribute("customer") Customer customer) {
		customerService.saveCustomer(customer);
		return "redirect:/customer";
	}

	@GetMapping("/customer/edit/{id}")
	public String editCustomer(@PathVariable("id") String customer_id, Model model) {// when it diferentf
		System.out.println("insid edit  " + customer_id);

		Long customer_id1 = Long.parseLong(customer_id);
		System.out.println("inside edit controllersssss ");
		model.addAttribute("customer", customerService.getCustomerById(customer_id1));
		return "edit-customer";
	}

	@PostMapping("/customer/{id}")
	public String updateCustomer(@PathVariable("id") String customer_id, @ModelAttribute("customer") Customer customer,
			Model model) {
		System.out.println("update customer controller ");
		// get retailer from database by id
		Long customer_id1 = Long.parseLong(customer_id);
		System.out.println("update customer controller1 ");
		Customer existingCustomer = customerService.getCustomerById(customer_id1);
		existingCustomer.setCustomer_id(customer_id1);
		existingCustomer.setCustomer_name(customer.getCustomer_name());
		existingCustomer.setCustomer_phone(customer.getCustomer_phone());
		existingCustomer.setCustomer_email(customer.getCustomer_email());

		// ave update retailer object

		customerService.updateCustomer(existingCustomer);
		model.addAttribute("listCustomers", customerService.getAllCustomers());
		return "customer";

	}

	@GetMapping("/deleteCustomer/{id}")
	public String deleteCustomer(@PathVariable("id") long customer_id, Model model) {

		customerService.deleteCustomerById(customer_id);
		model.addAttribute("listCustomers", customerService.getAllCustomers());
		return "customer";
	}

	// logout//
	@RequestMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		return "redirect:/sign-in";
	}

}
