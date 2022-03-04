package com.cg.retailstore.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.cg.retailstore.exception.UserNotFoundException;
import com.cg.retailstore.model.UserDetails;
import com.cg.retailstore.service.IUserDetailsService;

@Controller

public class IndexController {

	private final IUserDetailsService userDetailsService;

	public IndexController(IUserDetailsService userDetailsService) {
		super();
		this.userDetailsService = userDetailsService;
	}

	@GetMapping("/index")
	public String showIndexPage() {
		System.out.println("index controller");
		return "index";
	}

	@GetMapping("/sign-in") // it should be same as index.html
	public String showSgnInPage() {
		System.out.println("sign in page");
		return "sign-in";
	}

	@PostMapping("/sign-in")
	public String showHomePage(HttpServletRequest request, Model model) {
		String user = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println("Welcome to User Validation Controller");
		UserDetails userDetails = null;

		try {
			userDetails = userDetailsService.ValidateUserDetails(user, password);
		} catch (UserNotFoundException ex) {
			model.addAttribute("errormessage", ex.getMessage());
			return "sign-in";
		}

		model.addAttribute("userDetails", userDetails);
		if (userDetails.getRole().equals("Retailer")) {
			System.out.println(userDetails.getRole());
			return "retailer-home";// else if }
		}

		else if (userDetails.getRole().equals("Customer"))
			return "customer-home";

		else if (userDetails.getRole().equals("Supplier"))
			return "supplier-home";

		else
			return "sign-in";
	}

	@GetMapping("/sign-up") // it should be same as index.html
	public String showSgnUpPage(Model model) {
		System.out.println("sign up page");
		model.addAttribute("user", new UserDetails());
		return "sign-up";
	}

	@PostMapping("/add")
	public String addUserDetails(@Validated UserDetails userDetails, BindingResult result, Model model) {
		if (result.hasErrors()) {
			return "sign-up";
		}

		userDetailsService.addUserDetails(userDetails);// adding data
		List<UserDetails> list = userDetailsService.getAllUserDetails();
		System.out.println(" ++++++++" + list);
		model.addAttribute("userDetail", list);// all user
		return "user-details";
	}

	@GetMapping("/retailer-home")
	public String retailerPage() {
		return "retailer-home";
	}

	@GetMapping("/customer-home")
	public String customerPage() {
		return "customer-home";
	}

	@GetMapping("/supplier-home")

	public String supplierPage() {
		return "supplier-home";
	}

	// logout//
	@GetMapping("/logout")
	public String logoutDo(HttpServletRequest request, HttpServletResponse response) {

		return "redirect:/sign-in";
	}

}
