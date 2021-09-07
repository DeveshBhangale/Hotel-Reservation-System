package com.bridgelabz.hotelreservation;
import java.util.ArrayList;


public class HotelReservation {
	String name;
	Integer rating;
	CustomerType customerType;
	Integer weekdayRates;
	Integer weekendRates;
	
	
	public HotelReservation(String name, Integer rating, CustomerType customerType, Integer weekdayRates,
			Integer weekendRates) {
		super();
		this.name = name;
		this.rating = rating;
		this.customerType = customerType;
		this.weekdayRates = weekdayRates;
		this.weekendRates = weekendRates;
	}
	
	
}
