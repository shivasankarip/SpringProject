package com.puzzles.movieticket.domain.impl;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.puzzles.movieticket.domain.MovieDetails;


@Entity
@Table(name="movie_details")
public class MovieDetailsImpl implements MovieDetails {
	@Id
	@Column(name="movie_id")
	private int movieId;
	
	@Column(name="movie_productions")
	private String mProductions;
	
	@Column(name="movie_director")
	private String mDirector;
	
	@Column(name="movie_cast1")
	private String mCast1;
	
	@Column(name="movie_cast2")
	private String mCast2;
	
	@Column(name="movie_cast3")
	private String mCast3;
	
	@Column(name="movie_synopsis")
	private String mSynopsis;
	
	@Column(name="movie_trailer_url")
	private String mTrailer;

	@Override
	public int getMovieId() {
		return movieId;
	}

	@Override
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}

	@Override
	public String getmProductions() {
		return mProductions;
	}

	@Override
	public void setmProductions(String mProductions) {
		this.mProductions = mProductions;
	}

	@Override
	public String getmDirector() {
		return mDirector;
	}

	@Override
	public void setmDirector(String mDirector) {
		this.mDirector = mDirector;
	}

	@Override
	public String getmCast1() {
		return mCast1;
	}

	@Override
	public void setmCast1(String mCast1) {
		this.mCast1 = mCast1;
	}

	@Override
	public String getmCast2() {
		return mCast2;
	}

	@Override
	public void setmCast2(String mCast2) {
		this.mCast2 = mCast2;
	}

	@Override
	public String getmCast3() {
		return mCast3;
	}

	@Override
	public void setmCast3(String mCast3) {
		this.mCast3 = mCast3;
	}

	@Override
	public String getmSynopsis() {
		return mSynopsis;
	}

	@Override
	public void setmSynopsis(String mSynopsis) {
		this.mSynopsis = mSynopsis;
	}

	@Override
	public String getmTrailer() {
		return mTrailer;
	}

	@Override
	public void setmTrailer(String mTrailer) {
		this.mTrailer = mTrailer;
	}
	
	
	
	
}
