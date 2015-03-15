package com.puzzles.movieticket.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.puzzles.movieticket.controller.entity.HttpShow;
import com.puzzles.movieticket.controller.entity.HttpTheater;
import com.puzzles.movieticket.domain.ShowMaster;
import com.puzzles.movieticket.service.ShowMasterService;

@Path("/show")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class ShowController {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired 
	private ShowMasterService showService;
	
	@GET
	@Path("/{showId}")
	public HttpShow getShow(@PathParam("showId") int showId){
		logger.info("getting show by showId" +showId);
		ShowMaster show=showService.getShowDetailsByShowId(showId);
		return (new HttpShow(show));
	}
	
	@GET
	@Path("/movie/{movieId}")
	public List<HttpShow> getShowByMovieId(@PathParam("movieId") int movieId){
		logger.info("getting Show details by movie id"+ movieId);
		List<ShowMaster> showList=showService.getShowDetailsByMovieId(movieId);
		List<HttpShow> tempList=new ArrayList<HttpShow>(showList.size());
		for(ShowMaster found:showList){
			tempList.add(new HttpShow(found));
		}
		return tempList;
	}
	
	@GET
	@Path("/theater/{theaterId}")
	public List<HttpShow> getTheaterByTheaterId(@PathParam("theaterId") int theaterId){
		logger.info("getting Show details by theater id"+ theaterId);
		List<ShowMaster> showList=showService.getShowDetailsByTheaterId(theaterId);
		List<HttpShow> tempList=new ArrayList<HttpShow>(showList.size());
		for(ShowMaster found:showList){
			tempList.add(new HttpShow(found));
		}
		return tempList;
	}
}
