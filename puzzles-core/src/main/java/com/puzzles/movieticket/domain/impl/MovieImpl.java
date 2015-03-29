package com.puzzles.movieticket.domain.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.puzzles.movieticket.domain.Movie;
import com.puzzles.movieticket.domain.ShowMaster;

@Entity
@Table(name="movie")
public class MovieImpl implements Movie {
	@Id
	@Column(name="movie_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int movieId;
	
	@Column(name="movie_name")
	private String movieName;
	
	@Column(name="movie_language")
	private String movieLanguage;
	
	@Column(name="release_date")
	private Date releaseDate;

	@Column(name="movie_duration")
	private int movieDuration;
	
	@Column(name="movie_poster")
	private String moviePoster;

	@OneToMany(mappedBy ="movie", targetEntity=ShowMasterImpl.class, cascade=CascadeType.ALL)
	private List<ShowMaster> show;
	
	public List<ShowMaster> getShow() {
		return show;
	}

	
	public void setShow(ShowMaster show) {
		if(this.show==null){
			this.show = new ArrayList<ShowMaster>();
		}
		this.show.add(show);
	
	}

	@Override
	public int getMovieId() {
		return movieId;
	}

	@Override
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	
	@Override
	public String getMovieName() {
		return movieName;
	}

	@Override
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	@Override
	public String getMovieLanguage() {
		return movieLanguage;
	}

	@Override
	public void setMovieLanguage(String movieLanguage) {
		this.movieLanguage = movieLanguage;
	}

	@Override
	public Date getReleaseDate() {
		return releaseDate;
	}

	@Override
	public void setReleaseDate(Date releaseDate) {
		this.releaseDate = releaseDate;
	}

	@Override
	public int getMovieDuration() {
		return movieDuration;
	}

	@Override
	public void setMovieDuration(int movieDuration) {
		this.movieDuration = movieDuration;
	}
	
	@Override
	public String getMoviePoster() {
		return moviePoster;
	}

	@Override
	public void setMoviePoster(String moviePoster) {
		this.moviePoster = moviePoster;
	}

	
	
}
