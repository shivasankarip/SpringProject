package com.puzzles.movieticket.domain.impl;

import com.puzzles.movieticket.domain.Theater;
import com.puzzles.movieticket.domain.TheaterAddress;

public class TheaterImpl implements Theater{

	private Long theaterId;
	
	private String theaterName;
	
	private TheaterAddress theaterAddress;

	@Override
	public Long getTheaterId() {
		return theaterId;
	}

	@Override
	public void setTheaterId(Long theaterId) {
		this.theaterId = theaterId;
	}

	@Override
	public String getTheaterName() {
		return theaterName;
	}

	@Override
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}

	@Override
	public TheaterAddress getTheaterAddress() {
		return theaterAddress;
	}

	@Override
	public void setTheaterAddress(TheaterAddress theaterAddress) {
		this.theaterAddress = theaterAddress;
	}
	
	
}
