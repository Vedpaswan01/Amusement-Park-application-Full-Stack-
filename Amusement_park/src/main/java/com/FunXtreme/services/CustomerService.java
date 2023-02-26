package com.FunXtreme.services;

import java.util.List;

import com.FunXtreme.exception.ActivityException;
import com.FunXtreme.exception.CustomerException;
import com.FunXtreme.exception.LoginException;
import com.FunXtreme.model.Activity;
import com.FunXtreme.model.Customer;

public interface CustomerService {

	public Customer registerCustomer(Customer customer) throws CustomerException;
	public Customer updateCustomer(Customer customer) throws CustomerException;
	public String deleteCustomer(Integer customerID) throws CustomerException;
	public List<Activity> getAllActivities() throws ActivityException;
	

}
