package com.bridgelabz.hotelreservation;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class HotelReservation {
	private String name;
	private Integer rating;
	private HashMap<CustomerType,Rate> rate;
	
	
	public String getName() {
		return name;
	}




	public Integer getRating() {
		return rating;
	}



	public HashMap<CustomerType, Rate> getRate() {
		return rate;
	}


	public HotelReservation(String name, Integer rating, HashMap<CustomerType,Rate> rate) {
		super();
		this.name = name;
		this.rating = rating;
		this.rate = rate;
	}



	
	
	
	
}
