package com.puzzles.movieticket.service;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.puzzles.movieticket.domain.Movie;
import com.puzzles.movieticket.domain.impl.MovieImpl;



@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestMovieService extends AbstractJUnit4SpringContextTests{
	@Autowired
	private MovieService movieService;
	
	@Test
	public void addAndGetMovie(){
		
			MovieImpl newMovie= new MovieImpl();
			newMovie.setMovieName("movie2");
			newMovie.setMovieLanguage("Hindi");
			newMovie.setMovieDuration(110);
			newMovie.setReleaseDate(new Date());
			
			Movie savedMovie=movieService.addMovie(newMovie);
			
			Assert.assertNotEquals(0,savedMovie.getMovieId());
			
			System.out.println("movie saved"+ savedMovie.getMovieName()+" "+savedMovie.getMovieId());
	
		
	}
	
	@Test
	public void getAllMovie(){
		
		MovieImpl newMovie= new MovieImpl();
		newMovie.setMovieName("movie3");
		newMovie.setMovieLanguage("Korean");
		newMovie.setMovieDuration(150);
		newMovie.setReleaseDate(new Date());
		
		Movie savedMovie=movieService.addMovie(newMovie);
		Assert.assertNotEquals(0,savedMovie.getMovieId());
		
		newMovie.setMovieName("movie4");
		Movie savedMovie2=movieService.addMovie(newMovie);
		Assert.assertNotEquals(0,savedMovie2.getMovieId());
		
		List<Movie> movieList=movieService.getAllCurrentMovie();
		Assert.assertTrue(movieList.size()>0);
		System.out.println("Movie List of size" + movieList.size());
		
		
	}
	
	@Test
	public void getMovieByName(){
		
		MovieImpl newMovie= new MovieImpl();
		newMovie.setMovieName("movie3");
		newMovie.setMovieLanguage("Korean");
		newMovie.setMovieDuration(150);
		newMovie.setReleaseDate(new Date());
		
		Movie savedMovie=movieService.addMovie(newMovie);
		Assert.assertNotEquals(0,savedMovie.getMovieId());
		
		List<Movie> movieList=movieService.getMovieByMovieName(savedMovie.getMovieName());
		Assert.assertTrue(movieList.size()>0);
		System.out.println("Movie List of size" + movieList.size());
		
	}
	
	

}
