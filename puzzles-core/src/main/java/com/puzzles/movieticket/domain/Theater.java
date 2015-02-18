package com.puzzles.movieticket.domain;



public interface Theater {

	int getTheaterId();

	void setTheaterId(int theaterId);

	String getTheaterName();

	void setTheaterName(String theaterName);

	int getScreenNo();

	void setScreenNo(int screenNo);	

	String getTheaterAddressLine();

	void setTheaterAddressLine(String theaterAddressLine);

	void setTheaterCity(String theaterCity);

	String getTheaterCity();

	int getTheaterZip();

	void setTheaterZip(int theaterZip);

	String getTheaterState();

	void setTheaterState(String theaterState);

	int getHelpLineNo();

	void setHelpLineNo(int helpLineNo);

}
