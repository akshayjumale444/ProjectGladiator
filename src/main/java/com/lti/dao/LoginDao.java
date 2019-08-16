package com.lti.dao;

public interface LoginDao {

	public boolean validateUser(String email,String password);
	public boolean validateAdmin(String email,String password);
}
