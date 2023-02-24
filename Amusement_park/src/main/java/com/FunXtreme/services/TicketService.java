package com.FunXtreme.services;

import java.util.List;

import com.FunXtreme.exception.ActivityException;
import com.FunXtreme.exception.CustomerException;
import com.FunXtreme.exception.LoginException;
import com.FunXtreme.exception.TicketException;
import com.FunXtreme.model.Ticket;
import com.FunXtreme.model.TripBookingDTO;

public interface TicketService {

	public Ticket ticketBooking(Ticket ticket, Integer activity_id) throws ActivityException ,TicketException,LoginException;

	public Ticket updateTicketBooking(Integer ticket_id,Integer activity_id) throws ActivityException,TicketException,LoginException;

	public Ticket deleteTicketBooking(Integer ticketId) throws TicketException,LoginException;

	public List<Ticket> viewAllTicketCustomer() throws TicketException,CustomerException,LoginException;

	public TripBookingDTO calculateBill() throws TicketException, LoginException, CustomerException;

}
