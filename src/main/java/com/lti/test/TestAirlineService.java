package com.lti.test;

import java.time.LocalDate;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lti.entity.User;
import com.lti.service.AirlineService;

public class TestAirlineService {

	ApplicationContext ctx=new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-config.xml");
	AirlineService dao=ctx.getBean(AirlineService.class);
	
	@Test
	public void testAddUser() {
		User user=new User();
		
		user.setFname("Shubham");
		user.setLname("Kulkarni");
		user.setEmailId("sk@gmail.com");
		user.setMobno(9874563210L);
		user.setPassword("sk123");
		
		int userId=dao.addUser(user);
		System.out.println("UserId:"+userId);
		
	}
}
