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
import com.lti.dto.TicketDto;
import com.lti.entity.Booking;
import com.lti.entity.Flight;
import com.lti.entity.Passenger;
import com.lti.entity.Payment;
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
		booking.setTravelClass(bookingDto.getTravelClass());
		
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

	@Transactional
	public void updateBooking(int bookingId) {
		
		List<Passenger> passengerList=airlineOperationsDao.fetchPassenger(bookingId);
		for(Passenger p:passengerList) {
			p.setBookingStatus("Confirmed!");
			gd.save(p);
		}
		
		Booking booking=gd.fetchById(Booking.class, bookingId);
		int confirmedSeat=booking.getNoOfPassengers();
		
		Flight flight=airlineOperationsDao.fetchedFlight(booking);
		System.out.println("FetchedFlightId"+flight.getFlightId());
		
		if(booking.getTravelClass().equalsIgnoreCase("economy")) {
			flight.setEconomySeats(flight.getEconomySeats()-confirmedSeat);
		}
		else {
			flight.setBusinessSeats(flight.getBusinessSeats()-confirmedSeat);
		}
		flight=(Flight)gd.save(flight);
		System.out.println("Details for flight with flightId"+flight.getFlightId()+" updated");
		
		//updating payment_detail table
		Payment payment=new Payment();
		payment.setAmountPaid(booking.getCost());
		payment.setPaymentMode("Net Banking");
		payment.setBooking(booking);
		payment=(Payment)gd.save(payment);
		System.out.println("PaymentId"+payment.getPaymentId());
		
	}

	/*public void fetchTicket(int bookingId) {
		TicketDto fetchedTicket=new TicketDto();
		
		Booking booking=gd.fetchById(Booking.class, bookingId);
		airlineOperationsDao.fetchTicket(bookingId);
	}*/
	public TicketDto fetchTicket(int bookingId) {
		TicketDto fetchedTicket=new TicketDto();
		System.out.println("Reached1");
		fetchedTicket=airlineOperationsDao.fetchTicket(bookingId);
		return fetchedTicket;
		//return airlineOperationsDao.fetchTicket(bookingId);
		
	}
	
	
	
	
	/*@Transactional
	public int addPassenger(Passenger passenger) {
	
		Passenger fetchedPassenger=(Passenger)gd.save(passenger);
		int passengerId=fetchedPassenger.getPassengerId();
		return passengerId;
	}*/

}
