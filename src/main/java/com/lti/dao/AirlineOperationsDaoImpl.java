package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
	
	String fetchQuery="select f from Flight f where booking.flight.flightId=:f.flightId";
	Query query=entityManager.createQuery(fetchQuery);
	Flight fetchedFlight=(Flight)query.getResultList();
	return fetchedFlight;
}


}
