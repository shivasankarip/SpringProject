package com.puzzles.movieticket.utils;

import org.springframework.stereotype.Component;

@Component
public class Validator {

	private static final String REGEX_VALID_ZIP = "[0-9]{5}";
	
	public boolean validateZip(String zip){
		
		if(!zip.matches(REGEX_VALID_ZIP))
			return false;
		else
			return true;
	}
	
}
