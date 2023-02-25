package com.FunXtreme.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.security.auth.login.LoginException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.FunXtreme.exception.ActivityException;
import com.FunXtreme.exception.AdminException;
import com.FunXtreme.exception.CustomerException;
import com.FunXtreme.model.Activity;
import com.FunXtreme.model.Admin;
import com.FunXtreme.model.Customer;
import com.FunXtreme.services.AdminService;
import com.FunXtreme.services.CustomerService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@Autowired
	private CustomerService customerService;

	public static boolean isLoggedin = false;

	@PostMapping("/registerAdmin")
	public ResponseEntity<Admin> createAdmin(@RequestBody Admin admin) throws AdminException, LoginException {

		Admin c = adminService.insertAdmin(admin);

		return new ResponseEntity<Admin>(c, HttpStatus.CREATED);

	}

	@PutMapping("/updateadmins")
	public ResponseEntity<Admin> updateAdminHandler(@RequestBody Admin admin) throws AdminException, LoginException {

		Admin ad = adminService.updateAdmin(admin);
		return new ResponseEntity<Admin>(ad, HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/deleteadmin/{id}")
	public ResponseEntity<Admin> deleteAdminHandler(@PathVariable("id") Integer id) throws AdminException, LoginException {
		Admin ad = adminService.deleteAdmin(id);
		return new ResponseEntity<Admin>(ad, HttpStatus.OK);
	}

	@GetMapping("/getAllactivitybycustomerid/{id}")
	public ResponseEntity<List<Activity>> getAllActivityByCustomerIdHandler(@PathVariable("id") Integer id)
			throws ActivityException, CustomerException, LoginException {

		List<Activity> activities = adminService.getAllActivitiesByCustomerID(id);
		return new ResponseEntity<List<Activity>>(activities, HttpStatus.OK);
	}

	@GetMapping("/getallactivity")
	public ResponseEntity<List<Activity>> getAllActivityHandler() throws ActivityException, LoginException {

		List<Activity> activities = adminService.getAllActivities();
		return new ResponseEntity<List<Activity>>(activities, HttpStatus.OK);
	}

	@GetMapping("/getactivitybydate/{date}")
	public ResponseEntity<List<Activity>> getAllActivityByDateHandler(@PathVariable("date") String date)
			throws ActivityException, LoginException {

		String dateString = date;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
		LocalDateTime parsedDate = LocalDateTime.parse(dateString, formatter);

		List<Activity> activities = adminService.getActivitiesDatewise(parsedDate);

		return new ResponseEntity<List<Activity>>(activities, HttpStatus.OK);
	}

	@GetMapping("/getActivitybyDateAndCustomerid/{cid}/{from_date}/{to_date}")
	public ResponseEntity<List<Activity>> getAllActivityByDateandcustomeridHandler(
			@PathVariable("cid") Integer customerId, @PathVariable("from_date") String from_date,
			@PathVariable("to_date") String to_date) throws ActivityException, LoginException {

		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
		LocalDateTime fromDate = LocalDateTime.parse(to_date, formatter);
		LocalDateTime toDate = LocalDateTime.parse(to_date, formatter);

		List<Activity> activities = adminService.getActivitiesForDays(customerId, fromDate, toDate);

		return new ResponseEntity<List<Activity>>(activities, HttpStatus.OK);
	}

	@GetMapping("/allCustomer")
	public ResponseEntity<Object> getAllCustomer() throws CustomerException, LoginException {

		List<Customer> customerList = adminService.getAllCustomer();
		return new ResponseEntity<>(customerList, HttpStatus.OK);

	}

	@DeleteMapping("/deleteCustomer/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable("customerId") Integer customerId )
			throws CustomerException, LoginException {

		return new ResponseEntity(adminService.deleteCustomer(customerId), HttpStatus.OK);

	}
}
