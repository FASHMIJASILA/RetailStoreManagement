package com.cg.retailstore.controller;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.cg.retailstore.exception.ProductNotFoundException;
import com.cg.retailstore.model.Cart;
import com.cg.retailstore.model.Customer;
import com.cg.retailstore.model.Products;
import com.cg.retailstore.model.UserDetails;
import com.cg.retailstore.service.ICartService;
import com.cg.retailstore.service.ICustomerService;
import com.cg.retailstore.service.IOrderService;
import com.cg.retailstore.service.IProductService;

@Controller
public class ProductController {

	@Autowired
	private IProductService productService;

	@Autowired
	private ICartService cartService;

	@Autowired
	private IOrderService orderService;

	public ProductController(IProductService productService, ICartService carService, IOrderService orderService) {
		super();
		this.productService = productService;
		this.cartService = carService;
		this.orderService = orderService;
	}

	@GetMapping("/products/{id}")
	public String listProducts(@PathVariable("id") Long id, Model model) {
		model.addAttribute("listproducts", productService.getAllProducts());
		model.addAttribute("user", id);
		return "customer-product-listPage";
		/* return "products"; */
	}

	@GetMapping("/retailerProductsList")
	public String retailerProductsList(Model model) {
		model.addAttribute("listproducts", productService.getAllProducts());
		return "retailer-product-listPage";
		/* return "products"; */
	}

	@GetMapping("/addProducts/new")
	public String addProducts(Model model) {
		Products products = new Products();
		System.out.println("products controller");
		model.addAttribute("products", products);
		return "add-products";
	}

	@PostMapping("/products")
	public String saveProducts(@ModelAttribute("product") Products products, Model model) {
		productService.saveProducts(products);
		model.addAttribute("listproducts", productService.getAllProducts());
		return "retailer-product-listPage";
	}

	@GetMapping("/products/edit/{id}")
	public String editProducts(@PathVariable("id") String products_id, Model model) {// when it diferentf
		System.out.println("insid edit  " + products_id);

		Long products_id1 = Long.parseLong(products_id);
		System.out.println("inside edit controllersssss ");
		try {
			model.addAttribute("products", productService.getProductsById(products_id1));
		} catch (ProductNotFoundException e) {
			// TODO Auto-generated catch block

			model.addAttribute("errormessage", e.getMessage());
			e.printStackTrace();
		}
		return "edit-products";
	}

	@PostMapping("/products/{id}")
	public String updateProducts(@PathVariable("id") String products_id, @ModelAttribute("products") Products products,
			Model model) throws ProductNotFoundException {
		System.out.println("update products controller ");
		// get retailer from database by id
		Long products_id1 = Long.parseLong(products_id);
		System.out.println("update products controller1 ");
		Products existingProducts = productService.getProductsById(products_id1);
		existingProducts.setProducts_id(products_id1);
		existingProducts.setProducts_name(products.getProducts_name());
		existingProducts.setProducts_type(products.getProducts_type());
		existingProducts.setProducts_quantity(products.getProducts_quantity());
		existingProducts.setProducts_price(products.getProducts_price());
		existingProducts.setCustomer(products.getCustomer());

		// ave update retailer object

		productService.updateProducts(existingProducts);
		model.addAttribute("listproducts", productService.getAllProducts());

		return "retailer-product-listPage";

	}

	// handling method to handle delete statement request

	@GetMapping("/deleteProduct/{id}")
	public String deleteProducts(@PathVariable("id") long products_id, Model model) {
		productService.deleteProductsById(products_id);
		model.addAttribute("listproducts", productService.getAllProducts());

		return "retailer-product-listPage";
	}

	@GetMapping("/productToCart/{id}")
	public String addProductToCart(@PathVariable("id") String prod_user_id, Model model) {
		System.out.println("**********" + prod_user_id);
		String[] values = prod_user_id.split(" ");
		long products_id = Long.parseLong(values[0]);
		long user_id = Long.parseLong(values[1]);
		cartService.addProductToCart(products_id, user_id);
		List<Cart> cartList = cartService.findAll();
		List<Cart> userCartList = new ArrayList<>();
		Iterator<Cart> iterator = cartList.iterator();
		long total = 0;
		UserDetails userDetails = null;
		System.out.println("++++++++++++");
		while (iterator.hasNext()) {
			Cart cart = iterator.next();
			System.out.println("&&&&&&&&&&&&&&&&&&&&");
			userDetails = cart.getUserDetails();
			System.out.println("userDetails" + userDetails);

			System.out.println("******************");
			if (userDetails.getId() == user_id) {
				total = total + cart.getProducts_price();
				System.out.println("total" + total);
				userCartList.add(cart);
			}
		}

		System.out.println("total" + total);
		model.addAttribute("totalAmount", total);
		model.addAttribute("cartList", userCartList);
		model.addAttribute("userDetails", userDetails);
		return "cart-product-listPage";

	}

	@GetMapping("/orderCheckOut/{id}")
	public String orderCheckOut(@PathVariable("id") long user_id) {
		orderService.addStore(user_id);
		return "order-success";
	}

}
