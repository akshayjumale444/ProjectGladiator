package com.lti.dto;

import java.time.LocalDate;
import java.util.List;

import com.lti.entity.Passenger;

public class BookingDto {

	private String journeyDate;
	private int noOfPassenger;
	private double cost;
	private int userId;
	private int flightId;
	private String emailId;
	private String travelClass;
	
	private List<Passenger> passengerList;

	public String getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}

	public int getNoOfPassenger() {
		return noOfPassenger;
	}

	public void setNoOfPassenger(int noOfPassenger) {
		this.noOfPassenger = noOfPassenger;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	public List<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(List<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	

	public String getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}

	@Override
	public String toString() {
		return "BookingDto [cost=" + cost + ", emailId=" + emailId + ", flightId=" + flightId + ", journeyDate="
				+ journeyDate + ", noOfPassenger=" + noOfPassenger + ", passengerList=" + passengerList + ", userId="
				+ userId + "]";
	}
	
	

}
