package com.otm.core.repo;



import org.springframework.data.repository.CrudRepository;

import com.otm.core.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
	//List<Customer> findByUserID(String userId);
	Customer findById(Long id);
	Customer findByUserId(String userId);
}