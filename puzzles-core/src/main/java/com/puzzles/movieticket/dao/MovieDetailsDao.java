package com.puzzles.movieticket.dao;

import com.puzzles.movieticket.domain.MovieDetails;

public interface MovieDetailsDao {

	MovieDetails getMovieDetailsByMovieId(int movieId);

}
