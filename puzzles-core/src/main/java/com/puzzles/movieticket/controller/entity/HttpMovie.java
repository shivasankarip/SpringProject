package com.puzzles.movieticket.controller.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.puzzles.movieticket.domain.Movie;

@XmlRootElement(name ="movie")
public class HttpMovie {

	@XmlElement
	public int movieId;
	
	@XmlElement
	public String movieName;
	
	@XmlElement
	public  String movieLanguage;
	
	@XmlElement
	public Date releaseDate;
	
	@XmlElement
	public int movieDuration;
	
	@XmlElement
	public String moviePoster;
	
	protected HttpMovie(){}
	
	public HttpMovie(Movie movie){
		this.movieId=movie.getMovieId();
		this.movieName=movie.getMovieName();
		this.movieLanguage=movie.getMovieLanguage();
		this.releaseDate=movie.getReleaseDate();
		this.movieDuration=movie.getMovieDuration();
		this.moviePoster=movie.getMoviePoster(); 
	}
	
}
