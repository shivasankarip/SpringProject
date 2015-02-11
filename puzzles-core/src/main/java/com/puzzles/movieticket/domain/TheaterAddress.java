package com.puzzles.movieticket.domain;

public interface TheaterAddress {

	Long getTheaterAddressId();

	void setTheaterAddressId(Long theaterAddressId);

	String getTheaterAddressLine();

	void setTheaterAddressLine(String theaterAddressLine);

	void setTheaterCity(String theaterCity);

	String getTheaterCity();

	int getTheaterZip();

	void setTheaterZip(int theaterZip);

	String getTheaterState();

	void setTheaterState(String theaterState);

}
