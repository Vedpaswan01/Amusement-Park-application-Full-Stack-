package com.FunXtreme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FunXtreme.exception.CustomerException;
import com.FunXtreme.model.Customer;
import com.FunXtreme.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;


	@Override
	public Customer registerCustomer(Customer customer) {
		return customerRepo.save(customer); 
	}
	@Override
	public Customer updateCustomer(Integer cusID, Customer customer) throws CustomerException {
		Customer cus = customerRepo.findById(customer.getCustomerID()).orElseThrow(() -> new CustomerException("Invalid ID. Please enter a valid ID."));
		return customerRepo.save(cus);
	}
	@Override
	public String deleteCustomer(Integer customerID) throws CustomerException {
		Customer cus = customerRepo.findById(customerID).orElseThrow(() -> new CustomerException("Invalid ID. Please enter a valid ID."));
		customerRepo.delete(cus);
		return "Deletion done successfully.";
	}
	

}
