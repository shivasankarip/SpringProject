package com.puzzles.movieticket.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puzzles.movieticket.dao.TheaterDao;
import com.puzzles.movieticket.domain.Theater;
import com.puzzles.movieticket.service.TheaterService;

@Service
@Transactional
public class TheaterServiceImpl implements TheaterService{
	
	@Autowired
	private TheaterDao theaterDao;
	
	@Override
	public Theater getTheaterByTheaterId(int theaterId){
		return theaterDao.getTheaterByTheaterId(theaterId);
	}
	
	@Override
	public Theater addTheater(Theater theater){
		return getTheaterByTheaterId(theaterDao.addTheater(theater));
	}
	
	@Override
	public List<Theater> getTheaterByTheaterName(String theaterName){
		return theaterDao.getTheaterByTheaterName(theaterName);
	}
	
	@Override
	public List<Theater> getTheaterByTheaterCity(String theaterCity){
		return theaterDao.getTheaterByTheaterCity(theaterCity);
	}

	@Override
	public List<Theater> getTheaterByTheaterZip(int theaterZip){
		return theaterDao.getTheaterByTheaterZip(theaterZip);
	}
	


}
