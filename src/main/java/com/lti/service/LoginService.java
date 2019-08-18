package com.lti.service;

import com.lti.dto.LoginStatus;

public interface LoginService {
	
	public LoginStatus validateUser(String email,String password);
	public boolean validateAdmin(String email,String passsword);

}
