package com.puzzles.movieticket.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import com.puzzles.movieticket.dao.UserDao;
import com.puzzles.movieticket.domain.User;
import com.puzzles.movieticket.service.UserService;
import com.puzzles.movieticket.service.exception.InvalidFieldException;

@Service

public class UserServiceImpl implements UserService{
	
	private static final int MAX_NAME_LENGTH = 45;
	
	private static final int MAX_PASSWORD_LENGTH = 15;
	
	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public User getUserByUserId(int userId){	
		
		User found= userDao.getUserByUserId(userId);
		if(found==null){
			throw new InvalidFieldException("user not found"+ userId);
		}
		return found;
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
		if(StringUtils.isEmpty(user.getPassword()) || user.getPassword().length()>MAX_PASSWORD_LENGTH){			
			throw new InvalidFieldException("pin is required");
		}
		
		if(StringUtils.isEmpty(user.getFirstName()) || user.getFirstName().length()>MAX_NAME_LENGTH){			
			throw new InvalidFieldException("firstName is required");
		}
		
		if(StringUtils.isEmpty(user.getLastName()) || user.getLastName().length()>MAX_NAME_LENGTH){			
			throw new InvalidFieldException("lastName is required");
		}
		
		if(StringUtils.isEmpty(user.getUserEmailId())){			
			throw new InvalidFieldException("Email is required");
		}
			return getUserByUserId(userDao.addUser(user));	
	}
	

}
