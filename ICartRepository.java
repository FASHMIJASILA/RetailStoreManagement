package com.cg.retailstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.retailstore.model.Cart;

public interface ICartRepository extends JpaRepository<Cart,Long>{
	

}
