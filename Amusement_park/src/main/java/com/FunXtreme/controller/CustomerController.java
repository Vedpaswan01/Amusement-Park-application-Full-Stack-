package com.FunXtreme.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.FunXtreme.exception.CustomerException;
import com.FunXtreme.model.Customer;
import com.FunXtreme.services.ActivityService;
import com.FunXtreme.services.CustomerService;

//import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/customer")
public class CustomerController {

	@Autowired
	private CustomerService customerService;


	
	
	@PostMapping("/registerCustomer")
	public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer) {
		return new ResponseEntity<>(customerService.registerCustomer(customer), HttpStatus.CREATED);
	}
	
	@PutMapping("/updateCustomerById/{id}")
	public ResponseEntity<Customer> updateCustomer(@Valid @PathVariable("id") Integer id, @RequestBody Customer customer) throws CustomerException {
		return new ResponseEntity<>(customerService.updateCustomer(id, customer), HttpStatus.OK);
	}
	
	@DeleteMapping("/deleteCustomerById/{id}")
	public ResponseEntity<String> deleteCustomer(@Valid @PathVariable("id") Integer id) throws CustomerException {
		return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
	}


}
