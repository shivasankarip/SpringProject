package com.puzzles.movieticket.domain;

import java.util.Date;

public interface Movie {

	Long getMovieId();

	void setMovieId(Long movieId);

	String getMovieName();

	void setMovieName(String movieName);

	Date getReleaseDate();

	void setReleaseDate(Date releaseDate);

}
