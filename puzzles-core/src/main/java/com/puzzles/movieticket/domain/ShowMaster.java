package com.puzzles.movieticket.domain;

public interface ShowMaster {


	void setShowId(int showId);

	Theater getTheater();

	void setTheater(Theater theater);

	Movie getMovie();

	void setMovie(Movie movie);

	String getShowTime();

	void setShowTime(String showTime);

	int getShowId();

}
