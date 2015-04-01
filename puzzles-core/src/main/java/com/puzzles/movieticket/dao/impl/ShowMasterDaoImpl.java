package com.puzzles.movieticket.dao.impl;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.puzzles.movieticket.dao.ShowMasterDao;
import com.puzzles.movieticket.domain.Movie;
import com.puzzles.movieticket.domain.ShowMaster;
import com.puzzles.movieticket.domain.Theater;
import com.puzzles.movieticket.domain.impl.ShowMasterImpl;

@Repository
public class ShowMasterDaoImpl implements ShowMasterDao {

	@Autowired
    private SessionFactory sessionFactory;
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ShowMaster> getShowDetailsByMovieId(Movie movie){
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(ShowMasterImpl.class)
				.add(Restrictions.eq("movie",movie));
		List<ShowMaster> show=crit.list();
		return  show;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ShowMaster> getShowDetailsByMovieIdAndDate(Movie movie, Date date){
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(ShowMasterImpl.class)
				.add(Restrictions.eq("movie",movie))
				.add(Restrictions.eq("showDate", date));

		List<ShowMaster> show=crit.list();
		return  show;
		
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ShowMaster> getShowDetailsByTheaterId(Theater theater){
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(ShowMasterImpl.class)
				.add(Restrictions.eq("theater",theater));
		List<ShowMaster> show=crit.list();
		return  show;
	}

	@Override
	public ShowMaster getShowDetailsByShowId(int showId) {
		
		return (ShowMaster) this.sessionFactory.getCurrentSession().get(ShowMasterImpl.class,showId);
	}

	
	
}
