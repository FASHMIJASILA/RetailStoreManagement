package com.cg.retailstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.retailstore.model.UserDetails;

@Repository

public interface IUserDetailsRepository extends JpaRepository<UserDetails, Long> {
	
	
	
	 
	 
	 
}
