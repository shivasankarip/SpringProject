package com.puzzles.movieticket.domain.impl;

import java.util.Date;

import com.puzzles.movieticket.domain.Movie;

public class MovieImpl implements Movie {
	
	private Long movieId;
	
	private String movieName;
	
	private Date releaseDate;

	@Override
	public Long getMovieId() {
		return movieId;
	}
	
	@Override
	public void setMovieId(Long movieId) {
		this.movieId = movieId;
	}

	@Override
	public String getMovieName() {
		return movieName;
	}

	@Override
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@Override
	public Date getReleaseDate() {
		return releaseDate;
	}

	@Override
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}
	
	
	

}
