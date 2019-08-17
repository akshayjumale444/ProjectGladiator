package com.lti.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AirlineOperationsDao;
import com.lti.dao.GenericDao;
import com.lti.entity.Booking;
import com.lti.entity.Flight;
import com.lti.entity.Passenger;
import com.lti.entity.User;
@Service
public class AirlineServiceImpl implements AirlineService{

	@Autowired
	private AirlineOperationsDao airlineOperationsDao;
	@Autowired
	private GenericDao gd;
	
	/*
	@Transactional
	public List<Flight> searchFlights() {
		// TODO Auto-generated method stub
		System.out.println("Service is called");
		
		
		return airlineOperationsDao.searchFlightOperation();
		//return gd.fetchAll(Flight.class);
	}*/

	@Transactional
	public List<Flight> searchFlights(String source, String destination, String travelClass, int noOFTravelers) {
		
		System.out.println("Service is called");
		return airlineOperationsDao.searchFlightOperation(source,destination,travelClass,noOFTravelers);
	}

	@Transactional
	public int addUser(User user) {
		User fetchedUser=(User)gd.save(user);
		int userId=fetchedUser.getUserId();
		return userId;
	}

	@Transactional
	public int addBooking(Booking booking) {
		Booking fetchedBooking=(Booking)gd.save(booking);
		int bookingId=fetchedBooking.getBookingId();
		return bookingId;
	}
	
	@Transactional
	public int addPassenger(Passenger passenger) {
	
		Passenger fetchedPassenger=(Passenger)gd.save(passenger);
		int passengerId=fetchedPassenger.getPassengerId();
		return passengerId;
	}

}
