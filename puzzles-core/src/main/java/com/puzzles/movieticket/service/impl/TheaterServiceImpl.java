package com.puzzles.movieticket.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puzzles.movieticket.dao.TheaterDao;
import com.puzzles.movieticket.domain.Theater;
import com.puzzles.movieticket.service.TheaterService;
import com.puzzles.movieticket.service.exception.InvalidFieldException;

@Service
@Transactional
public class TheaterServiceImpl implements TheaterService{
	
	@Autowired
	private TheaterDao theaterDao;
	
	@Override
	public Theater getTheaterByTheaterId(int theaterId){
		Theater found= theaterDao.getTheaterByTheaterId(theaterId);
		if(found==null){
			throw new InvalidFieldException("theater not found for id : "+ theaterId);
		}
		return found;
	}
	
	@Override
	public Theater addTheater(Theater theater){
		return getTheaterByTheaterId(theaterDao.addTheater(theater));
	}
	
	@Override
	public List<Theater> getTheaterByTheaterName(String theaterName){
		List<Theater> found= theaterDao.getTheaterByTheaterName(theaterName);
		if(found.size()==0){
			throw new InvalidFieldException("theater not found for name :"+ theaterName);
		}
		return found;
	}
	
	@Override
	public List<Theater> getTheaterByTheaterCity(String theaterCity){
		List<Theater> found= theaterDao.getTheaterByTheaterCity(theaterCity);
		if(found.size()==0){
			throw new InvalidFieldException("theater not found for city :"+ theaterCity);
		}
		return found;
	}

	@Override
	public List<Theater> getTheaterByTheaterZip(int theaterZip){
		List<Theater> found= theaterDao.getTheaterByTheaterZip(theaterZip);
		if(found.size()==0){
			throw new InvalidFieldException("theater not found for zip :"+ theaterZip);
		}
		return found;
	}
	


}
