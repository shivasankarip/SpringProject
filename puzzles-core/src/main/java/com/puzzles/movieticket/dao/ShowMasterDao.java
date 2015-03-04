package com.puzzles.movieticket.dao;

import java.util.List;

import com.puzzles.movieticket.domain.ShowMaster;

public interface ShowMasterDao {

	List<ShowMaster> getShowDetailsByMovieId(int movieId);

	List<ShowMaster> getShowDetailsByTheaterId(int theaterId);

	ShowMaster getShowDetailsByShowId(int showId);

}
