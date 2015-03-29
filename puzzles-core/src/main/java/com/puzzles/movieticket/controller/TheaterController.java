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

import com.puzzles.movieticket.controller.entity.HttpTheater;
import com.puzzles.movieticket.domain.Theater;
import com.puzzles.movieticket.service.TheaterService;
import com.puzzles.movieticket.service.exception.PuzzlesException;

@Path("/theater")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class TheaterController {

private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TheaterService theaterService;
	
	
	@GET
	@Path("/{theaterId}")	
	public HttpTheater getMovieById(@PathParam("theaterId") int theaterId){
		logger.info("getting theater by theater ID:"+theaterId);
		Theater theater=theaterService.getTheaterByTheaterId(theaterId);
			return(new HttpTheater(theater));
	}
	
	/*@GET
	@Path("/")
	public List<HttpTheater> getTheaterByName(@QueryParam("theaterName") String theaterName) throws PuzzlesException{
		*/
	public List<HttpTheater> getTheaterByName(String theaterName) {
		logger.info("getting theater by name: "+theaterName);
		List<Theater> theater=theaterService.getTheaterByTheaterName(theaterName);
		List<HttpTheater> returnList= new ArrayList<>(theater.size());
		for(Theater found:theater){
			returnList.add(new HttpTheater(found));
		}
		return returnList ;
	}
	
	@GET
	@Path("/zip/{theaterZip}")
	public List<HttpTheater> getTheaterByZip(@PathParam("theaterZip") int theaterZip) throws PuzzlesException{
		
		logger.info("getting theater by zip: " +theaterZip);
		List<Theater> theater=theaterService.getTheaterByTheaterZip(theaterZip);
		List<HttpTheater> returnList= new ArrayList<>(theater.size());
		for(Theater found:theater){
			returnList.add(new HttpTheater(found));
		}
		return returnList ;
	}
	
	/*
	@GET
	@Path("/city/{theaterCity}")
	public List<HttpTheater> getTheaterByCity(@PathParam("theaterCity") String theaterCity) throws PuzzlesException{
	*/	
	public List<HttpTheater> getTheaterByCity(String theaterCity) {
		logger.info("getting theater by city :"+theaterCity);
		List<Theater> theater=theaterService.getTheaterByTheaterCity(theaterCity);
		List<HttpTheater> returnList= new ArrayList<>(theater.size());
		for(Theater found:theater){
			returnList.add(new HttpTheater(found));
		}
		return returnList ;
	}
	
}
