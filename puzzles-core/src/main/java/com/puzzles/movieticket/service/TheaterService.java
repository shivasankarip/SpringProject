package com.puzzles.movieticket.service;

import java.util.List;

import com.puzzles.movieticket.domain.Theater;

public interface TheaterService {

	Theater getTheaterByTheaterId(Long theaterId);

	List<Theater> getTheaterByTheaterName(String theaterName);

	List<Theater> getTheaterByTheaterCity(String theaterCity);

	List<Theater> getTheaterByTheaterZip(int theaterZip);

}
