package com.otm.core.repo;

import java.util.List;

import com.otm.core.model.Customer;
import com.otm.core.model.SearchCustomer;

public interface ICustomerDAO {

	public List<Customer> getAllCustomer(List<SearchCustomer> params);
	public List<Customer> getSearchCustomer(Customer cutomer);
	
}
