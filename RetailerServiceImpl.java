package com.cg.retailstore.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.cg.retailstore.model.Retailer;
import com.cg.retailstore.repository.IRetailerRepository;

@Service
public class RetailerServiceImpl implements IRetailerService {

	private IRetailerRepository retailerRepository;

	public RetailerServiceImpl(IRetailerRepository retailerRepository) {
		super();
		this.retailerRepository = retailerRepository;
	}

	@Override
	public List<Retailer> getAllRetailers() {
		// TODO Auto-generated method stub
		return retailerRepository.findAll();

	}

	@Override
	public Retailer saveRetailer(Retailer retailers) {
		// TODO Auto-generated method stub
		return retailerRepository.save(retailers);
	}

	@Override
	public Retailer getRetailerById(long retailer_id) {
		// TODO Auto-generated method stub
		return retailerRepository.findById(retailer_id).get();
	}

	@Override
	public Retailer updateRetailer(Retailer retailer) {

		return retailerRepository.save(retailer);
	}

}
