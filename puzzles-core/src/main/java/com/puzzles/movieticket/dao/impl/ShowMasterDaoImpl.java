package com.puzzles.movieticket.dao.impl;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.puzzles.movieticket.dao.ShowMasterDao;
import com.puzzles.movieticket.domain.ShowMaster;

public class ShowMasterDaoImpl implements ShowMasterDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public List<ShowMaster> getShowDetailsByMovieId(int movieId){
		return  null;
		
	}
	
	@Override
	public List<ShowMaster> getShowDetailsByTheaterId(int theaterId){
		return  null;
		
	}

	@Override
	public ShowMaster getShowDetailsByShowId(int showId) {
		
		return null;
	}
	
	
	
}
