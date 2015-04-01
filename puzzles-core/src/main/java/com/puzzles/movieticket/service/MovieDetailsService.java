package com.puzzles.movieticket.service;

import com.puzzles.movieticket.domain.MovieDetails;



public interface MovieDetailsService {

	MovieDetails getMovieDetailsByMovieId(int movieId);

}
