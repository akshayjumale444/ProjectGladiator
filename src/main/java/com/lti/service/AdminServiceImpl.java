package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDao;
import com.lti.entity.Flight;
import com.lti.function.RequiredFunction;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	GenericDao dao;
	@Autowired
	RequiredFunction function;

	@Transactional
	public int addFlight(Flight flight) {
		
		flight.setDuration(function.calculateDuration(flight.getDeparture(), flight.getArrival()));
		Flight updateFlight=(Flight)dao.save(flight);
		return updateFlight.getFlightId();
	}

	public List<Flight> displayFlight() {
		List <Flight> flightList=dao.fetchAll(Flight.class);
		return flightList;
	}

	public Flight fetchFlightById(int flightId) {
		Flight flight=dao.fetchById(Flight.class, flightId);
		return flight;
	}
	
	@Transactional
	public int deleteFlight(int flightId) {

		Flight flight=dao.fetchById(Flight.class, flightId);
		
		//validating whether the flight with the given flightId exist or not
		if(flight==null)
		return 0;
		else
		{
			int deletedFlightId=flight.getFlightId();
			dao.delete(flight);
			return deletedFlightId;
		}
			
	}
	

}
