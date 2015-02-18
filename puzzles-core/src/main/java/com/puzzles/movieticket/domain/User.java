package com.puzzles.movieticket.domain;

public interface User {

	int getUserId();

	String getUserEmailId();

	void setUserEmailId(String userEmailId);

	String getPassword();

	void setPassword(String password);

	String getFirstName();

	void setFirstName(String firstName);

	String getLastName();

	void setLastName(String lastName);

	void setPhone(Integer phone);

	Integer getPhone();

	void setUserId(int userId);

}
