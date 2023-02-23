package com.FunXtreme.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FunXtreme.exception.ActivityException;
import com.FunXtreme.exception.CustomerException;
import com.FunXtreme.model.Activity;
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
		Customer cus = customerRepo.findByEmail(customer.getAbstractUser().getEmail());
		if(cus != null) {
			throw new CustomerException("Customer with this email has already been registered. Please use a different email ID.");
		}
		return customerRepo.save(customer); 
	}
	@Override
	public Customer updateCustomer(Customer customer, String key) throws CustomerException {
		CurrentUserSession loggedInUser = sessionDAO.findByUuid(key);

		if (loggedInUser == null) {
			throw new CustomerException("Please provide a valid key to update a customer");
		}

		if (customer.getCustomerID() == loggedInUser.getUserId()) {
			return customerRepo.save(customer);
		} else
			throw new CustomerException("Invalid Customer Details, please login first");
	}
	@Override
	public String deleteCustomer(Integer customerID) throws CustomerException {
		CurrentUserSession userSession = sessionDAO.findById(customerID)
				.orElseThrow(() -> new CustomerException("Customer not fount with this Id"));
		Customer customer = customerRepo.findById(customerID)
				.orElseThrow(() -> new CustomerException("Cucstomer not found with thiss id"));
		if (userSession != null) {
			sessionDAO.delete(userSession);
			customerRepo.delete(customer);

			return "Deletion successful.";
		}
		throw new CustomerException("Deletion unsuccessful.");
	}
	@Override
	public List<Activity> getAllActivities() throws ActivityException {
		List<Activity> list = activityRepo.findAll();
		if(list == null) {
			throw new ActivityException("No activities found.");
		}
		return list;
	}
	

}
