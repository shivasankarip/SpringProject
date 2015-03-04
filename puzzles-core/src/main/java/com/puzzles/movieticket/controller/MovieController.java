package com.puzzles.movieticket.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.puzzles.movieticket.controller.entity.HttpMovie;
import com.puzzles.movieticket.domain.Movie;
import com.puzzles.movieticket.service.MovieService;

@Path("/movies")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class MovieController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private MovieService movieService;
	
	@GET
	@Path("/")	
	public List<HttpMovie> getMovieByName(@QueryParam("movieName") String movieName){
		logger.info("getting movie by movie name:"+movieName);
		List<Movie> movie=movieService.getMovieByMovieName(movieName);
		List<HttpMovie> returnList= new ArrayList<>(movie.size());
		for(Movie found:movie){
			returnList.add(new HttpMovie(found));
		}
		return returnList ;
	}
	
	@GET
	@Path("/{movieId}")	
	public HttpMovie getMovieById(@PathParam("movieId") int movieId){
		logger.info("getting movie by movie name:"+movieId);
		Movie movie=movieService.getMovieByMovieId(movieId);
			return(new HttpMovie(movie));
	}
	
	@GET
	@Path("/currentMovies")
	public List<HttpMovie> getAllMovie(){
		
		logger.info("getting all movie:");
		List<Movie> movie=movieService.getAllCurrentMovie();
		List<HttpMovie> returnList= new ArrayList<>(movie.size());
		for(Movie found:movie){
			returnList.add(new HttpMovie(found));
		}
		return returnList ;
	}
}
