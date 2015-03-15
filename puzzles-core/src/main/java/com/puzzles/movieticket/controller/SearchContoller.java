package com.puzzles.movieticket.controller;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.jboss.resteasy.annotations.providers.jaxb.Wrapped;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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
	@Wrapped(element="searchResult")
	public List<HttpSearch> getSearchResults(@QueryParam("searchText") String searchText){
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
		
	}
}
