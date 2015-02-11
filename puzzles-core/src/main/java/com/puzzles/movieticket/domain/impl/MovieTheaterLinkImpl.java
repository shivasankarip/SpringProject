package com.puzzles.movieticket.domain.impl;

import com.puzzles.movieticket.domain.Movie;
import com.puzzles.movieticket.domain.MovieTheaterLink;
import com.puzzles.movieticket.domain.Theater;

public class MovieTheaterLinkImpl implements MovieTheaterLink {
	
	private Long movieTheaterLinkId;
	
	private Movie movie;
	
	private Theater theater;

	@Override
	public Long getMovieTheaterLinkId() {
		return movieTheaterLinkId;
	}

	@Override
	public void setMovieTheaterLinkId(Long movieTheaterLinkId) {
		this.movieTheaterLinkId = movieTheaterLinkId;
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
	public Theater getTheater() {
		return theater;
	}

	@Override
	public void setTheater(Theater theater) {
		this.theater = theater;
	}
	
	

}
