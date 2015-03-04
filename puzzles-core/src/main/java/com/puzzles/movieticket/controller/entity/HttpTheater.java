package com.puzzles.movieticket.controller.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.puzzles.movieticket.domain.Theater;


@XmlRootElement(name ="theater")
public class HttpTheater {

	@XmlElement
	 public int theaterId;
	
	@XmlElement
	public String theaterName;
	
	@XmlElement
	public String theaterAddressLine;
	
	@XmlElement
	public String theaterCity;
	
	@XmlElement
	public int theaterZip;
	
	@XmlElement
	public String theaterState;
	
	@XmlElement
	public int helpLineNo;
	
	@XmlElement
	public int screenNo;
	
	protected HttpTheater(){}
	
	public HttpTheater(Theater theater){
		
		this.theaterId=theater.getTheaterId();
		this.theaterName=theater.getTheaterName();
		this.theaterAddressLine=theater.getTheaterAddressLine();
		this.theaterCity=theater.getTheaterCity();
		this.theaterState=theater.getTheaterState();
		this.theaterZip=theater.getTheaterZip();
		this.helpLineNo=theater.getHelpLineNo();
		this.screenNo=theater.getScreenNo();
		
		
	}
	
}
