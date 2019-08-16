package com.lti.service;

import java.util.List;

import com.lti.entity.Booking;
import com.lti.entity.Flight;
import com.lti.entity.Passenger;
import com.lti.entity.User;


public interface AirlineService {

	public List<Flight> searchFlights(String source,String destination,String travelClass,int noOFTravelers);
	public int addUser(User user);
	public User fetchUserById(int UserId);
	public int addBooking(Booking booking);
	public int addPassenger(Passenger passenger);
	
}
