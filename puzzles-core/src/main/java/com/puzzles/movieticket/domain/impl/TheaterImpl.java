package com.puzzles.movieticket.domain.impl;



import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.puzzles.movieticket.domain.ShowMaster;
import com.puzzles.movieticket.domain.Theater;


@Entity
@Table(name="theater")
public class TheaterImpl implements Theater{
	
	@Id
	@Column(name="theater_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int theaterId;
	
	@Column(name="theater_name")
	private String theaterName;
	
	
	@Column(name="address_line")
	private String theaterAddressLine;
	
	@Column(name="city")
	private String theaterCity;
	
	@Column(name="zipcode")
	private int theaterZip;
	
	@Column(name="state")
	private String theaterState;
	
	@Column(name="helpline_no")
	private int helpLineNo;
	
	@Column(name="no_of_screens")
	private int screenNo;
	
	
	@OneToMany(mappedBy ="theater", targetEntity=ShowMasterImpl.class, cascade=CascadeType.ALL)
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
	public int getTheaterId() {
		return theaterId;
	}

	@Override
	public void setTheaterId(int theaterId) {
		this.theaterId = theaterId;
	}

	@Override
	public String getTheaterName() {
		return theaterName;
	}

	@Override
	public void setTheaterName(String theaterName) {
		this.theaterName = theaterName;
	}



	@Override
	public int getScreenNo() {
		return screenNo;
	}

	@Override
	public void setScreenNo(int screenNo) {
		this.screenNo = screenNo;
	}
	
	@Override
	public String getTheaterAddressLine() {
		return theaterAddressLine;
	}

	@Override
	public void setTheaterAddressLine(String theaterAddressLine) {
		this.theaterAddressLine = theaterAddressLine;
	}

	@Override
	public String getTheaterCity() {
		return theaterCity;
	}

	@Override
	public void setTheaterCity(String theaterCity) {
		this.theaterCity = theaterCity;
	}

	@Override
	public int getTheaterZip() {
		return theaterZip;
	}

	@Override
	public void setTheaterZip(int theaterZip) {
		this.theaterZip = theaterZip;
	}

	@Override
	public String getTheaterState() {
		return theaterState;
	}

	@Override
	public void setTheaterState(String theaterState) {
		this.theaterState = theaterState;
	}

	@Override
	public int getHelpLineNo() {
		return helpLineNo;
	}
	
	@Override
	public void setHelpLineNo(int helpLineNo) {
		this.helpLineNo = helpLineNo;
	}
	

	
}
