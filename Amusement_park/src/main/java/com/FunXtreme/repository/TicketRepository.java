package com.FunXtreme.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.FunXtreme.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

}
