package com.FunXtreme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FunXtreme.model.CurrentAdminSession;

public interface AdminSessionDAO extends JpaRepository<CurrentAdminSession, Integer>{
	public CurrentAdminSession findByUuid(String uuid);
}
