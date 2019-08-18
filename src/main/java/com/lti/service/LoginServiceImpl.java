package com.lti.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lti.dao.LoginDao;
import com.lti.dto.LoginStatus;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	LoginDao dao;

	public LoginStatus validateUser(String email, String password) {
		LoginStatus isUser=dao.validateUser(email, password);
		return isUser;
	}

	public boolean validateAdmin(String email, String password) {
		boolean isAdmin=dao.validateAdmin(email, password);
		return isAdmin;
		
	}

}
