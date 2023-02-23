package com.FunXtreme.services;

import java.time.LocalDateTime;
import java.util.List;

import javax.security.auth.login.LoginException;

import com.FunXtreme.exception.ActivityException;
import com.FunXtreme.exception.AdminException;
import com.FunXtreme.exception.CustomerException;
import com.FunXtreme.model.Activity;
import com.FunXtreme.model.Admin;
import com.FunXtreme.model.Customer;

public interface AdminService {
	
	public Admin insertAdmin(Admin admin);
	
	public Admin updateAdmin(Admin admin) throws AdminException, LoginException;

	public Admin deleteAdmin(Integer adminId) throws AdminException;

	public List<Activity> getAllActivitiesByCustomerID(Integer cutomerId) throws ActivityException,CustomerException;

	public List<Activity> getAllActivities() throws ActivityException;

	public List<Activity> getActivitiesDatewise(LocalDateTime date) throws ActivityException;

	public List<Activity> getActivitiesForDays(Integer customerId, LocalDateTime fromdate, LocalDateTime toDate)
			throws ActivityException;
	public List<Customer> getAllCustomer() throws CustomerException;

	public List<Activity> getAllActivity() throws ActivityException;

}
