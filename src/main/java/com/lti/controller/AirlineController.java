package com.lti.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dto.DataTransfer;
import com.lti.dto.Login;
import com.lti.dto.Status;
import com.lti.entity.Admin;
import com.lti.entity.Flight;
import com.lti.entity.User;
import com.lti.service.AdminService;
import com.lti.service.AirlineService;
import com.lti.service.LoginService;

@RestController
public class AirlineController {


	@Autowired
	private AirlineService airlineService;

	@Autowired
	private AdminService adminService;

	@Autowired
	private LoginService loginService;

	Status status=new Status();

	//------------------------------------ LOGIN OPERATIONS---------------------------------------------------------

	@PostMapping("/validateUser.lti")
	public boolean validateUser(@RequestBody Login login) {

		boolean result=loginService.validateUser(login.getEmail(), login.getPassword());
		return result;
		//true=>Either Username or password is incorrect
		//false=>is a valid user
	}

	@PostMapping("/validateAdmin.lti")
	public boolean validateAdmin(@RequestBody Login login) {

		boolean result=loginService.validateAdmin(login.getEmail(), login.getPassword());
		return result;
		//true=>Either Username or password is incorrect
		//false=>is a valid Admin
	}

	//------------------------------------ LOGIN OPERATIONS ENDS-------------------------------------------------

	//-------------------------------------USER OPERATIONS-----------------------------------------------------------

	@GetMapping("/searchFlights.lti")
	public List<Flight> searchFlightsControl(@RequestParam ("source") String source, @RequestParam ("destination") String destination, @RequestParam ("travelClass") String travelClass, @RequestParam ("noOFTravelers") int noOFTravelers){
		System.out.println("Controlled is called ");

		return airlineService.searchFlights(source,destination,travelClass,noOFTravelers);
	}

	@PostMapping("/addUser.lti")
	public String registerUser(@RequestBody User user) {
		int userId=airlineService.addUser(user);

		status.setGeneratedId(userId);
		status.setMessage("Registration Succesful!!! Login to Proceed");
		return status.getMessage();

	}
	//-------------------------------------USER OPERATIONS ENDS------------------------------------------


	//---------------------------------ADMIN OPERATIONS------------------------------------------------------


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

	//----------------------------------ADMIN OPERATIONS END-------------------------------------------

}
