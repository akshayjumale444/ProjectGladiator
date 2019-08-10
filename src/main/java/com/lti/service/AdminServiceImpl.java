package com.lti.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lti.dao.GenericDao;
import com.lti.dao.GenericDaoImpl;
import com.lti.entity.Flight;

@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	GenericDao dao;

	@Transactional
	public int addFlight(Flight flight) {
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
	

}
