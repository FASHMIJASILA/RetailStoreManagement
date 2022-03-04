package com.cg.retailstore.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.retailstore.model.Cart;
import com.cg.retailstore.model.Products;
import com.cg.retailstore.model.UserDetails;
import com.cg.retailstore.repository.ICartRepository;
import com.cg.retailstore.repository.IProductRepository;
import com.cg.retailstore.repository.IUserDetailsRepository;

@Service
public class CartServiceImpl implements ICartService {

	@Autowired
	private ICartRepository cartRepository;

	@Autowired
	private IProductRepository productRepository;

	@Autowired
	private IUserDetailsRepository userDetailsRepository;

	public CartServiceImpl(ICartRepository cartRepository, IProductRepository productRepository,
			IUserDetailsRepository userDetailsRepository) {
		super();
		this.cartRepository = cartRepository;
		this.productRepository = productRepository;// invoking in one service using another controller
		this.userDetailsRepository = userDetailsRepository;

	}

	@Override
	public void addProductToCart(Cart cart) {
		// TODO Auto-generated method stub
		cartRepository.save(cart);

	}

	public Cart addProductToCart(long products_id, long user_id) {

		Optional<Products> products = productRepository.findById(products_id);
		Products product = products.get();
		Cart cart = new Cart();
		cart.setProducts_id(product.getProducts_id());
		cart.setProducts_name(product.getProducts_name());
		cart.setProducts_price(product.getProducts_price());
		cart.setProducts_quantity(product.getProducts_quantity());
		cart.setProducts_type(product.getProducts_type());
		UserDetails userDetails = userDetailsRepository.findById(user_id).get();// storing the object
		cart.setUserDetails(userDetails);

		addProductToCart(cart);

		return cart;

	}

	@Override
	public List<Cart> findAll() {
		// TODO Auto-generated method stub
		return cartRepository.findAll();

	}

}
