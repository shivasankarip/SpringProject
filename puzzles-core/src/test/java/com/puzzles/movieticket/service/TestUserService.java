package com.puzzles.movieticket.service;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.puzzles.movieticket.domain.User;
import com.puzzles.movieticket.domain.impl.UserImpl;


@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestUserService extends AbstractJUnit4SpringContextTests {
	private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;

	
	@Test
	public void testPassword(){
		UserImpl newUser = new UserImpl();
		String s1="test"+new Random().nextInt(99999);
		newUser.setFirstName("John");
		newUser.setLastName("Doe");
		newUser.setPassword("password");
		newUser.setUserEmailId(s1+"@gmail.com");
		newUser.setPhone(123999678);
		
		User addedUser = userService.addUser(newUser);
		Assert.assertEquals(false, userService.isvalidUser(addedUser.getUserEmailId(), "word"));
		Assert.assertEquals(false, userService.isvalidUser(addedUser.getUserEmailId(), "PASSWORD"));
		Assert.assertEquals(false, userService.isvalidUser(addedUser.getUserEmailId(), "password1"));
		Assert.assertEquals(true, userService.isvalidUser(addedUser.getUserEmailId(), "password"));
		
	}
	
	@Test
	public void addAndGetUser(){
		UserImpl newUser = new UserImpl();
		String s1="test"+new Random().nextInt(99999);
		newUser.setFirstName("Jane");
		newUser.setLastName("Doe");
		newUser.setPassword("password");
		newUser.setUserEmailId(s1+"@gmail.com");
		newUser.setPhone(1234568678);
		
		User  addedUser = userService.addUser(newUser);
		logger.info("user added "+addedUser.toString());
		Assert.assertNotEquals(0, addedUser.getUserId());
		
		User found=userService.getUserByUserId(addedUser.getUserId());
		Assert.assertEquals(found.getUserId(), addedUser.getUserId());
		Assert.assertEquals(found.getFirstName(), addedUser.getFirstName());
		Assert.assertEquals(found.getLastName(), addedUser.getLastName());
		Assert.assertEquals(found.getUserEmailId(), addedUser.getUserEmailId());
		
	}
}
