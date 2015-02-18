package com.puzzles.movieticket.dao;

import java.util.Date;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.puzzles.movieticket.domain.Movie;
import com.puzzles.movieticket.domain.impl.MovieImpl;



@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestMovieDao extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private MovieDao movieDao;
	
	@Test
	public void addAndGetMovie(){
		MovieImpl newMovie= new MovieImpl();
		newMovie.setMovieName("movie1");
		newMovie.setMovieLanguage("English");
		newMovie.setMovieDuration(125);
		newMovie.setReleaseDate(new Date());
		
		int id=movieDao.addMovie(newMovie);
		Movie savedMovie=movieDao.getMovieByMovieId(id);
		Assert.assertNotEquals(0,savedMovie.getMovieId());
		System.out.println("movie saved"+ savedMovie.getMovieName()+" "+savedMovie.getMovieId());
		
	}

}
