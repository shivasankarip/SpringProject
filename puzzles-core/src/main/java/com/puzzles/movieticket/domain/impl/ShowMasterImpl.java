package com.puzzles.movieticket.domain.impl;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.puzzles.movieticket.domain.Movie;
import com.puzzles.movieticket.domain.ShowMaster;
import com.puzzles.movieticket.domain.Theater;

@Entity
@Table(name="show_master")
public class ShowMasterImpl implements ShowMaster {

	@Id
	@Column(name="show_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int showId;

	@ManyToOne(fetch = FetchType.EAGER,targetEntity=TheaterImpl.class)
	@JoinColumn(name="theater_id")
	private Theater theater;
	
	@ManyToOne(fetch = FetchType.EAGER,targetEntity=MovieImpl.class)
	@JoinColumn(name="movie_id")
	private Movie movie;
	
	@Column(name="showtime")
	private String showTime;

	@Override
	public int getShowId() {
		return showId;
	}

	@Override
	public void setShowId(int showId) {
		this.showId = showId;
	}

	@Override
	public Theater getTheater() {
		return theater;
	}

	@Override
	public void setTheater(Theater theater) {
		this.theater = theater;
	}

	@Override
	public Movie getMovie() {
		return movie;
	}

	@Override
	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	@Override
	public String getShowTime() {
		return showTime;
	}

	@Override
	public void setShowTime(String showTime) {
		this.showTime = showTime;
	}
	

	
}
