package com.FunXtreme.services;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FunXtreme.controller.AdminController;
import com.FunXtreme.exception.ActivityException;
import com.FunXtreme.exception.AdminException;
import com.FunXtreme.exception.CustomerException;
import com.FunXtreme.model.Activity;
import com.FunXtreme.model.Admin;
import com.FunXtreme.model.Customer;
import com.FunXtreme.model.Ticket;
import com.FunXtreme.repository.ActivityRepository;
import com.FunXtreme.repository.AdminRepository;
import com.FunXtreme.repository.CustomerRepository;
import com.FunXtreme.repository.TicketRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepo;

	@Autowired
	CustomerRepository customerRepo;

	@Autowired
	ActivityRepository activityRepository;

	@Autowired
	TicketRepository ticketRepository;

	@Override
	public Admin insertAdmin(Admin admin) throws LoginException {
		return adminRepo.save(admin);
	}

	@Override
	public Admin updateAdmin(Admin admin) throws AdminException, LoginException {
		if(!AdminController.isLoggedin) {
			throw new LoginException("Please login first");
		}
		Optional<Admin> opt = adminRepo.findById(admin.getAdminID());
		if (opt.isPresent()) {
			Admin updateAdmin = adminRepo.save(admin);
			return updateAdmin;
		} else {
			throw new AdminException(" Admin Does Not Exist ! ");
		}
	}

	@Override
	public Admin deleteAdmin(Integer adminId) throws AdminException, LoginException {
		
		if(!AdminController.isLoggedin) {
			throw new LoginException("Please login first");
		}
		Optional<Admin> opt = adminRepo.findById(adminId);

		if (opt.isPresent()) {
			adminRepo.delete(opt.get());
			return opt.get();
		} else {

			throw new AdminException("Admin  not found with this id:" + adminId);
		}
	}

	@Override
	public List<Activity> getAllActivitiesByCustomerID(Integer cutomerId) throws ActivityException, CustomerException, LoginException {
		if(!AdminController.isLoggedin) {
			throw new LoginException("Please login first");
		}
		Customer customer = customerRepo.findById(cutomerId)
				.orElseThrow(() -> new CustomerException("Invalid ID. Please enter a valid ID."));

		List<Ticket> TicketList = customer.getTickets();
		List<Activity> ActivityList = new ArrayList<>();

		TicketList.forEach(t -> ActivityList.add(t.getActivity()));
		if (ActivityList.size() == 0) {
			throw new ActivityException("No Activity found");
		} else {
			return ActivityList;
		}
	}

	@Override
	public List<Activity> getAllActivities() throws ActivityException, LoginException {
		if(!AdminController.isLoggedin) {
			throw new LoginException("Please login first");
		}
		List<Activity> ActivityList = activityRepository.findAll();

		if (ActivityList.size() == 0) {

			throw new ActivityException("No Activity found");

		} else {
			return ActivityList;
		}

	}

	@Override
	public List<Activity> getActivitiesDatewise(LocalDateTime date) throws ActivityException, LoginException {
		if(!AdminController.isLoggedin) {
			throw new LoginException("Please login first");
		}

		List<Ticket> ticketList = ticketRepository.getTicketByDate(date);

		List<Activity> activityList = ticketList.stream().map(Ticket::getActivity).collect(Collectors.toList());

		if (activityList.isEmpty()) {
			throw new ActivityException("No Activity found");
		} else {
			return activityList;
		}
	}

	@Override
	public List<Activity> getActivitiesForDays(Integer customerId, LocalDateTime fromdate, LocalDateTime toDate)
			throws ActivityException, LoginException {
		if(!AdminController.isLoggedin) {
			throw new LoginException("Please login first");
		}
		Optional<Customer> opt = customerRepo.findById(customerId);

		List<Activity> listActivity = opt.map(customer -> {

			List<Ticket> listTicket1 = ticketRepository.getTicketBetweenDate(fromdate, toDate);
			return listTicket1.stream().map(Ticket::getActivity).collect(Collectors.toList());

		}).orElseThrow(() -> new ActivityException("No customer found"));

		if (listActivity.isEmpty()) {
			throw new ActivityException("No Activity found");
		}
		return listActivity;

	}

	@Override
	public List<Customer> getAllCustomer() throws CustomerException, LoginException {
		if(!AdminController.isLoggedin) {
			throw new LoginException("Please login first");
		}
		List<Customer> customer = Optional.ofNullable(customerRepo.findAll())
				.orElseThrow(() -> new CustomerException("Customer not exist"));
		return customer;

	}

	@Override
	public List<Activity> getAllActivity() throws ActivityException, LoginException {
		if(!AdminController.isLoggedin) {
			throw new LoginException("Please login first");
		}
		List<Activity> act = Optional.ofNullable(activityRepository.findAll())
				  .orElseThrow(() -> new ActivityException("No activity In database"));
				return act;

	}

	@Override
	public Customer deleteCustomer(Integer customerID) throws CustomerException,LoginException {
		// TODO Auto-generated method stub

		if(!AdminController.isLoggedin) {
			throw new LoginException("Please login first");
		}
		Optional<Customer> opt = customerRepo.findById(customerID);

		if (opt.isPresent()) {
			
			customerRepo.delete(opt.get());
			
			return opt.get();
		} else {

			throw new CustomerException("Admin  not found with this id:" + customerID);
		}
	}

}
