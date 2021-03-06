package com.puzzles.movieticket.controller.entity;

import java.util.Date;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.puzzles.movieticket.domain.ShowMaster;

@XmlRootElement(name ="show")
public class HttpShow {

	@XmlElement
	public int showId;
	
	@XmlElement
	public HttpTheater theater;
	
	@XmlElement
	public HttpMovie movie;
	
	@XmlElement
	public Date showDate;
	
	@XmlElement
	public Date showTime;
	
	@XmlElement
	public int ticketsAvail;
	
	protected HttpShow(){}
	
	public HttpShow(ShowMaster show){
		this.showId=show.getShowId();
		this.theater=new HttpTheater(show.getTheater());
		this.movie=new HttpMovie(show.getMovie());
		this.showDate=show.getShowDate();
		this.showTime=show.getShowTime();
		this.ticketsAvail=show.getTicketsAvail();
	}
	
 
}
