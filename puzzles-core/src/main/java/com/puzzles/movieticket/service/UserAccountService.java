package com.puzzles.movieticket.service;

public interface UserAccountService {

	Boolean getUserByUserId(Long userId);

	Boolean getUserByEmailId(String emailId);

	Boolean validateUser(String emailId, String password);

}
