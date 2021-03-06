package com.otm.core.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.otm.core.model.Customer;
import com.otm.core.repo.CustomerRepository;
import com.otm.core.util.TokenProvider;


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
	String token = TokenProvider.getToken(customer.getCustomerDetail().getEMail(),customer.getCustomerDetail().getLastName());
	customer.setToken(token);
	repository.save(customer);
	
	mailService.sendMail(customer);
	return customer;
	
}

@Override
public void delete(long id) {
	// TODO Auto-generated method stub
	repository.delete(id);
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
