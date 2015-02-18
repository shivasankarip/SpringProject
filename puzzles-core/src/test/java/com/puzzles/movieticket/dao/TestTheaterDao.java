package com.puzzles.movieticket.dao;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.puzzles.movieticket.domain.Theater;
import com.puzzles.movieticket.domain.impl.TheaterImpl;


@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestTheaterDao extends AbstractTransactionalJUnit4SpringContextTests  {
	
	@Autowired
	private TheaterDao theaterDao;
	
	@Test
	public void addAndGetTheater(){
		
		TheaterImpl newTheater= new TheaterImpl();
		newTheater.setTheaterName("Matrix");
		newTheater.setScreenNo(10);
		newTheater.setTheaterAddressLine("Line 2");
		newTheater.setTheaterCity("city2");
		newTheater.setTheaterState("CA");
		newTheater.setTheaterZip(94053);
		newTheater.setHelpLineNo(88888878);
		
		int id =theaterDao.addTheater(newTheater);
		Theater savedTheater=theaterDao.getTheaterByTheaterId(id);
		Assert.assertNotEquals(0,savedTheater.getTheaterId());
		System.out.println("Theater saved through Dao :"+ savedTheater.getTheaterName());
		
	}
	
	

}
