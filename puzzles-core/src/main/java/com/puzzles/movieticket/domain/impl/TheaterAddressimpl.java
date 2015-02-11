package com.puzzles.movieticket.domain.impl;

import com.puzzles.movieticket.domain.TheaterAddress;

public class TheaterAddressimpl implements TheaterAddress {
	
	private Long theaterAddressId;
	
	private String theaterAddressLine;
	
	private String theaterCity;
	
	private int theaterZip;
	
	private String theaterState;

	@Override
	public Long getTheaterAddressId() {
		return theaterAddressId;
	}

	@Override
	public void setTheaterAddressId(Long theaterAddressId) {
		this.theaterAddressId = theaterAddressId;
	}

	@Override
	public String getTheaterAddressLine() {
		return theaterAddressLine;
	}

	@Override
	public void setTheaterAddressLine(String theaterAddressLine) {
		this.theaterAddressLine = theaterAddressLine;
	}

	@Override
	public String getTheaterCity() {
		return theaterCity;
	}

	@Override
	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}

	@Override
	public int getTheaterZip() {
		return theaterZip;
	}

	@Override
	public void setTheaterZip(int theaterZip) {
		this.theaterZip = theaterZip;
	}

	@Override
	public String getTheaterState() {
		return theaterState;
	}

	@Override
	public void setTheaterState(String theaterState) {
		this.theaterState = theaterState;
	}
	

}
