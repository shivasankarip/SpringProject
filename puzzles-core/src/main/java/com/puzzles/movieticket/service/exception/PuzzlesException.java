package com.puzzles.movieticket.service.exception;


@SuppressWarnings("serial")
public class PuzzlesException  extends RuntimeException {

	
	private ErrorCode errorCode;
	
	public PuzzlesException(ErrorCode code, String message, Throwable throwable) {
		super(message, throwable);
		this.errorCode = code;
	}
	
	public PuzzlesException(ErrorCode code, String message) {
		super(message);
		this.errorCode = code;
	}

	public ErrorCode getErrorCode() {
		return errorCode;
	}
}
