package com.lti.dto;

import org.springframework.stereotype.Component;

public class LoginStatus {
	
	private boolean result;
	private int fetchedUserId;
	
	public boolean isResult() {
		return result;
	}
	public void setResult(boolean result) {
		this.result = result;
	}
	public int getFetchedUserId() {
		return fetchedUserId;
	}
	public void setFetchedUserId(int fetchedUserId) {
		this.fetchedUserId = fetchedUserId;
	}
	
	

}
