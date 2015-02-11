package com.puzzles.movieticket.domain;

import com.puzzles.movieticket.domain.TheaterAddress;

public interface Theater {

	Long getTheaterId();

	void setTheaterId(Long theaterId);

	String getTheaterName();

	void setTheaterName(String theaterName);

	TheaterAddress getTheaterAddress();

	void setTheaterAddress(TheaterAddress theaterAddress);

}
