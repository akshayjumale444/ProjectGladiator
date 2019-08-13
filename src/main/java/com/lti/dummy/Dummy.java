package com.lti.dummy;

import java.time.LocalTime;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;

public class Dummy {
	
	@DateTimeFormat(pattern="hh:mm")
	@JsonFormat(pattern="hh:mm")
	private LocalTime departure;

	public LocalTime getDeparture() {
		return departure;
	}

	public void setDeparture(LocalTime departure) {
		this.departure = departure;
	}

}
