package com.puzzles.movieticket.domain.impl;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.puzzles.movieticket.domain.Movie;

@Entity
@Table(name="movie")
public class MovieImpl implements Movie {
	@Id
	@Column(name="movie_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieId;
	
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="movie_language")
	private String movieLanguage;
	
	@Column(name="release_date")
	private Date releaseDate;

	@Column(name="movie_duration")
	private int movieDuration;

	@Override
	public int getMovieId() {
		return movieId;
	}

	@Override
	public void setMovieId(int movieId) {
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
	public String getMovieLanguage() {
		return movieLanguage;
	}

	@Override
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	@Override
	public Date getReleaseDate() {
		return releaseDate;
	}

	@Override
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public int getMovieDuration() {
		return movieDuration;
	}

	@Override
	public void setMovieDuration(int movieDuration) {
		this.movieDuration = movieDuration;
	}
	
	
}
