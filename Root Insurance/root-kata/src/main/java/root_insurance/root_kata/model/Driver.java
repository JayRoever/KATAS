package root_insurance.root_kata.model;

import java.util.ArrayList;

public class Driver {

	private String name;
	private ArrayList<Trip> trips;
	
	public Driver(String name) {
		this.name = name;
		trips = new ArrayList<>();
	}
	
	public String getName() {
		return name;
	}
	
	/*
	 * Takes in a trip and add it to the trip array if the average speed is with 5 to 100 mph inclusive.
	 * 
	 * @param tripToAdd the trip to add to the driver
	 */
	public void addTrip(Trip tripToAdd) {
		if(tripSpeedCheck(tripToAdd)) {
			trips.add(tripToAdd);
		}
	}
	
	/*
	 * Gets the total miles driven by the driver, rounded to the nearest mile.
	 * 
	 * @return total miles driven by the driver.
	 */
	public int getMilesDriven() {
		double milesDriven = 0;
		for(Trip trip : trips) {
			milesDriven += trip.getDistanceTraveled();
		}	
		return (int) Math.round(milesDriven);
	}
	
	/*
	 * Gets the average speed of the driver, rounded to the nearest Miles Per Hour
	 * 
	 * @return the average speed of the driver in mph
	 */
	public int getAverageSpeed() {
		int averageSpeed = 0;
		if(trips.size() > 0) {
			int milesDriven = getMilesDriven();
			int minuetsDriven = getMinuetsDriven();
			averageSpeed = (int) Math.round((milesDriven / (double) minuetsDriven) * 60);
		}
		return averageSpeed;
	}
	
	/*
	 * Returns the total minutes driven by the driver for all trips
	 * 
	 * @return total minutes driven
	 */
	private int getMinuetsDriven() {
		int minuetsDriven = 0;
		for(Trip trip : trips) {
			minuetsDriven += trip.getTripTimeInMinuets();
		}
		return minuetsDriven;
	}
	
	/*
	 * Takes in a trip and return true if the trip is with in 5 and 100 mph inclusive.
	 * 
	 * @param trip the trip to test
	 * @return the boolean if the trip is within the range
	 */
	private boolean tripSpeedCheck(Trip trip) {
		double tripDistance = trip.getDistanceTraveled();
		double minuetsDriven = trip.getTripTimeInMinuets() / 60d;
		double speed = tripDistance / minuetsDriven;
		return (speed >= 5 && speed <= 100);
	}
}
