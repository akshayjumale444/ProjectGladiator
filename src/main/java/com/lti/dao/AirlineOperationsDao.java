package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.dto.TicketDto;
import com.lti.entity.Booking;
import com.lti.entity.Flight;
import com.lti.entity.Passenger;
import com.lti.entity.User;

@Repository
public interface AirlineOperationsDao {

	public List<Flight> searchFlightOperation(String source, String destination, String travelClass, int noOFTravelers);
	public User fetchUserById(int UserId);
	public void addPassenger(Passenger passenger);
	public List<Passenger> fetchPassenger(int bookingId);
	public Flight fetchedFlight(Booking booking);
	public TicketDto fetchTicket(int bookingId);
	//public void fetchTicket(Booking booking);
}
