package com.puzzles.movieticket.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
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
import com.puzzles.movieticket.controller.entity.HttpMovieDetails;
import com.puzzles.movieticket.domain.Movie;
import com.puzzles.movieticket.domain.MovieDetails;
import com.puzzles.movieticket.service.MovieDetailsService;
import com.puzzles.movieticket.service.MovieService;

@Path("/movies")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class MovieController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	

	@Autowired
	private MovieService movieService;
	
	@Autowired
	private MovieDetailsService detailsService;
	
	//@GET
	//@Path("/")	
	//public List<HttpMovie> getMovieByName(@QueryParam("movieName") String movieName){
	public List<HttpMovie> getMovieByName(String movieName){

		logger.info("getting movie by movie name:"+movieName);
		movieName=movieName.toUpperCase();
		List<Movie> movie=movieService.getMovieByMovieName(movieName);
		List<HttpMovie> returnList= new ArrayList<>(movie.size());
		for(Movie found:movie){
			returnList.add(new HttpMovie(found));
			logger.info("getting movie by movie name:"+movieName);
		}
		return returnList ;
	}
	
	@GET
	@Path("/")	
	public HttpMovieDetails getMovieDetailsById(@QueryParam("movieId") int movieId){
		logger.info("getting movie details by movie Id:"+movieId);
		MovieDetails movie=detailsService.getMovieDetailsByMovieId(movieId);
		
			return(new HttpMovieDetails(movie));
	}
	
	
	
	@GET
	@Path("/currentMovies")
	public List<HttpMovie> getAllMovie() throws ParseException{
		
		logger.info("getting all movie:");
		List<Movie> movie=movieService.getAllCurrentMovie();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today =sdf.parse(sdf.format(new Date()));
		List<HttpMovie> returnList= new ArrayList<>(movie.size());
		for(Movie found:movie){
			Date movieDate=sdf.parse(sdf.format(found.getReleaseDate()));
			if(movieDate.before(today) || movieDate.equals(today)){
					returnList.add(new HttpMovie(found));
			}
		}
		return returnList ;
	}
	
	
	@GET
	@Path("/upComingMovies")
	public List<HttpMovie> getUpComingMovie() throws ParseException{
		
		logger.info("getting up coming movie:");
		List<Movie> movie=movieService.getAllCurrentMovie();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today =sdf.parse(sdf.format(new Date()));
		//SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date()); // Now use today date.
		c.add(Calendar.DATE, 7); // Adding 7 days
		Date weeklater=sdf.parse(sdf.format(c.getTime()));
		List<HttpMovie> returnList= new ArrayList<>(movie.size());
		for(Movie found: movie){
			Date movieDate=sdf.parse(sdf.format(found.getReleaseDate()));
			if(movieDate.before(weeklater) && movieDate.after(today) ){
				//if(movieDate.compareTo(today)< 7)
					returnList.add(new HttpMovie(found));
			}
		
		}
		return returnList ;
	}
	
	@GET
	@Path("/comingSoonMovies")
	public List<HttpMovie> comingSoonMovie() throws ParseException{
		
		logger.info("getting all movie:");
		List<Movie> movie=movieService.getAllCurrentMovie();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date today =sdf.parse(sdf.format(new Date()));
		List<HttpMovie> returnList= new ArrayList<>(movie.size());
		for(Movie found: movie){
			Date movieDate=sdf.parse(sdf.format(found.getReleaseDate()));
			if(movieDate.after(today)){
					returnList.add(new HttpMovie(found));
			}
		
		}
		return returnList ;
	}
	
	
	
	
	
}
