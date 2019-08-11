package com.lti.entity;

import java.time.Instant;
import java.time.LocalTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="AL_FLIGHT_DETAIL")
public class Flight{
	
	@Id
	@GeneratedValue
	@Column(name="FLIGHT_ID")
	private int flightId;
	
	@Column(name="SOURCE")
	private String source;
	
	@Column(name="DESTINATION")
	private String destination;
	
	@Column(name="DEPARTURE")
	private LocalTime departure;
	
	@Column(name="ARRIVAL")
	private LocalTime arrival;
	
	//To calculate duration=>create variable of class Instant i.e Instant duration
	//Use "ChronoUnit.HOURS.between(arrival, departure)()" to calculate,
	//timegap between two instant i.e. arrival and departure
	@Column(name="DURATION")
	private long duration;
	
	@Column(name="ECONOMY_CLASS_COST")
	private double economyClassCost;
	
	@Column(name="BUSINESS_CLASS_COST")
	private double businessClassCost;
	
	@Column(name="NO_OF_SEATS")
	private int noOfSeats;
	
	@Column(name="ECONOMY_SEATS")
	private int economySeats;
	
	@Column(name="BUSINESS_SEATS")
	private int businessSeats;
	
	
	//Flight=>Admin(ManyToOne)
	@ManyToOne
	@JoinColumn(name="ADMIN_ID_FK")
	private Admin admin;
	
	

	public Admin getAdmin() {
		return admin;
	}

	public void setAdmin(Admin admin) {
		this.admin = admin;
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

	public LocalTime getDeparture() {
		return departure;
	}

	public void setDeparture(LocalTime departure) {
		this.departure = departure;
	}

	public LocalTime getArrival() {
		return arrival;
	}

	public void setArrival(LocalTime arrival) {
		this.arrival = arrival;
	}


	public long getDuration() {
		return duration;
	}

	public void setDuration(long duration) {
		this.duration = duration;
	}

	public double getEconomyClassCost() {
		return economyClassCost;
	}

	public void setEconomyClassCost(double economyClassCost) {
		this.economyClassCost = economyClassCost;
	}

	public double getBusinessClassCost() {
		return businessClassCost;
	}

	public void setBusinessClassCost(double businessClassCost) {
		this.businessClassCost = businessClassCost;
	}

	public int getNoOfSeats() {
		return noOfSeats;
	}

	public void setNoOfSeats(int noOfSeats) {
		this.noOfSeats = noOfSeats;
	}

	public int getEconomySeats() {
		return economySeats;
	}

	public void setEconomySeats(int economySeats) {
		this.economySeats = economySeats;
	}

	public int getBusinessSeats() {
		return businessSeats;
	}

	public void setBusinessSeats(int businessSeats) {
		this.businessSeats = businessSeats;
	}

	@Override
	public String toString() {
		return "Flight [flightId=" + flightId + ", source=" + source + ", destination=" + destination + ", departure="
				+ departure + ", arrival=" + arrival + ", duration=" + duration + ", economyClassCost="
				+ economyClassCost + ", businessClassCost=" + businessClassCost + ", noOfSeats=" + noOfSeats
				+ ", economySeats=" + economySeats + ", businessSeats=" + businessSeats + ", admin=" + admin + "]";
	}
		
}
