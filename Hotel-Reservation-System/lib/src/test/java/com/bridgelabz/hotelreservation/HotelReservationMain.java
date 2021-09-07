package com.bridgelabz.hotelreservation;

import java.util.ArrayList;
import java.util.HashMap;

import org.junit.Before;
import org.junit.Test;

public class HotelReservationMain {
	public ArrayList<HotelReservation> data = new ArrayList<HotelReservation>();
	HotelReservationService hotelReservationRunner = new HotelReservationService();
	
	
	@Before
	public void addHotels() {
		HashMap<CustomerType,Rate> map = new HashMap<>();
		
		map.put(CustomerType.REGULAR, new Rate(110,90));
		map.put(CustomerType.REWARDS, new Rate(80,80));		
		HotelReservation lakewood = new HotelReservation("lakewood",3,map);
		
		map = new HashMap<>();
		map.put(CustomerType.REGULAR, new Rate(160,60));
		map.put(CustomerType.REWARDS, new Rate(110,50));	
		HotelReservation bridgewood = new HotelReservation("bridgewood",4,map);
		
		map = new HashMap<>();
		map.put(CustomerType.REGULAR, new Rate(220,150));
		map.put(CustomerType.REWARDS, new Rate(100,40));
		HotelReservation ridgewood = new HotelReservation("ridgewood",3,map);
		
		data.add(lakewood);
		data.add(bridgewood);
		data.add(ridgewood);
	}
	
	@Test
	public void checkTestCase1() {
		hotelReservationRunner.getCheapestHotel(data, CustomerType.REWARDS,"09Sep2021","09Sep2021","09Sep2021");
	}
	
	@Test
	public void checkTestCase2() {
		hotelReservationRunner.getCheapestHotel(data, CustomerType.REGULAR,"16Mar2020","17Mar2020","18Mar2020");
	}
	
	@Test
	public void checkTestCase3() {
		hotelReservationRunner.getCheapestHotel(data, CustomerType.REWARDS,"26Mar2009","27Mar2009","28Mar2009");
	}
}
