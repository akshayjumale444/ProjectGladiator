package com.lti.function;

import java.time.LocalTime;
import java.time.temporal.ChronoUnit;

import org.springframework.stereotype.Component;

@Component
public class RequiredFunction 
{
	//following method calculateDuration() calculate time duration between departure,
	//and arrival in (hrs and mins) i.e 03hrs 20mins
	public String calculateDuration(String getDeparture, String getArrival) {
		
		LocalTime departure=LocalTime.parse(getDeparture);
		LocalTime arrival=LocalTime.parse(getArrival);
		long var_duration=ChronoUnit.MINUTES.between(departure, arrival);
		double var=(double)var_duration/60;
		var=var-Math.floor(var);
		int hours=(int) (var_duration/60);
		int minutes=(int)(var*60);
		String duration=hours+"hrs "+minutes+"mins";
		return duration;
	}

}
