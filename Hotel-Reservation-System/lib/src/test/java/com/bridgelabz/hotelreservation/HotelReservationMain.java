package com.bridgelabz.hotelreservation;

import java.util.ArrayList;

import org.junit.Before;

public class HotelReservationMain {
	public ArrayList<HotelReservation> data = new ArrayList<HotelReservation>();
	
	@Before
	public void addHotels() {
		HotelReservation lakewoodRegular = new HotelReservation("lakewood",3,CustomerType.REGULAR,110,90);
		HotelReservation lakewoodReward = new HotelReservation("lakewood",3,CustomerType.REWARDS,80,80);
		
		HotelReservation bridgewoodRegular = new HotelReservation("bridgewood",4,CustomerType.REGULAR,160,60);
		HotelReservation bridgewoodReward = new HotelReservation("bridgewood",4,CustomerType.REWARDS,110,50);
		
		HotelReservation ridgewoodRegular = new HotelReservation("ridgewood",3,CustomerType.REGULAR,220,150);
		HotelReservation ridgewoodReward = new HotelReservation("ridgewood",3,CustomerType.REWARDS,100,40);
		
		data.add(lakewoodRegular);
		data.add(lakewoodReward);
		data.add(bridgewoodRegular);
		data.add(bridgewoodReward);
		data.add(ridgewoodRegular);
		data.add(ridgewoodReward);
	}
}
