package com.FunXtreme.services;

import java.util.List;

import com.FunXtreme.exception.ActivityException;
import com.FunXtreme.exception.CustomerException;
import com.FunXtreme.exception.TicketException;
import com.FunXtreme.model.Ticket;

public interface TicketService {

	public Ticket ticketBooking(Ticket ticket, Integer activity_id) throws ActivityException ,TicketException;

	public Ticket updateTicketBooking(Integer ticket_id,Integer activity_id) throws ActivityException,TicketException;

	public Ticket deleteTicketBooking(Integer ticketId) throws TicketException;

	public List<Ticket> viewAllTicketCustomer() throws TicketException,CustomerException ;

}
