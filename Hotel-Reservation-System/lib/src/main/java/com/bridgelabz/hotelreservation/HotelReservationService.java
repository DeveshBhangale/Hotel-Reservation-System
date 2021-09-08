package com.bridgelabz.hotelreservation;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

public class HotelReservationService {
	
	
	public HotelReservationService() {
		super();
	}

	public void getCheapestHotel(ArrayList<HotelReservation> data, CustomerType customerType,String date1,String date2,String date3) {
		DateTimeFormatter customFormatter = DateTimeFormatter.ofPattern("ddMMMyyyy");
		LocalDate date_1 = LocalDate.parse(date1,customFormatter);
		LocalDate date_2 = LocalDate.parse(date2,customFormatter);
		LocalDate date_3 = LocalDate.parse(date3,customFormatter);
		
		HashMap<String,Integer> totalValueOfHotels = new HashMap<>();
		HashMap<String,Integer> ratingOfHotels = new HashMap<>();
		data.stream().forEach(n -> {
			totalValueOfHotels.put(n.getName(), getTotalValue(n,customerType,date_1.getDayOfWeek(),date_2.getDayOfWeek(),date_3.getDayOfWeek()));
			ratingOfHotels.put(n.getName(), n.getRating());
			});
//		FOR GETTING CHEAPEST HOTEL RATES CODE
//		String hotel = totalValueOfHotels.entrySet().stream().min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
//		Integer rates = totalValueOfHotels.entrySet().stream().min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getValue();
//		String hotel = ratingOfHotels.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
//		Integer rates = totalValueOfHotels.get(hotel);
//		System.out.println(totalValueOfHotels +"\n"+ratingOfHotels);
//		System.out.println("The Cheapest hotel is "+ hotel +"  with total rating of "+ratingOfHotels.get(hotel)+" and total rate "+rates+"$");
		getBestRatedHotelsWithCheapestRate(totalValueOfHotels,ratingOfHotels);
		
	}

	private void getBestRatedHotelsWithCheapestRate(HashMap<String, Integer> totalValueOfHotels,
			HashMap<String, Integer> ratingOfHotels) {
		Integer rating = ratingOfHotels.entrySet().stream().max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getValue();
		Integer value = totalValueOfHotels.entrySet().stream().filter(n1 -> ratingOfHotels.get(n1.getKey()).equals(rating))
			.min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getValue();
		String hotel = totalValueOfHotels.entrySet().stream().filter(n1 -> ratingOfHotels.get(n1.getKey()).equals(rating))
				.min((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1).get().getKey();
		System.out.println("The Cheapest hotel is "+ hotel +"  with best rating of "+ratingOfHotels.get(hotel)+" and total rate "+value+"$");
		
	}

	private Integer getTotalValue(HotelReservation n, CustomerType customerType, DayOfWeek date_1, DayOfWeek date_2, DayOfWeek date_3) {
		Integer temp = 0;
		if(customerType.equals(CustomerType.REGULAR)) {
			if(date_1.toString().equals("SATURDAY") || date_1.toString().equals("SUNDAY"))
				temp += n.getRate().get(CustomerType.REGULAR).getWeekendRate();
			else
				temp += n.getRate().get(CustomerType.REGULAR).getWeekdayRate();
		}
		else {
			if(date_1.toString().equals("SATURDAY") || date_1.toString().equals("SUNDAY"))
				temp += n.getRate().get(CustomerType.REWARDS).getWeekendRate();
			else
				temp += n.getRate().get(CustomerType.REWARDS).getWeekdayRate();
		}
		if(customerType.equals(CustomerType.REGULAR)) {
			if(date_2.toString().equals("SATURDAY") || date_2.toString().equals("SUNDAY"))
				temp += n.getRate().get(CustomerType.REGULAR).getWeekendRate();
			else
				temp += n.getRate().get(CustomerType.REGULAR).getWeekdayRate();
			}
		else {
			if(date_2.toString().equals("SATURDAY") || date_2.toString().equals("SUNDAY"))
				temp += n.getRate().get(CustomerType.REWARDS).getWeekendRate();
			else
				temp += n.getRate().get(CustomerType.REWARDS).getWeekdayRate();
		}
		if(customerType.equals(CustomerType.REGULAR)){
			if(date_3.toString().equals("SATURDAY") || date_3.toString().equals("SUNDAY"))
				temp += n.getRate().get(CustomerType.REGULAR).getWeekendRate();
			else
				temp += n.getRate().get(CustomerType.REGULAR).getWeekdayRate();
			}
		else {
			if(date_3.toString().equals("SATURDAY") || date_3.toString().equals("SUNDAY"))
				temp += n.getRate().get(CustomerType.REWARDS).getWeekendRate();
			else
				temp += n.getRate().get(CustomerType.REWARDS).getWeekdayRate();
		}
		return temp;
	}
}
