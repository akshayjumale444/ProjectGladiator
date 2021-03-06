package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.lti.dto.LoginStatus;
import com.lti.entity.Admin;
import com.lti.entity.User;

@Repository
public class LoginDaoImpl implements LoginDao{

	@PersistenceContext
	protected EntityManager entityManager;
	
	public LoginStatus validateUser(String email, String password) {

		String fetchQuery="select u from User u where u.emailId=:fetchEmail and u.password=:fetchPassword";
		Query query=(Query)entityManager.createQuery(fetchQuery);
		query.setParameter("fetchEmail", email);
		query.setParameter("fetchPassword", password);

		List <User> fetchedResult=query.getResultList();
		
		LoginStatus loginStatus=new LoginStatus();
		 if(fetchedResult.isEmpty()) {
			 loginStatus.setResult(false);
			 loginStatus.setFetchedUserId(0);
		 }
		 else {
			 loginStatus.setResult(true);
			 loginStatus.setFetchedUserId(fetchedResult.get(0).getUserId());
		 }
		 return loginStatus;
	}

	public boolean validateAdmin(String email, String password) {

		String fetchQuery="select a from Admin a where a.adminEmail=:fetchEmail and a.adminPassword=:fetchPassword";
		Query query=(Query)entityManager.createQuery(fetchQuery);
		query.setParameter("fetchEmail", email);
		query.setParameter("fetchPassword", password);

		List <Admin> fetchedResult=query.getResultList();

		return fetchedResult.isEmpty();
	}

}
