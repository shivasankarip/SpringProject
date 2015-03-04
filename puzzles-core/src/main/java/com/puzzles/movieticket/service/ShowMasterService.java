package com.puzzles.movieticket.service;

import java.util.List;

import com.puzzles.movieticket.domain.ShowMaster;

public interface ShowMasterService {

	List<ShowMaster> getShowDetailsByMovieId(int movieId);

	List<ShowMaster> getShowDetailsByTheaterId(int theaterId);

	ShowMaster getShowDetailsByShowId(int showId);

}
