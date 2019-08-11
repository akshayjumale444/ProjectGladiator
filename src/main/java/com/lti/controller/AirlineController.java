package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.Status;
import com.lti.entity.Flight;
import com.lti.service.AdminService;

@RestController
public class AirlineController {
	
	@Autowired
	private AdminService adminService;
	
	@PostMapping("/addFlight.lti")
	public Status addFlight(@RequestBody Flight flight) {
		
		int flightId=adminService.addFlight(flight);
		Status status=new Status();
		status.setGeneratedId(flightId);
		status.setMessage("Flight Added");
		
		return status;
	}
	
	@PostMapping("/displayAllFlight.lti")
	public List<Flight> displayAllFlight(){
		
		List<Flight> flightList=adminService.displayFlight();
		return flightList;
	}
	
	@GetMapping("/fetchFlightById")
	public Flight fetchFlight(@RequestParam("flightId") int flightId){
		Flight fetchedFlight=adminService.fetchFlightById(flightId);
		return fetchedFlight;
		
	}
	
	@GetMapping("/deleteFlight.lti")
	@ResponseBody
	public Status deleteFlight(@RequestParam("flightId") String fId) {
		int deletedFlightId=adminService.deleteFlight(Integer.parseInt(fId));
		
		Status status=new Status();
		
		//validating
		if(deletedFlightId==0)
		{
			status.setMessage("Flight with the given FlightId Does not exist!!!");
			status.setGeneratedId(deletedFlightId);
			return status;
		}
		else
		{	
		status.setGeneratedId(deletedFlightId);
		status.setMessage("Flight deleted succesfully!!!");
		return status;
	
		}
	}	
	
}
