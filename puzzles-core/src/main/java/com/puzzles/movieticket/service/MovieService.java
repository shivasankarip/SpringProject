package com.puzzles.movieticket.service;

import java.util.List;

import com.puzzles.movieticket.domain.Movie;

public interface MovieService {

	//Movie getMovieByMovieId(Long MovieId);

	List<Movie> getAllCurrentMovie();

	List<Movie> getUpComingMovies();

	List<Movie> getMovieByMovieName(String movieName);

	Movie getMovieByMovieId(int movieId);

	Movie addMovie(Movie movie);

}
