package com.FunXtreme.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.FunXtreme.exception.AdminException;
import com.FunXtreme.model.Admin;
import com.FunXtreme.services.AdminService;

@RestController
public class AdminController {

	@Autowired
	private AdminService adminService;

	@PostMapping("/registerAdmin")
	public ResponseEntity<Admin> createAdmin(@Valid @RequestBody Admin admin) throws AdminException {
		Admin registeredAdmin = adminService.insertAdmin(admin);
		return new ResponseEntity<Admin>(registeredAdmin, HttpStatus.CREATED);

	}
}
