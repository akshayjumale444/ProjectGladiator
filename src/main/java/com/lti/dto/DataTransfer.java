package com.lti.dto;

public class DataTransfer {
	private String source;
	private String destination;
	private String departure;
	private String arrival;
	private double economyClassCost;
	private double businessClassCost;
	private int noOfSeats;
	private int economySeats;
	private int businessSeats;
	private int adminId;
	
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
	public String getDeparture() {
		return departure;
	}
	public void setDeparture(String departure) {
		this.departure = departure;
	}
	public String getArrival() {
		return arrival;
	}
	public void setArrival(String arrival) {
		this.arrival = arrival;
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
	public int getAdminId() {
		return adminId;
	}
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

}
