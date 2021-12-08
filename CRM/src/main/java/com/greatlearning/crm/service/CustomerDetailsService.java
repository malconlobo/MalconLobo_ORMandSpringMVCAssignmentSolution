package com.greatlearning.crm.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.greatlearning.crm.entities.CustomerDetails;

@Service
public interface CustomerDetailsService {
	
	List<CustomerDetails> findAll();
	
	CustomerDetails findById(int id);
	
	void save(CustomerDetails CustomerDetails);
	
	void deleteById(int id);

}
