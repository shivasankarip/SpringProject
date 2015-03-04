package com.puzzles.movieticket.domain.impl;



import com.puzzles.movieticket.domain.Movie;
import com.puzzles.movieticket.domain.ShowMaster;
import com.puzzles.movieticket.domain.Theater;


public class ShowMasterImpl implements ShowMaster {

	private int showId;

	private Theater theater;
	
	private Movie movie;
	
	private String showTime;

	@Override
	public int getShowId() {
		return showId;
	}

	@Override
	public void setShowId(int showId) {
		this.showId = showId;
	}

	@Override
	public Theater getTheater() {
		return theater;
	}

	@Override
	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	@Override
	public Movie getMovie() {
		return movie;
	}

	@Override
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String getShowTime() {
		return showTime;
	}

	@Override
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	

	
}
