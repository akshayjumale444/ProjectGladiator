package com.lti.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.dto.TicketDto;
import com.lti.entity.Booking;
import com.lti.entity.Flight;
import com.lti.entity.Passenger;
import com.lti.entity.User;

@Repository
public class AirlineOperationsDaoImpl implements AirlineOperationsDao{

	@PersistenceContext
	protected EntityManager entityManager;
	
	@Autowired
	GenericDao dao;
	
	/*
	public List<Flight> searchFlightOperation() {
	
	
		//SQL Query: Select * from AL_FLIGHT_DETAIL;
		System.out.println("Airline Dao is Called");
		String searchFlightQuery = "Select f from Flight f";
		return entityManager.createQuery(searchFlightQuery).getResultList();
	}
	*/

	public List<Flight> searchFlightOperation(String source, String destination, String travelClass, int noOFTravelers) {
		
		//String searchQuery = null;
		//Query query = null;
		System.out.println(source);
		System.out.println(destination);
		System.out.println(travelClass);
		System.out.println(noOFTravelers);
		
		
		if(travelClass.equalsIgnoreCase("economy")) {
			System.out.println("Economy");
			String searchQuery = "select f from Flight f where f.source=:qsource and f.destination=:qdestination and f.economySeats>=:qnotravelers";
			Query query = (Query) entityManager.createQuery(searchQuery);
			query.setParameter("qsource", source);
			query.setParameter("qdestination", destination);
			query.setParameter("qnotravelers", noOFTravelers);
		/*
		query.setParameter("qsource", source);
		query.setParameter("qdestination", destination);
		query.setParameter("qnotravelers", noOFTravelers);
		*/
			return query.getResultList();
		}
		else {
			String searchQuery = "select f from Flight f where f.source=:qsource and f.destination=:qdestination and f.businessSeats>=:qnotravelers";
			Query query = (Query) entityManager.createQuery(searchQuery);
			query.setParameter("qsource", source);
			query.setParameter("qdestination", destination);
			query.setParameter("qnotravelers", noOFTravelers);
			return query.getResultList();
		}
		//return query.getResultList();
	}
	
public User fetchUserById(int UserId) {
		
		User user=dao.fetchById(User.class, UserId);
		return user;
	}

public void addPassenger(Passenger passenger) {

	Passenger fetchedPassenger=(Passenger)dao.save(passenger);
	//int passengerId=fetchedPassenger.getPassengerId();
	//return passengerId;
}

public List<Passenger> fetchPassenger(int bookingId) {
	
	//Booking booking=gd.fetchById(Booking.class, bookingId);
	String fetchQuery="select p from Passenger p where p.booking.bookingId=:bookingId";
	Query query=entityManager.createQuery(fetchQuery);
	query.setParameter("bookingId", bookingId);
	List<Passenger> fetchedPassenger=query.getResultList();
	return fetchedPassenger;
}

public Flight fetchedFlight(Booking booking) {
	
	Flight bookedFlight=booking.getFlight();
	int bookedFlightId=bookedFlight.getFlightId();
	String fetchQuery="select f from Flight f where f.flightId=:bookedFlightId";
	Query query=entityManager.createQuery(fetchQuery);
	query.setParameter("bookedFlightId", bookedFlightId);
	Flight fetchedFlight=(Flight)query.getSingleResult();
	return fetchedFlight;
}

public TicketDto fetchTicket(int bookingId) {
	/*
	//select * from AL_FLIGHT_DETAIL f, AL_PASSENGER_DETAIL p, AL_BOOKING_DETAIL b
	//where b.flight_id_fk=f.flight_id and p.booking_id_fk=b.booking_id
	
	String fetchTicketQuery="select f.flightId, f.source, f.destination, f.departure, f.arrival, p.name, b.bookingId from Flight f, Passenger p, Booking b where b.flight.flightId=f.flightId and p.booking.bookingId=:bookingId";
	Query query=entityManager.createQuery(fetchTicketQuery);
	query.setParameter("bookingId", bookingId);
	List<Object[]> fetchedObjects=query.getResultList();
	//System.out.println("Ticket Fetched");
	*/
	System.out.println("Reached2");
	//fetching flight
	Booking booking=new Booking();
	booking=dao.fetchById(Booking.class, bookingId);
	Flight bookedFlight=booking.getFlight();
	int bookedFlightId=bookedFlight.getFlightId();
	String fetchQuery1="select f from Flight f where f.flightId=:bookedFlightId";
	Query query1=entityManager.createQuery(fetchQuery1);
	query1.setParameter("bookedFlightId", bookedFlightId);
	Flight fetchedFlight=(Flight)query1.getSingleResult();
	
	System.out.println(fetchedFlight.getFlightId());
	
	
	//fetching passenger
	String fetchQuery2="select p from Passenger p where p.booking.bookingId=:bookingId";
	Query query2=entityManager.createQuery(fetchQuery2);
	query2.setParameter("bookingId", bookingId);
	List<Passenger> passengerList=query2.getResultList();
	
	for(Passenger p: passengerList) {
		System.out.println(p.getName());
	}
	
	//generating ticket
	TicketDto ticket=new TicketDto();
	ticket.setBookingId(bookingId);
	ticket.setFlightId(fetchedFlight.getFlightId());
	ticket.setSource(fetchedFlight.getSource());
	ticket.setDestination(fetchedFlight.getDestination());
	ticket.setDepartureTime(fetchedFlight.getDeparture());
	ticket.setArrivalTime(fetchedFlight.getArrival());
	ticket.setJourneyDate(booking.getJourneyDate().toString());
	ticket.setTravelClass(booking.getTravelClass());
	
	List<String> passengerNames=new ArrayList<String>();
	for(Passenger p: passengerList) {
		passengerNames.add(p.getName());
	}
	ticket.setPassengerName(passengerNames);
	
	return ticket;
	//return fetchedObjects;
	
	/*for(Object[] t:fetchedObjects) {
		System.out.println("0=>"+t[0]);
		System.out.println("1=>"+t[1]);
		System.out.println("2=>"+t[2]);
		System.out.println("3=>"+t[3]);
		System.out.println("4=>"+t[4]);
		System.out.println("5=>"+t[5]);
		System.out.println("6=>"+t[6]);
	}*/
	
}

}
