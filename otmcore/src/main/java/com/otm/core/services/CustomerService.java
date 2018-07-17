package com.otm.core.services;

import java.util.List;

import com.otm.core.model.Customer;


public interface CustomerService {

	List<Customer> getAllCustomer();

	Customer save(Customer customer);
	Customer findByCustomerUserId(String userId);
	Customer findByCustomerId(Long id);
	void delete(long id);

}
