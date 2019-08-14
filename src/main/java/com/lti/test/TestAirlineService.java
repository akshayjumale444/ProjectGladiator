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
		
		user.setFname("Akshay");
		user.setLname("Jumale");
		user.setEmailId("aks@gmail.com");
		user.setMobno(9689036807L);
		user.setPassword("abc123");
		user.setDateOfBirth(LocalDate.of(1997, 10, 12));
		
		dao.addUser(user);
		
	}
}
