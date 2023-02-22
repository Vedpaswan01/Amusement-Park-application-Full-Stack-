package com.FunXtreme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FunXtreme.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

}
