package com.puzzles.movieticket.dao;

import com.puzzles.movieticket.domain.User;

public interface UserDao {

	int addUser(User user);

	User getUserByUserId(int userId);

	User getUserByEmailId(String emailId);


}
