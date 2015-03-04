package com.puzzles.movieticket.controller.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.puzzles.movieticket.domain.User;


@XmlRootElement(name = "user")
public class HttpUser {
	
	@XmlElement
	public int userId;
	
	@XmlElement
	public String emailId;
	
	@XmlElement
	public String password;
	
	@XmlElement
	public String firstName;
	
	@XmlElement
	public String lastName;
	
	@XmlElement
	public int phone;
	
	
	protected HttpUser() {}
	
	public HttpUser(User user) {
		this.userId=user.getUserId();
		this.emailId=user.getUserEmailId();
		this.password=user.getPassword();
		this.firstName=user.getFirstName();
		this.lastName=user.getLastName();
		this.phone=user.getPhone();
	}

}
