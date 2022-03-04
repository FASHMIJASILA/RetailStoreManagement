package com.cg.retailstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.retailstore.model.Order;

public interface IOrderRepository extends JpaRepository<Order,Long> {

}
