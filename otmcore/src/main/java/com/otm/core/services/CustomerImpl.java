package com.otm.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otm.core.model.Customer;
import com.otm.core.repo.CustomerRepository;
import com.otm.core.util.TokenProvider;
import com.otm.core.util.ValidationEnum;


@Service
public class CustomerImpl implements CustomerService {

	@Autowired
	CustomerRepository repository;
	@Autowired
	MailService mailService;


@Override
public List<Customer> getAllCustomer() {
	List<Customer> list = new ArrayList<>();
	Iterable<Customer> customers = repository.findAll();

	customers.forEach(list::add);
	return list;
}


@Override
public Customer save(Customer customer) {
	repository.save(customer);
	
	mailService.sendWelcomeMail(customer);
	return customer;
	
}

@Override
public boolean updatePassword(String password,Long id) {
	// 
	try{
	Customer customer=repository.findById(id);
	customer.setPassword(password);
	repository.save(customer);
	return true;
	}catch(Exception e) {
		return false;
	}
}


@Override
public boolean delete(long id) {
	// TODO Auto-generated method stub
	try{
		repository.delete(id);
		return true;
	}catch(Exception e) {
		return false;
	}
	
}
@Override
public Customer findByCustomerUserId(String userId) {
		return repository.findByUserId(userId);
}

@Override
public Customer findByCustomerId(Long id) {
	
	return repository.findById(id);
}
}
