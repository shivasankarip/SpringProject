package com.puzzles.movieticket.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.puzzles.movieticket.dao.MovieDao;
import com.puzzles.movieticket.domain.Movie;
import com.puzzles.movieticket.domain.impl.MovieImpl;


@Repository
public class MovieDaoImpl implements MovieDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public int addMovie(Movie movie){
		
		return (int) this.sessionFactory.getCurrentSession().save(movie);
	}
	
	@Override
	public Movie getMovieByMovieId(int movieId){
		return (Movie) this.sessionFactory.getCurrentSession().get(MovieImpl.class,movieId);
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public  List<Movie> getMovieByMovieName(String movieName){
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieImpl.class)
				.add(Restrictions.eq("movieName",movieName));
		List<Movie> movieList=crit.list();
		
		return movieList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Movie> getAllMovie(){
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(MovieImpl.class);		
		List<Movie> movieList=crit.list();
		
		return movieList;
		
	}

	
}




