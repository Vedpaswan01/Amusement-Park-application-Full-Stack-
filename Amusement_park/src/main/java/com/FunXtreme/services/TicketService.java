package com.FunXtreme.services;

import java.util.List;

import com.FunXtreme.exception.TicketException;
import com.FunXtreme.model.Ticket;

public interface TicketService {

	public Ticket ticketBooking(Ticket ticket) throws TicketException;
	

	public Ticket updateTicketBooking(Integer ticket_id)
			throws TicketException;

	public Ticket deleteTicketBooking(Integer ticketId) throws TicketException;

	public List<Ticket> viewAllTicketCustomer()
			throws TicketException;

}
