package com.puzzles.movieticket.domain.impl;

import com.puzzles.movieticket.domain.UserAccount;

public class UserAccountImpl implements UserAccount{
	
	private Long userId;
	
	private String userEmailId;
	
	private String password;
	
	private String firstName;
	
	private String lastName;

	@Override
	public Long getUserId() {
		return userId;
	}
	@Override
	public void setUserId(Long userId) {
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
	
	

}
