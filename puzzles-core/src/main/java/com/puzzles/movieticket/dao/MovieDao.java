package com.puzzles.movieticket.dao;


import java.util.List;

import com.puzzles.movieticket.domain.Movie;

public interface MovieDao {

	int addMovie(Movie movie);

	Movie getMovieByMovieId(int movieId);

	List<Movie> getMovieByMovieName(String movieName);

	List<Movie> getAllMovie();

}
