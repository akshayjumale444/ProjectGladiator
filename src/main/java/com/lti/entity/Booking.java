package com.lti.entity;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="AL_BOOKING_DETAIL")
public class Booking {
	
	@Id
	@GeneratedValue
	@Column(name="BOOKING_ID")
	private int bookingId;
	
	@Column(name="SOURCE")
	private String source;
	
	@Column(name="DESTINATION")
	private String destination;
	
	@Column(name="BOOKING_DATE")
	private LocalDate bookingDate;
	
	@Column(name="JOURNEY_DATE")
	private LocalDate journeyDate;
	
	@Column(name="NO_OF_PASSENGERS")
	private int noOfPassengers;
	
	@Column(name="COST")
	private double cost;
	
	@Column(name="TICKET_MAILING_ID")
	private String ticketMailingId;
	
	@Column(name="TRAVEL_CLASS")
	private String travelClass;
	
	@OneToOne
	@JoinColumn(name="USER_ID_FK")
	private User user;
	
	@OneToOne
	@JoinColumn(name="FLIGHT_ID_FK")
	private Flight flight;
	
	@OneToMany(mappedBy="booking", cascade=CascadeType.ALL)
	private Set<Passenger> passengerList;
	
	@OneToOne(mappedBy="booking", cascade=CascadeType.ALL)
	private Payment paymentDetail;

	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
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
	
	

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public LocalDate getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(LocalDate journeyDate) {
		this.journeyDate = journeyDate;
	}

	public int getNoOfPassengers() {
		return noOfPassengers;
	}

	public void setNoOfPassengers(int noOfPassengers) {
		this.noOfPassengers = noOfPassengers;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}
	
	
	public String getTicketMailingId() {
		return ticketMailingId;
	}

	public void setTicketMailingId(String ticketMailingId) {
		this.ticketMailingId = ticketMailingId;
	}
	
	

	public String getTravelClass() {
		return travelClass;
	}

	public void setTravelClass(String travelClass) {
		this.travelClass = travelClass;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}

	public Set<Passenger> getPassengerList() {
		return passengerList;
	}

	public void setPassengerList(Set<Passenger> passengerList) {
		this.passengerList = passengerList;
	}

	public Payment getPaymentDetail() {
		return paymentDetail;
	}

	public void setPaymentDetail(Payment paymentDetail) {
		this.paymentDetail = paymentDetail;
	}
	
}
