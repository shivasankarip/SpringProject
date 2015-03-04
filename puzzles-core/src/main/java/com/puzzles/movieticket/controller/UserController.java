package com.puzzles.movieticket.controller;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.puzzles.movieticket.controller.entity.HttpUser;
import com.puzzles.movieticket.domain.User;
import com.puzzles.movieticket.domain.impl.UserImpl;
import com.puzzles.movieticket.service.UserService;



@Path("/users")
@Component
@Consumes({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
public class UserController {

	
private Logger logger = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private UserService userService;
	
	@POST
	@Path("/")
	public Response createUser(HttpUser newUser){
		User userToCreate = convert(newUser);
		User addedUser = userService.addUser(userToCreate);
		return Response.status(Status.CREATED).header("Location", "/users/"+addedUser.getUserId()).entity(new HttpUser(addedUser)).build();
	}
	
	
	@GET
	@Path("/{userId}")	
	public HttpUser getUserById(@PathParam("userId") int userId){
		logger.info("getting user by id:"+userId);
		User user = userService.getUserByUserId(userId);	
		return new HttpUser(user);
	}
		
	private User convert(HttpUser httpUser) {
		UserImpl user = new UserImpl();
		user.setUserEmailId(httpUser.emailId);
		user.setPassword(httpUser.password);
		user.setFirstName(httpUser.firstName);
		user.setLastName(httpUser.lastName);
		user.setPhone(httpUser.phone);
		return user;
	}	
}
