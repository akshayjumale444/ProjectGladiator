package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.DataTransfer;
import com.lti.dto.Status;
import com.lti.entity.Admin;
import com.lti.entity.Flight;
import com.lti.service.AdminService;

@RestController
public class AirlineController {

	@Autowired
	private AdminService adminService;


	/*public Status addFlight(@RequestBody Flight flight) {

		int flightId=adminService.addFlight(flight);
		Status status=new Status();
		status.setGeneratedId(flightId);
		status.setMessage("Flight Added");

		return status;
	}*/

	@PostMapping("/addFlight.lti")
	public Status addFlight(@RequestBody DataTransfer dt) {

		Admin admin=new Admin();
		admin.setAdminId(dt.getAdminId());

		Flight flight=new Flight();
		flight.setSource(dt.getSource());
		flight.setDestination(dt.getDestination());
		flight.setDeparture(dt.getDeparture());
		flight.setArrival(dt.getArrival());
		flight.setNoOfSeats(dt.getNoOfSeats());
		flight.setEconomySeats(dt.getEconomySeats());
		flight.setBusinessSeats(dt.getBusinessSeats());
		flight.setEconomyClassCost(dt.getEconomyClassCost());
		flight.setBusinessClassCost(dt.getBusinessClassCost());
		flight.setAdmin(admin);

		int flightId=adminService.addFlight(flight);
		Status status=new Status();
		status.setGeneratedId(flightId);
		status.setMessage("Flight Added successfully!");

		return status;
	}



	@PostMapping("/displayAllFlight.lti")
	public List<Flight> displayAllFlight(){

		List<Flight> flightList=adminService.displayFlight();
		return flightList;
	}

	/*@PostMapping("/fetchFlightById")
	public Flight fetchFlight(@RequestBody Flight fId){
		Flight fetchedFlight=adminService.fetchFlightById(fId.getFlightId());
		return fetchedFlight;

	}*/

	@PostMapping("/deleteFlight.lti")
	public Status deleteFlight(@RequestBody Flight fId) {
		int deletedFlightId=adminService.deleteFlight(fId.getFlightId());

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
