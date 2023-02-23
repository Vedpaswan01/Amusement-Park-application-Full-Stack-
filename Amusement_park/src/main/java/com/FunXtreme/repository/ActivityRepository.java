package com.FunXtreme.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FunXtreme.model.Activity;

public interface ActivityRepository extends JpaRepository<Activity, Integer> {

	public List<Activity> findByCharge(Float charge);
}
