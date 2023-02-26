package com.FunXtreme.services;

import java.util.List;
import java.util.Optional;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FunXtreme.controller.AdminController;
import com.FunXtreme.controller.CustomerController;
import com.FunXtreme.exception.ActivityException;
import com.FunXtreme.exception.AdminException;
import com.FunXtreme.exception.CustomerException;
import com.FunXtreme.model.Activity;
import com.FunXtreme.model.Admin;
import com.FunXtreme.model.CurrentUserSession;
import com.FunXtreme.model.Customer;
import com.FunXtreme.repository.ActivityRepository;
import com.FunXtreme.repository.CustomerRepository;
import com.FunXtreme.repository.SessionDAO;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private SessionDAO sessionDAO;
	
	@Autowired
	private ActivityRepository activityRepo;


	@Override
	public Customer registerCustomer(Customer customer) throws CustomerException {
		Customer cus = customerRepo.findByEmail(customer.getEmail());
		if(cus != null) {
			throw new CustomerException("Customer with this email has already been registered. Please use a different email ID.");
		}
		return customerRepo.save(customer); 
	}
	@Override
	public Customer updateCustomer(Customer customer) throws CustomerException {
		if(!CustomerController.isLoggedin) {
			throw new CustomerException("Please login first");
		}
		Optional<Customer> opt = customerRepo.findById(customer.getCustomerID());
		if (opt.isPresent()) {
			Customer updateCustomer = customerRepo.save(customer);
			return updateCustomer;
		} else {
			throw new CustomerException(" Customer Does Not Exist ! ");
		}
	}
	@Override
	public String deleteCustomer(Integer customerID) throws CustomerException {

		if(!CustomerController.isLoggedin) {
			throw new CustomerException("Please login first");
		}
		Optional<Customer> opt = customerRepo.findById(customerID);

		if (opt.isPresent()) {
			customerRepo.delete(opt.get());
			return "Deletion successful!";
		} else {

			throw new CustomerException("No customer found with the ID:" + customerID);
		}
		
	}
	@Override
	public List<Activity> getAllActivities() throws ActivityException {
		if(!CustomerController.isLoggedin) {
			throw new ActivityException("Please login first");
		}
		List<Activity> list = activityRepo.findAll();
		if(list == null) {
			throw new ActivityException("No activities found.");
		}
		return list;
	}
	

}
