package com.puzzles.movieticket.dao;

import java.util.List;

import com.puzzles.movieticket.domain.Movie;
import com.puzzles.movieticket.domain.ShowMaster;
import com.puzzles.movieticket.domain.Theater;

public interface ShowMasterDao {

	List<ShowMaster> getShowDetailsByMovieId(Movie movie);

	List<ShowMaster> getShowDetailsByTheaterId(Theater theater);

	ShowMaster getShowDetailsByShowId(int showId);

}
