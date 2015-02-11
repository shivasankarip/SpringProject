package com.puzzles.movieticket.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.puzzles.movieticket.service.SearchService;



@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestSearchService extends AbstractJUnit4SpringContextTests {
	@Autowired
	private SearchService searchService;
	
	@Test
	public void testSearch(){
		Assert.assertEquals(true, searchService.getSearchResults("Movie1"));
		Assert.assertEquals(true, searchService.getSearchResults("Theater1"));
		Assert.assertEquals(true, searchService.getSearchResults("some name"));
	
		
	}
	
}
