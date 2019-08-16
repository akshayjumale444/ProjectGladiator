package com.lti.test;

import java.time.LocalDate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

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
		Booking booking=new Booking();
		
		booking.setSource("Mumbai");
		booking.setDestination("Pune");
		booking.setJourneyDate(LocalDate.of(2019, 9, 15));
		booking.setNoOfPassengers(5);
		booking.setCost(12750);
		
		int bookingId=dao.addBooking(booking);
		System.out.println("Booking Id: "+bookingId);
		
	}
	
	@Test
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
	}
}
