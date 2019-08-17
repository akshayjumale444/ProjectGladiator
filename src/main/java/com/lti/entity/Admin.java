package com.lti.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="AL_ADMIN_DETAIL")
public class Admin{

	@Id
	@GeneratedValue
	@Column(name="ADMIN_ID")
	private int adminId;

	@Column(name="ADMIN_USERNAME")
	private String adminUsername;

	@Column(name="ADMIN_PASSWORD")
	private String adminPassword;

	@Column(name="ADMIN_EMAIL")
	private String adminEmail;

	//A single admin can add multiple flight
	//Admin=>Flight(OneToMany)
	@OneToMany(mappedBy="admin")
	private Set<Flight> flightList;

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getAdminUsername() {
		return adminUsername;
	}

	public void setAdminUsername(String adminUsername) {
		this.adminUsername = adminUsername;
	}

	public String getAdminPassword() {
		return adminPassword;
	}

	public void setAdminPassword(String adminPassword) {
		this.adminPassword = adminPassword;
	}

	public String getAdminEmail() {
		return adminEmail;
	}

	public void setAdminEmail(String adminEmail) {
		this.adminEmail = adminEmail;
	}

}
