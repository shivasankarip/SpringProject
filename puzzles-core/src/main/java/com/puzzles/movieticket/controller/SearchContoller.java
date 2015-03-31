package com.puzzles.movieticket.controller;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import com.puzzles.movieticket.controller.entity.HttpMovie;
import com.puzzles.movieticket.controller.entity.HttpSearch;
import com.puzzles.movieticket.controller.entity.HttpTheater;
import com.puzzles.movieticket.service.exception.InvalidFieldException;
import com.puzzles.movieticket.utils.Validator;


@Path("/search")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class SearchContoller {

	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	public MovieController movie;
	@Autowired
	public TheaterController theater;
	
	@Autowired
	public Validator validate;
	
	
	@GET
	@Path("/")
	@Wrapped(element = "searchResult")
	public @ResponseBody String getSearchResults(@QueryParam("searchText") String searchText) throws ParseException  {
		JSONObject json = new JSONObject();
		if (searchText == null) {
			throw new InvalidFieldException("Search text is empty");
		} else {
			logger.info("searching movie and theater by the search text:"+ searchText);
			if (!searchText.isEmpty() && searchText != null) {
				List<HttpMovie> hmovieResultList = movie.getMovieByName(searchText);
				List<HttpTheater> htheaterResultList = theater.getTheaterByName(searchText);
				htheaterResultList.addAll(theater.getTheaterByCity(searchText));

				if (validate.validateZip(searchText)) {
					htheaterResultList.addAll(theater.getTheaterByZip(Integer.parseInt(searchText)));
				}
				if((hmovieResultList.size()==0) && (htheaterResultList.size()==0)){
					logger.info("No search results for the given text :"+ searchText);
					throw new InvalidFieldException("No search results for the given text :" + searchText);
				}
				
				JSONArray movieArray=new JSONArray();
				
				for(HttpMovie hmovie: hmovieResultList){
					
					JSONObject movieObj=new JSONObject();
					SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
					Date date =sdf.parse(sdf.format(hmovie.releaseDate));
					
					
					movieObj.put("ID", hmovie.movieId);
					movieObj.put("name", hmovie.movieName);
					movieObj.put("duration",hmovie.movieDuration);
					movieObj.put("Language", hmovie.movieLanguage);
					movieObj.put("releaseDate",date);
					movieObj.put("poster",hmovie.moviePoster);
					
					 movieArray.add(movieObj);
				}
				json.put("Movie", movieArray);
				
				JSONArray theaterArray=new JSONArray();
				
				for(HttpTheater htheater: htheaterResultList){
					JSONObject theaterObj=new JSONObject();
					
					theaterObj.put("ID", htheater.theaterId);
					theaterObj.put("name", htheater.theaterName);
					theaterObj.put("Address", htheater.theaterAddressLine);
					theaterObj.put("city", htheater.theaterCity);
					theaterObj.put("Zip", htheater.theaterZip);
					
					theaterArray.add(theaterObj);
				}
				
				json.put("Theater", theaterArray);
				
				
			}
		}
		return json.toString();

	}
	
	
	
/*	public List<HttpSearch> getSearchResults(@QueryParam("searchText") String searchText){
		logger.info("searching movie and theater by the search text:"+ searchText);
		List<HttpSearch> searchList = new ArrayList<HttpSearch>();
		if (!searchText.isEmpty() && searchText != null) {
			List<HttpMovie> hmovie = movie.getMovieByName(searchText);
			List<HttpTheater> hTheater = theater.getTheaterByName(searchText);
			hTheater.addAll(theater.getTheaterByCity(searchText));

			if (validate.validateZip(searchText)) {
				hTheater.addAll(theater.getTheaterByZip(Integer.parseInt(searchText)));
			}

			if (!hmovie.isEmpty()) {
				for (HttpMovie mfound : hmovie) {
					searchList.add(new HttpSearch(mfound));
				}
			} else
				logger.info("No movie results for the given text :"+ searchText);
			if (!hTheater.isEmpty()) {
				for (HttpTheater tfound : hTheater) {
					searchList.add(new HttpSearch(tfound));
				}
			} else
				logger.info("No theater results for the given text :"+ searchText);
			if (searchList.isEmpty()) {
				logger.info("No search results for the given text :"+ searchText);
				throw new InvalidFieldException("No search results for the given text :" + searchText);
			}

		}
		return searchList;
		
	}*/
}
