package com.puzzles.movieticket.domain;

public interface UserAccount {

	Long getUserId();

	void setUserId(Long userId);

	String getUserEmailId();

	void setUserEmailId(String userEmailId);

	String getPassword();

	void setPassword(String password);

	String getFirstName();

	void setFirstName(String firstName);

	String getLastName();

	void setLastName(String lastName);

}
