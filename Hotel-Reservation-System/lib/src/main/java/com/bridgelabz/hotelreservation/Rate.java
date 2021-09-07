package com.bridgelabz.hotelreservation;

public class Rate {
    public void setWeekendRate(Integer weekendRate) {
		this.weekendRate = weekendRate;
	}

	public void setWeekdayRate(Integer weekdayRate) {
		this.weekdayRate = weekdayRate;
	}

	private Integer weekendRate;
    private Integer weekdayRate;

    public Rate(Integer weekendRate, Integer weekdayRate) {
        this.weekendRate = weekendRate;
        this.weekdayRate = weekdayRate;
    }

    public Integer getWeekendRate() {
        return weekendRate;
    }

    public Integer getWeekdayRate() {
        return weekdayRate;
    }
}
