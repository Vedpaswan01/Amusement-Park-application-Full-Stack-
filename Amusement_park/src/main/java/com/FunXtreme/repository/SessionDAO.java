package com.FunXtreme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FunXtreme.model.CurrentUserSession;

public interface SessionDAO extends JpaRepository<CurrentUserSession, Integer>{
	
	public CurrentUserSession findByUuid(String uuid);
	
}
