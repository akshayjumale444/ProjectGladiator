package com.lti.dao;

import com.lti.dto.LoginStatus;

public interface LoginDao {

	public LoginStatus validateUser(String email,String password);
	public boolean validateAdmin(String email,String password);
}
