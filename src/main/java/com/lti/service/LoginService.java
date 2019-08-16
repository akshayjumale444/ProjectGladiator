package com.lti.service;

public interface LoginService {
	
	public boolean validateUser(String email,String password);
	public boolean validateAdmin(String email,String passsword);

}
