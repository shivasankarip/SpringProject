package com.puzzles.movieticket.controller.entity;


import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.puzzles.movieticket.domain.MovieDetails;

@XmlRootElement(name ="movieDetails")
public class HttpMovieDetails {
	@XmlElement
	public int movieId;
	@XmlElement
	public String mProductions;
	@XmlElement
	public String mDirector;
	
	@XmlElement
	public String mCast1;
	@XmlElement
	public String mCast2;
	@XmlElement
	public String mCast3;
	
	@XmlElement
	public String mSynopsis;
	
	@XmlElement
	public String mTrailer;
	

	protected HttpMovieDetails(){}
	
	public  HttpMovieDetails(MovieDetails details){
		this.movieId=details.getMovieId();
		this.mProductions=details.getmProductions();
		this.mDirector=details.getmDirector();
		this.mCast1=details.getmCast1();
		this.mCast2=details.getmCast2();
		this.mCast3=details.getmCast3();
		this.mSynopsis=details.getmSynopsis();
		this.mTrailer=details.getmTrailer();
		
	}


}
