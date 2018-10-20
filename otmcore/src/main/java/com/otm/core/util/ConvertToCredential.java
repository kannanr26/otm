package com.otm.core.util;

import com.otm.core.model.Customer;
import com.otm.core.model.response.Credential;

public class ConvertToCredential {
	
	public static Credential convert(Customer customer) {
		Credential credential=new Credential();
		credential.setUserId(customer.getUserId());
		credential.setName(customer.getName());
		credential.setAdmin(customer.isAdmin());
		credential.setToken(customer.getToken());
		credential.setActive(customer.isActive());
		credential.setEnable(customer.isEnable());
		credential.setId(customer.getId());
				
		return credential;
		
	}

}
