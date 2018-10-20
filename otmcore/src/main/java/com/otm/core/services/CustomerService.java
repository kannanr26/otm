package com.otm.core.services;

import java.util.List;

import com.otm.core.model.Customer;


public interface CustomerService {

	List<Customer> getAllCustomer(Customer customer);

	Customer save(Customer customer);
	void edit(Customer customer);
	Customer findByCustomerUserId(String userId);
	boolean updatePassword(String password,Long id);
	Customer findByCustomerId(Long id);
	boolean delete(long id);

}
