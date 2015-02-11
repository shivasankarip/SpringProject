package com.puzzles.movieticket.test;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

import com.puzzles.movieticket.service.UserAccountService;

@ContextConfiguration(locations = {"classpath:spring-context.xml"})
public class TestUserAccountService extends AbstractJUnit4SpringContextTests{
	
	@Autowired
	private UserAccountService userAccountService;
	@Test
	public void testUserId(){
		Assert.assertEquals(true,userAccountService.getUserByUserId((long) 100));
		Assert.assertEquals(true,userAccountService.getUserByUserId((long) 10));
		
	}
	
	@Test
	public void testUserEmail(){
		Assert.assertEquals(true,userAccountService.getUserByEmailId("user1@gmail.com"));
		Assert.assertEquals(true,userAccountService.getUserByEmailId("user1"));
		
		
	}
	
	@Test
	public void testValidUser(){
		
		Assert.assertEquals(true,userAccountService.validateUser("user1@gmail.com", "qwerty"));
		Assert.assertEquals(true,userAccountService.validateUser("user1@gmail.cm", "test"));
	}

}
