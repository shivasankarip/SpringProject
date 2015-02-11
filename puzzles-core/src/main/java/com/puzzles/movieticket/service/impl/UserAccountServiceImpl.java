package com.puzzles.movieticket.service.impl;

import org.springframework.stereotype.Service;

import com.puzzles.movieticket.service.UserAccountService;

@Service
public class UserAccountServiceImpl implements UserAccountService{
	@Override
	public Boolean getUserByUserId(Long userId){
		System.out.println("Test for user by userId---");
		if(userId!= null){
			if(userId==100){
				System.out.println("Welcome user 100 \n Hi User1!!");
			}else
				System.out.println("Invalid User");
		}
		
		return true;
	}
	
	@Override
	public Boolean getUserByEmailId(String emailId){
		System.out.println("Test for user by Email Id---");
		if(!emailId.isEmpty()){
			if(emailId.equalsIgnoreCase("user1@gmail.com"))
				System.out.println("vaild email: "+emailId);
			else 
				System.out.println("Invalid email :" +emailId); 
		}
		return true;
	}
	
	@Override
	public Boolean validateUser(String emailId, String password){
		System.out.println("Test for user by userId and password---");
		if(!emailId.isEmpty()&& !password.isEmpty()){
			if(emailId.equalsIgnoreCase("user1@gmail.com") && password.equals("qwerty"))
			System.out.println("corrent credentials! login successful");
		else
			System.out.println("Invalid credetials");
		}
		return true;
	}
	
	
	

}
