package com.FunXtreme.services;

import com.FunXtreme.exception.CustomerException;
import com.FunXtreme.model.Customer;

public interface CustomerService {
	public Customer registerCustomer(Customer customer);
	public Customer updateCustomer(Integer cusID, Customer customer) throws CustomerException;
	public String deleteCustomer(Integer customerID) throws CustomerException;
}
