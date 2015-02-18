package com.puzzles.movieticket.dao;

import java.util.List;

import com.puzzles.movieticket.domain.Theater;

public interface TheaterDao {

	int addTheater(Theater theater);

	Theater getTheaterByTheaterId(int theaterId);

	List<Theater> getTheaterByTheaterName(String theaterName);

	List<Theater> getTheaterByTheaterCity(String theaterCity);

	List<Theater> getTheaterByTheaterZip(int theaterZip);

}
