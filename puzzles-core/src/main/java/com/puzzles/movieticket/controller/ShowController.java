package com.puzzles.movieticket.controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

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
	@Path("/")
	public List<HttpShow> getShowByMovieId(@QueryParam("movieId") int movieId) throws ParseException {
		List<HttpShow> showList=getShowDetails(movieId);
		return showList;
	
	}
	
	@GET
	@Path("/theater")
	public List<HttpShow> getTheaterByTheaterId(@QueryParam("theaterId") int theaterId){
		logger.info("getting Show details by theater id"+ theaterId);
		List<ShowMaster> showList=showService.getShowDetailsByTheaterId(theaterId);
		List<HttpShow> tempList=new ArrayList<HttpShow>(showList.size());
		for(ShowMaster found:showList){
			tempList.add(new HttpShow(found));
		}
		return tempList;
	}
	
	public List<HttpShow>  getShowDetails(int movieId) throws ParseException{
		logger.info("getting Show details by movie id"+ movieId);
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(sdf.format(new Date()));
		
		List<ShowMaster> showList=showService.getShowDetailsByMovieId(movieId);
		List<HttpShow> tempList=new ArrayList<HttpShow>(showList.size());
		for(ShowMaster found:showList){
			tempList.add(new HttpShow(found));
		}
		return tempList;
		
		
	}
	
	public Date validateDate(Date date){
		DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
		
	}
	
	public Date validateTime(Date date){
		DateFormat sdf = new SimpleDateFormat("HH:MM");
		try {
			date = sdf.parse(sdf.format(date));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return date;
		
	}
}
