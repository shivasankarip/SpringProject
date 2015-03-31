package com.puzzles.movieticket.domain;

import java.util.Date;

public interface ShowMaster {


	void setShowId(int showId);

	Theater getTheater();

	void setTheater(Theater theater);

	Movie getMovie();

	void setMovie(Movie movie);

	Date getShowTime();

	int getShowId();

	void setShowTime(Date showTime);

	Date getShowDate();

	void setShowDate(Date showDate);

}
