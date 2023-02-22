package com.FunXtreme.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.FunXtreme.model.Admin;
import com.FunXtreme.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminRepository adminRepo;

	@Override
	public Admin insertAdmin(Admin admin) {
		// TODO Auto-generated method stub
		System.out.println(admin);
		return adminRepo.save(admin);
	}



}
