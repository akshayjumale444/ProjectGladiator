package com.lti.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lti.entity.Flight;

@Repository
public interface AirlineOperationsDao {

	public List<Flight> searchFlightOperation(String source, String destination, String travelClass, int noOFTravelers);
}
