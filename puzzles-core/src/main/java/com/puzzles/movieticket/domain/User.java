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

	int getPhone();

	void setUserId(int userId);

	void setPhone(int phone);

}
