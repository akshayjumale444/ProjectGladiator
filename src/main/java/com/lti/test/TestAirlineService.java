package com.lti.test;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;
import java.util.List;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lti.entity.Flight;
import com.lti.service.AdminService;

public class TestAirlineService {
	
	ApplicationContext ctx=new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-config.xml");
	AdminService dao=ctx.getBean(AdminService.class);
	
	@Test
	public void testFetchAll(){
		
		List<Flight> flightList=dao.displayFlight();
		
		for(Flight i:flightList)
		{
			System.out.println("FlightId :"+i.getFlightId());
			System.out.println("Source :"+i.getSource());
			System.out.println("Destination :"+i.getDestination());
			System.out.println("=======================");
		}
	}
	
	@Test
	public void testSave(){
		
		Flight flight=new Flight();
		flight.setSource("MUMBAI");
		flight.setDestination("DELHI");
		//flight.setDeparture(LocalTime.of(18, 30));
		//flight.setArrival(LocalTime.of(20, 00));
		//flight.setDuration(ChronoUnit.MINUTES.between(flight.getDeparture(),flight.getArrival()));
		flight.setEconomyClassCost(8500);
		flight.setBusinessClassCost(19500);
		flight.setNoOfSeats(20);
		flight.setEconomySeats(10);
		flight.setBusinessSeats(10);
		flight.setAdmin(null);
	
		int dummyFlightId=dao.addFlight(flight);
		System.out.println("FlightId"+dummyFlightId);
		
	}
	
	@Test
	public void testFetchById() {
		Flight flight=(Flight)dao.fetchFlightById(371);
		
		System.out.println("FlightId"+flight.getFlightId());
	}

}
