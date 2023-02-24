package com.FunXtreme.services;

import java.util.List;

import com.FunXtreme.exception.ActivityException;
import com.FunXtreme.exception.CustomerException;
import com.FunXtreme.model.Activity;
import com.FunXtreme.model.Customer;

public interface CustomerService {

	public Customer registerCustomer(Customer customer) throws CustomerException;
	public Customer updateCustomer(Customer customer, String key) throws CustomerException;
	public String deleteCustomer(Integer customerID, String key) throws CustomerException;
	public List<Activity> getAllActivities() throws ActivityException;
	

}
