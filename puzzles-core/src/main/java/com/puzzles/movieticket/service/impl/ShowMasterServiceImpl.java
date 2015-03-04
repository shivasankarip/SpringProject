package com.puzzles.movieticket.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.puzzles.movieticket.dao.ShowMasterDao;
import com.puzzles.movieticket.domain.ShowMaster;
import com.puzzles.movieticket.service.ShowMasterService;

public class ShowMasterServiceImpl implements ShowMasterService{
	@Autowired
	private ShowMasterDao showMasterDao;
	
	@Override
	public ShowMaster getShowDetailsByShowId(int showId){
		return  showMasterDao.getShowDetailsByShowId(showId);
		
	}
	
	@Override
	public List<ShowMaster> getShowDetailsByMovieId(int movieId){
		return  showMasterDao.getShowDetailsByMovieId(movieId);
		
	}
	
	@Override
	public List<ShowMaster> getShowDetailsByTheaterId(int theaterId){
		return  showMasterDao.getShowDetailsByTheaterId(theaterId);
		
	}
	
	
}
