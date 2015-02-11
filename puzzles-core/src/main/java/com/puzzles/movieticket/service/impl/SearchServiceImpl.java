package com.puzzles.movieticket.service.impl;

import org.springframework.stereotype.Service;

import com.puzzles.movieticket.service.SearchService;

@Service
public class SearchServiceImpl implements SearchService{
	
	@Override
	public Boolean getSearchResults(String searchText){
		System.out.println("Test for search---");
		@SuppressWarnings("unused")
		String fieldName=null;
		//search in theater and movie for the string match
		if(!searchText.isEmpty()){
		if(searchText.equalsIgnoreCase("movie1"))
		{
			fieldName="Movie";
			System.out.println("Search results: \n"+searchText+"--- from field movie");
		}else if(searchText.equalsIgnoreCase("Theater1"))
		{
			fieldName="Theater";
			System.out.println("Search results: \n"+searchText+"--- from field Theater");
		
		}else
			System.out.println("no results found in the database for "+searchText);
		}	
		return true;	
		
	}

}
