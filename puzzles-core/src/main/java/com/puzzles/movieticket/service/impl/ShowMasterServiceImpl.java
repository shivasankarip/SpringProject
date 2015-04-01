package com.puzzles.movieticket.service.impl;

import java.util.Date;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puzzles.movieticket.dao.ShowMasterDao;
import com.puzzles.movieticket.domain.ShowMaster;
import com.puzzles.movieticket.service.MovieService;
import com.puzzles.movieticket.service.ShowMasterService;
import com.puzzles.movieticket.service.TheaterService;
@Service
@Transactional
public class ShowMasterServiceImpl implements ShowMasterService{
	@Autowired
	private ShowMasterDao showMasterDao;
	
	@Autowired
	private MovieService movieService;
	
	@Autowired
	private TheaterService theaterService;
	
	@Override
	public ShowMaster getShowDetailsByShowId(int showId){
		return  showMasterDao.getShowDetailsByShowId(showId);
		
	}
	
	@Override
	public List<ShowMaster> getShowDetailsByMovieId(int movieId){
		return  showMasterDao.getShowDetailsByMovieId(movieService.getMovieByMovieId(movieId));
		
	}
	
	@Override
	public List<ShowMaster> getShowDetailsByMovieIdAndDate(int movieId,Date dateO){
	
		return  showMasterDao.getShowDetailsByMovieIdAndDate(movieService.getMovieByMovieId(movieId),dateO);
		
	}
	
	@Override
	public List<ShowMaster> getShowDetailsByTheaterId(int theaterId){
		return  showMasterDao.getShowDetailsByTheaterId(theaterService.getTheaterByTheaterId(theaterId));
		
	}
	
	
	
	
}
