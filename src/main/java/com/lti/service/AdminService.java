package com.lti.service;

import java.util.List;

import com.lti.entity.Flight;

public interface AdminService {
	
	public int addFlight(Flight flight);
	public List<Flight> displayFlight();
	public Flight fetchFlightById(int flightId);
	

}
