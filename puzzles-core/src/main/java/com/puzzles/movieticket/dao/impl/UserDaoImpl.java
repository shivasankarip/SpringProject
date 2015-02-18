package com.puzzles.movieticket.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.puzzles.movieticket.dao.UserDao;
import com.puzzles.movieticket.domain.User;
import com.puzzles.movieticket.domain.impl.UserImpl;

@Repository
public class UserDaoImpl implements UserDao {
	
	@Autowired
    private SessionFactory sessionFactory;

	@Override
	public int addUser(User user) {
		return (int) this.sessionFactory.getCurrentSession().save(user);		
	}

	@Override
	public User getUserByUserId(int userId) {
		return (User) this.sessionFactory.getCurrentSession().get(UserImpl.class, userId);
	}
	
	@Override
	public User getUserByEmailId(String emailId){
		Criteria crit = this.sessionFactory.getCurrentSession().createCriteria(UserImpl.class)
				.add(Restrictions.eq("userEmailId",emailId));
		return (User) crit.uniqueResult();
		
		//return (User) this.sessionFactory.getCurrentSession().get(UserImpl.class, emailId);
	}

}
