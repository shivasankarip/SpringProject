package com.puzzles.movieticket.service.exception;


@SuppressWarnings("serial")
public class InvalidFieldException extends PuzzlesException {

	public InvalidFieldException(String message, Throwable throwable) {
		super(ErrorCode.INVALID_FIELD, message, throwable);
	}
	
	public InvalidFieldException(String message) {
		super(ErrorCode.INVALID_FIELD, message);
	}

}
