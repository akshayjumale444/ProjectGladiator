package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.lti.entity.Flight;
import com.lti.entity.User;


public interface AirlineService {

	public List<Flight> searchFlights(String source,String destination,String travelClass,int noOFTravelers);
	public int addUser(User user);
}
