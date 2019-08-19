package com.lti.dto;

import java.util.List;

import com.lti.entity.Passenger;

public class TicketDto {
	
	private int bookingId;
	private int flightId;
	private String source;
	private String destination;
	private String departureTime;
	private String arrivalTime;
	private String journeyDate;
	private String travelClass;
	private List<String> passengerName;
	
	public List<String> getPassengerName() {
		return passengerName;
	}
	public void setPassengerName(List<String> passengerName) {
		this.passengerName = passengerName;
	}

	public int getBookingId() {
		return bookingId;
	}
	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}
	public int getFlightId() {
		return flightId;
	}
	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getDestination() {
		return destination;
	}
	public void setDestination(String destination) {
		this.destination = destination;
	}
	public String getDepartureTime() {
		return departureTime;
	}
	public void setDepartureTime(String departureTime) {
		this.departureTime = departureTime;
	}
	public String getArrivalTime() {
		return arrivalTime;
	}
	public void setArrivalTime(String arrivalTime) {
		this.arrivalTime = arrivalTime;
	}
	public String getJourneyDate() {
		return journeyDate;
	}
	public void setJourneyDate(String journeyDate) {
		this.journeyDate = journeyDate;
	}
	public String getTravelClass() {
		return travelClass;
	}
	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}
	@Override
	public String toString() {
		return "TicketDto [bookingId=" + bookingId + ", flightId=" + flightId + ", source=" + source + ", destination="
				+ destination + ", departureTime=" + departureTime + ", arrivalTime=" + arrivalTime + ", journeyDate="
				+ journeyDate + ", travelClass=" + travelClass + ", passengerName=" + passengerName + "]";
	}

	
	
}
