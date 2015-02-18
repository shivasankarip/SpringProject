package com.puzzles.movieticket.dao.impl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.puzzles.movieticket.dao.TheaterDao;
import com.puzzles.movieticket.domain.Theater;
import com.puzzles.movieticket.domain.impl.TheaterImpl;



@Repository
public class TheaterDaoImpl implements TheaterDao {
	
	@Autowired
    private SessionFactory sessionFactory;
	
	@Override
	public int addTheater(Theater theater){
		
		return (int) this.sessionFactory.getCurrentSession().save(theater);
	}
	
	@Override
	public Theater getTheaterByTheaterId(int theaterId){
		return (Theater) this.sessionFactory.getCurrentSession().get(TheaterImpl.class,theaterId);
		
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public  List<Theater> getTheaterByTheaterName(String theaterName){
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class)
				.add(Restrictions.eq("theaterName",theaterName));
		List<Theater> theaterList=crit.list();
		return theaterList;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public  List<Theater> getTheaterByTheaterCity(String theaterCity){
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class)
				.add(Restrictions.eq("theaterCity",theaterCity));
		List<Theater> theaterList=crit.list();
		return theaterList;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public  List<Theater> getTheaterByTheaterZip(int theaterZip){
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(TheaterImpl.class)
				.add(Restrictions.eq("theaterZip",theaterZip));
		List<Theater> theaterList=crit.list();
		return theaterList;
	}


}
