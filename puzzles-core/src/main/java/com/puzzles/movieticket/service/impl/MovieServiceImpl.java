package com.puzzles.movieticket.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puzzles.movieticket.dao.MovieDao;
import com.puzzles.movieticket.domain.Movie;
import com.puzzles.movieticket.service.MovieService;
import com.puzzles.movieticket.service.exception.InvalidFieldException;

@Service
@Transactional
public class MovieServiceImpl implements MovieService{
	
	@Autowired
	private MovieDao movieDao;
	
	@Override
	public Movie getMovieByMovieId(int movieId)
	{
		Movie found= movieDao.getMovieByMovieId(movieId);
		if(found==null){
			throw new InvalidFieldException("movie not found"+ movieId);
		}
		return found;
		
	}
	
	
	
	@Override
	public Movie addMovie(Movie movie){
		return getMovieByMovieId(movieDao.addMovie(movie));
	}
	
	@Override
	public List<Movie> getAllCurrentMovie(){
		return movieDao.getAllMovie();
		
	}
	
	@Override
	public List<Movie> getUpComingMovies(){
		return null;
		
	}
	
	@Override
	public List<Movie>getMovieByMovieName(String movieName){
		return movieDao.getMovieByMovieName(movieName);
		
	}
}
