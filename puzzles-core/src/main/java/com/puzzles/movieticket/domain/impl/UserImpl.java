package com.puzzles.movieticket.domain.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.puzzles.movieticket.domain.User;

@Entity
@Table(name="user")
public class UserImpl implements User{
	
	@Id
	@Column(name="user_id")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int userId;
	
	@Column(name="email_id")
	private String userEmailId;
	
	@Column(name="password")
	private String password;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="phone")
	private int phone;

	@Override
	public int getUserId() {
		return userId;
	}
	@Override
	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Override
	public String getUserEmailId() {
		return userEmailId;
	}

	@Override
	public void setUserEmailId(String userEmailId) {
		this.userEmailId = userEmailId;
	}

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String getFirstName() {
		return firstName;
	}

	@Override
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	@Override
	public String getLastName() {
		return lastName;
	}

	@Override
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Override
	public int getPhone() {
		return phone;
	}
	
	@Override
	public void setPhone(int phone) {
		this.phone = phone;
	}
	
	@Override
	public String toString(){
		
		return "First name "+firstName + "email"+ userEmailId ;
		
	}

}
