package com.lti.service;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.AirlineOperationsDao;
import com.lti.dao.GenericDao;
import com.lti.dto.BookingDto;
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
	public int addBooking(BookingDto bookingDto) {
		
		User user=new User();
		Flight flight=new Flight();
		Booking booking=new Booking();
		Passenger passenger=new Passenger();
		
		booking.setJourneyDate(LocalDate.parse(bookingDto.getJourneyDate()));
		booking.setNoOfPassengers(bookingDto.getNoOfPassenger());
		booking.setCost(bookingDto.getCost());
		booking.setTicketMailingId(bookingDto.getEmailId());
		booking.setBookingDate(LocalDate.now());
		
		user=gd.fetchById(User.class, bookingDto.getUserId());
		flight=gd.fetchById(Flight.class, bookingDto.getFlightId());
		
		booking.setUser(user);
		booking.setFlight(flight);
		
		booking.setSource(flight.getSource());
		booking.setDestination(flight.getDestination());
		
		Booking fetchedBooking=(Booking)gd.save(booking);
		int bookingId=fetchedBooking.getBookingId();
		
		/*
		 * HashSet<PassengerDetail> passengers = new HashSet<PassengerDetail>();
			for(PassengerDetail p : dto.getPassengerDetails()) {
			p.setBook(booking);
			passengers.add(p);
		 */
		HashSet<Passenger> passengers=new HashSet<Passenger>();
		for(Passenger p: bookingDto.getPassengerList()) {
			p.setBooking(fetchedBooking);
			p.setBookingStatus("Not Booked!");
			
			airlineOperationsDao.addPassenger(p);
		}
		

		return bookingId;
	}
	
	/*@Transactional
	public int addPassenger(Passenger passenger) {
	
		Passenger fetchedPassenger=(Passenger)gd.save(passenger);
		int passengerId=fetchedPassenger.getPassengerId();
		return passengerId;
	}*/

}
