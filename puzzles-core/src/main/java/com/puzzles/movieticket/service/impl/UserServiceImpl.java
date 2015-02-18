package com.puzzles.movieticket.service.impl;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.puzzles.movieticket.dao.UserDao;
import com.puzzles.movieticket.domain.User;
import com.puzzles.movieticket.service.UserService;

@Service

public class UserServiceImpl implements UserService{
private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public User getUserByUserId(int userId){	
		return userDao.getUserByUserId(userId);
	}
	
	@Override
	@Transactional
	public User getUserByEmailId(String emailId){
		return userDao.getUserByEmailId(emailId);
	}
	
	@Override
	@Transactional
	public Boolean isvalidUser(String emailId, String password){
		User user = getUserByEmailId(emailId);
		if(user==null || password==null){
			return false;
		}
		return user.getPassword()!=null && user.getPassword().equals(password);

		
	}
	
	@Override
	@Transactional
	public User addUser(User user){
			return getUserByUserId(userDao.addUser(user));	
	}
	

}
