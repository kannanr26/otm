package com.otm.core.repo;



import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.otm.core.model.Customer;


public interface CustomerRepository extends CrudRepository<Customer, Long> {
	//List<Customer> findByUserID(String userId);
	Customer findById(Long id);
	Customer findByUserId(String userId);
	List<Customer> findByReligion(String religion);
}