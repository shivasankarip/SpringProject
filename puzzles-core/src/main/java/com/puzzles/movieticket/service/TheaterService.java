package com.puzzles.movieticket.service;

import java.util.List;

import com.puzzles.movieticket.domain.Theater;

public interface TheaterService {

	List<Theater> getTheaterByTheaterName(String theaterName);

	List<Theater> getTheaterByTheaterCity(String theaterCity);

	List<Theater> getTheaterByTheaterZip(int theaterZip);

	Theater getTheaterByTheaterId(int theaterId);

	Theater addTheater(Theater theater);

}
