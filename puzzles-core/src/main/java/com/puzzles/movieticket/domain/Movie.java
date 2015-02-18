package com.puzzles.movieticket.domain;

import java.util.Date;

public interface Movie {

	int getMovieId();

	void setMovieId(int movieId);

	String getMovieName();

	void setMovieName(String movieName);

	String getMovieLanguage();

	void setMovieLanguage(String movieLanguage);

	Date getReleaseDate();

	void setReleaseDate(Date releaseDate);

	int getMovieDuration();

	void setMovieDuration(int movieDuration);



}
