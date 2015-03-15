package com.puzzles.movieticket.controller.entity;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name ="search")
public class HttpSearch {
	@XmlElement	
public HttpMovie hMovie;

	@XmlElement
public HttpTheater hTheater;

protected HttpSearch(){}

public HttpSearch(HttpMovie hMovie){
	this.hMovie=hMovie;
}

public HttpSearch(HttpTheater hTheater){
	this.hTheater=hTheater;
}
	
}
