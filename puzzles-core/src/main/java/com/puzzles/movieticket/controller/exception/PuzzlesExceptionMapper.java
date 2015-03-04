package com.puzzles.movieticket.controller.exception;

import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

import org.springframework.stereotype.Component;


import com.puzzles.movieticket.service.exception.PuzzlesException;

@Provider
@Component
public class PuzzlesExceptionMapper implements ExceptionMapper<PuzzlesException>{

	
	@Override
	public Response toResponse(PuzzlesException ex){
		return Response.status(Status.CONFLICT).entity(new HttpError(ex)).build();
	}
}
