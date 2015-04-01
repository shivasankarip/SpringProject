package com.puzzles.movieticket.dao.impl;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.puzzles.movieticket.dao.MovieDetailsDao;
import com.puzzles.movieticket.domain.MovieDetails;
import com.puzzles.movieticket.domain.impl.MovieDetailsImpl;


@Repository
public class MovieDetailsDaoImpl implements MovieDetailsDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	
	@Override
	public MovieDetails getMovieDetailsByMovieId(int movieId){
		return (MovieDetails) this.sessionFactory.getCurrentSession().get(MovieDetailsImpl.class,movieId);
		
	}
}
