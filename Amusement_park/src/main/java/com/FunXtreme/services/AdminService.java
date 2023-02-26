package com.FunXtreme.services;

import java.time.LocalDate;
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
	
	public Admin insertAdmin(Admin admin) throws LoginException;
	
	public Admin updateAdmin(Admin admin) throws AdminException, LoginException;

	public Admin deleteAdmin(Integer adminId) throws AdminException, LoginException;

	public List<Activity> getAllActivitiesByCustomerID(Integer cutomerId) throws ActivityException,CustomerException, LoginException;

	public List<Activity> getAllActivities() throws ActivityException, LoginException;

	public List<Activity> getActivitiesDatewise(LocalDate date) throws ActivityException, LoginException;

	public List<Activity> getActivitiesForDays(Integer customerId, LocalDate fromdate, LocalDate toDate)
			throws ActivityException, LoginException;
	public List<Customer> getAllCustomer() throws CustomerException, LoginException;

	public List<Activity> getAllActivity() throws ActivityException, LoginException;
	
	public Customer deleteCustomer(Integer customerID) throws CustomerException,LoginException ;
	
	public Admin getAdminByEmail(String email) throws AdminException;

}
