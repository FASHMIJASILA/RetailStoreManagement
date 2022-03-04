package com.cg.retailstore.repository;

import com.cg.retailstore.model.UserDetails;

public interface IUserDetailsRepositoryCustom {
	public UserDetails findUser(String username, String password);

}
