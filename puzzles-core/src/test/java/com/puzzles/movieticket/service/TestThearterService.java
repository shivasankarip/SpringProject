package com.puzzles.movieticket.service;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.puzzles.movieticket.domain.Theater;
import com.puzzles.movieticket.domain.impl.TheaterImpl;



@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestThearterService extends AbstractJUnit4SpringContextTests {
	//private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private TheaterService theaterService;
	

	
	@Test
	public void addAndGetTheater(){
		TheaterImpl newTheater= new TheaterImpl();
		newTheater.setTheaterName("Amc");
		newTheater.setScreenNo(10);
		newTheater.setTheaterAddressLine("Line 1");
		newTheater.setTheaterCity("city1");
		newTheater.setTheaterState("CA");
		newTheater.setTheaterZip(94085);
		newTheater.setHelpLineNo(12345678);

		
		Theater savedTheater=theaterService.addTheater(newTheater);
		Assert.assertNotEquals(0,savedTheater.getTheaterId());
		System.out.println("Theater added" +savedTheater.getTheaterName());

	}
	
	@Test
	public void getTheaterByNameTest(){
		
		TheaterImpl newTheater= new TheaterImpl();
		newTheater.setTheaterName("Theater");
		newTheater.setScreenNo(10);
		newTheater.setTheaterAddressLine("Line 1");
		newTheater.setTheaterCity("city5");
		newTheater.setTheaterState("CA");
		newTheater.setTheaterZip(94085);
		newTheater.setHelpLineNo(12345678);
		
		Theater savedTheater=theaterService.addTheater(newTheater);
		Assert.assertNotEquals(0,savedTheater.getTheaterId());
		
		List<Theater> theaterList = theaterService.getTheaterByTheaterName(savedTheater.getTheaterName());
		Assert.assertTrue(theaterList.size()>0);
		System.out.println("Get theater by name List size:"+theaterList.size());
		
	}

	
	

}
