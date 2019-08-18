package com.lti.test;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.lti.dto.LoginStatus;
import com.lti.service.LoginService;

public class TestLoginService {
	
	@Test
	public void testValidateUser() {
	
		ApplicationContext ctx=new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-config.xml");
		LoginService service=ctx.getBean(LoginService.class);
		
		//System.out.println(service.validateUser("om@gmail.com", "qwer12"));
		LoginStatus loginStatus=service.validateUser("AJ@gmail.com", "qwer12");
		System.out.println("Result:"+loginStatus.isResult());
		System.out.println("UserId"+loginStatus.getFetchedUserId());
		
	}
	
	@Test
public void testValidateAdmin() {
		
		ApplicationContext ctx=new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/spring-config.xml");
		LoginService service=ctx.getBean(LoginService.class);
		
		System.out.println(service.validateAdmin("akshay.jumale@lntinfotech.com", "akshay"));
	}
	

}
