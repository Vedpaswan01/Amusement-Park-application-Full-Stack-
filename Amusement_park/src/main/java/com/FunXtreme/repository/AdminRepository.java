package com.FunXtreme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FunXtreme.model.Admin;

public interface AdminRepository extends JpaRepository<Admin, Integer> {
	
	public Admin findByEmail(String email);

}
