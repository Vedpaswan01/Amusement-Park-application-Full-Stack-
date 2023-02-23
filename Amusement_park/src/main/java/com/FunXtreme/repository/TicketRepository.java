package com.FunXtreme.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.FunXtreme.model.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {
	
	@Query("select t from Ticket t where t.dateTime=?1")
	public List<Ticket> getTicketByDate(LocalDateTime date);

	@Query("select t from Ticket t where t.dateTime>=?1 and t.dateTime<=?2")
	public List<Ticket> getTicketBetweenDate(LocalDateTime fromDate, LocalDateTime toDate);

	@Query("select c.tickets from Customer c where c.customerID = ?1")
	public List<Ticket> getAllTicketsByCustomerId(Integer customer_id);

}
