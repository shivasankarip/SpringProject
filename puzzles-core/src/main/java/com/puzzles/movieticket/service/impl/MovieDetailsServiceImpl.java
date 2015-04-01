package com.puzzles.movieticket.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puzzles.movieticket.dao.MovieDetailsDao;
import com.puzzles.movieticket.domain.Movie;
import com.puzzles.movieticket.domain.MovieDetails;
import com.puzzles.movieticket.service.MovieDetailsService;
import com.puzzles.movieticket.service.exception.InvalidFieldException;


@Service
@Transactional
public class MovieDetailsServiceImpl implements MovieDetailsService{

	@Autowired
	private MovieDetailsDao detailsDao;
	
	@Override
	public MovieDetails getMovieDetailsByMovieId(int movieId)
	{
		MovieDetails found= detailsDao.getMovieDetailsByMovieId(movieId);
		if(found==null){
			throw new InvalidFieldException("movie details not found"+ movieId);
		}
		return found;
		
	}
	
}
