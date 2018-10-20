package com.otm.core.repo;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Service;

import com.otm.core.model.Customer;
import com.otm.core.model.SearchCustomer;

@Service
public class CutomerRepo implements ICustomerDAO {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Customer> getAllCustomer(List<SearchCustomer> params) {
		// TODO Auto-generated method stub
		CriteriaQuery<Customer> query = CreateQuery(params);
		List<Customer> result = entityManager.createQuery(query).getResultList();
		return result;

	}

	@Override
	public List<Customer> getSearchCustomer(Customer cutomer) {
		// TODO Auto-generated method stub
		return null;
	}

	private CriteriaQuery<Customer> CreateQuery(List<SearchCustomer> params){
		CriteriaBuilder builder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Customer> query = builder.createQuery(Customer.class);
        Root r = query.from(Customer.class);
 
        Predicate predicate = builder.conjunction();
 
        
        for (SearchCustomer param : params) {
            if (param.getOperation().equalsIgnoreCase(">")) {
                predicate = builder.and(predicate, 
                  builder.greaterThanOrEqualTo(r.get(param.getKey()), 
                  param.getValue().toString()));
            } else if (param.getOperation().equalsIgnoreCase("<")) {
                predicate = builder.and(predicate, 
                  builder.lessThanOrEqualTo(r.get(param.getKey()), 
                  param.getValue().toString()));
            } else if (param.getOperation().equalsIgnoreCase(":")) {
                if (r.get(param.getKey()).getJavaType() == String.class) {
                    predicate = builder.and(predicate, 
                      builder.like(r.get(param.getKey()), 
                      "%" + param.getValue() + "%"));
                } else {
                    predicate = builder.and(predicate, 
                      builder.equal(r.get(param.getKey()), param.getValue()));
                }
            }
        }
        System.out.println(" predicate: "+predicate.toString());
        query.where(predicate);
        
        return query;
	}
	}

