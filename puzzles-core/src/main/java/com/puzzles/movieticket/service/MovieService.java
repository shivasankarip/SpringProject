package com.puzzles.movieticket.service;

import java.util.List;

import com.puzzles.movieticket.domain.Movie;

public interface MovieService {

	Movie getMovieByMovieId(Long MovieId);

	List<Movie> getAllCurrentMovie();

	List<Movie> getUpComingMovies();

	Movie getMovieByMovieName(String movieName);

}
