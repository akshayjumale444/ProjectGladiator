package com.lti.test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lti.dto.BookingDto;
import com.lti.entity.Booking;
import com.lti.entity.Passenger;
import com.lti.entity.User;
import com.lti.service.AirlineService;

public class TestAirlineService {

	ApplicationContext ctx=new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-config.xml");
	AirlineService dao=ctx.getBean(AirlineService.class);
	
	@Test
	public void testAddUser() {
		User user=new User();
		
		user.setFname("Shubham");
		user.setLname("Kulkarni");
		user.setEmailId("sk@gmail.com");
		user.setMobno(9874563210L);
		user.setPassword("sk123");
		
		int userId=dao.addUser(user);
		System.out.println("UserId:"+userId);
		
	}
	
	@Test
	public void testAddBooking() {
		
		List<Passenger> passengers=new ArrayList<Passenger>(); 
		
		Passenger p1=new Passenger();
		p1.setName("AJ");
		p1.setAge(22);
		p1.setGender("M");
		
		Passenger p2=new Passenger();
		p2.setName("DA");
		p2.setAge(22);
		p2.setGender("F");
		
		passengers.add(p1);
		passengers.add(p2);
		
		BookingDto dto=new BookingDto();
		//dto.setJourneyDate(LocalDate.of(2019, 8, 20));
		dto.setNoOfPassenger(5);
		dto.setCost(12750);
		dto.setEmailId("abc@gmail.com");
		dto.setFlightId(644);
		dto.setUserId(661);
		dto.setPassengerList(passengers);

		System.out.println(dto.toString());
		
		int bookingId=dao.addBooking(dto);
		System.out.println("BookingId: "+bookingId);

		/*Booking booking=new Booking();
		
		booking.setSource("Mumbai");
		booking.setDestination("Pune");
		booking.setJourneyDate(LocalDate.of(2019, 9, 15));
		booking.setNoOfPassengers(5);
		booking.setCost(12750);
		
		//int bookingId=dao.addBooking(booking);
		//System.out.println("Booking Id: "+bookingId);
		*/
	}
	
	/*
	 * @Test
	 
	public void testAddPassenger() {
		Passenger passenger=new Passenger();
		
		passenger.setName("Anita");
		passenger.setGender("Female");
		passenger.setAge(25);
		passenger.setBookingStatus("Confirmed");
		
		int passengerId=dao.addPassenger(passenger);
		System.out.println("PassengerId: "+passengerId);
	}
	
	@Test
	public void testfetchUserById() {
		User user=new User();
		
		user=dao.fetchUserById(122);
		System.out.println(user.getFname());
	}*/
	
	@Test
	public void testUpdateBooking() {
		
		dao.updateBooking(161);
		
	}
	
	/*@Test
	public void testFetchedFlight() {
		
		Flight flight=dao.
	}*/
}


