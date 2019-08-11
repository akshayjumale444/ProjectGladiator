package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.entity.Flight;
import com.lti.service.AdminService;

@RestController
public class AirlineController {
	
	@Autowired
	AdminService adminService;
	
	@PostMapping("/addFlight.lti")
	public Status addFlight(@RequestBody Flight flight) {
		
		int flightId=adminService.addFlight(flight);
		Status status=new Status();
		status.setGeneratedId(flightId);
		status.setMessage("Flight Added");
		
		flight.toString();
		
		return status;
	}
	
	@PostMapping("/displayAllFlight.lti")
	public List<Flight> displayAllFlight(){
		
		List<Flight> flightList=adminService.displayFlight();
		return flightList;
	}
}
