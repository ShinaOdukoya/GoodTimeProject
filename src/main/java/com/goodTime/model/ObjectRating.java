package com.goodTime.model;

public class ObjectRating {
	
	public enum Rating{
		
		ONESTAR, 
		TWOSTART, 
		THREESTAR, 
		FOURSTAR, 
		FIVESTAR;
		
	}
	private Rating rating;
	
	public Rating getRating() {
		return rating;
	}
	public void setRating(Rating rating) {
		this.rating = rating;
	}
}
