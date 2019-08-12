package com.lti.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.lti.dummy.Dummy;

@RestController
public class DummyTime {
	
	@PostMapping("/getTime.lti")
	public String getTime(@RequestBody Dummy d) {
		System.out.println(d.getDeparture());
		return "Successfull";
	}

}
