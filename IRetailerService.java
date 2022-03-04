package com.cg.retailstore.service;

import java.util.List;

import com.cg.retailstore.model.Retailer;

public interface IRetailerService {
	List<Retailer> getAllRetailers();

	Retailer saveRetailer(Retailer retailers);

	Retailer getRetailerById(long retailer_id);

	Retailer updateRetailer(Retailer retailer);
}
