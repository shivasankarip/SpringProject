package com.puzzles.movieticket.domain;


public interface MovieTheaterLink {

	Long getMovieTheaterLinkId();

	void setMovieTheaterLinkId(Long movieTheaterLinkId);

	Movie getMovie();

	void setMovie(Movie movie);

	Theater getTheater();

	void setTheater(Theater theater);

}
