package com.puzzles.movieticket.dao;

import java.util.Random;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.puzzles.movieticket.domain.User;
import com.puzzles.movieticket.domain.impl.UserImpl;



@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestUserDao extends AbstractTransactionalJUnit4SpringContextTests {
	@Autowired
	private UserDao userDao;
	
	@Test
	public void addAndGetUser(){
		UserImpl newUser = new UserImpl();
		String s1="test"+new Random().nextInt(99999);
		newUser.setFirstName("John");
		newUser.setLastName("Doe");
		newUser.setPassword("password");
		newUser.setUserEmailId(s1+"@gmail.com");
		newUser.setPhone(999999678);
		
		int  addedUserId = userDao.addUser(newUser);
		System.out.println("user added id "+addedUserId);
		System.out.println(userDao.getUserByUserId(addedUserId).toString());
		Assert.assertNotEquals(0, addedUserId);
		
		User found=userDao.getUserByUserId(addedUserId);
	//	System.out.println(found.toString());
		Assert.assertEquals(found.getUserId(), addedUserId);
		Assert.assertEquals(found.getFirstName(), newUser.getFirstName());
		Assert.assertEquals(found.getLastName(), newUser.getLastName());
		
	}

}
