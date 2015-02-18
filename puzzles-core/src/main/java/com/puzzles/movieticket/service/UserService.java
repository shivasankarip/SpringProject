package com.puzzles.movieticket.service;

import com.puzzles.movieticket.domain.User;

public interface UserService {


	User getUserByEmailId(String emailId);

	User addUser(User user);

	Boolean isvalidUser(String emailId, String password);

	User getUserByUserId(int userId);

}
