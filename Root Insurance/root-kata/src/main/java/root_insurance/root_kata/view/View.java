package root_insurance.root_kata.view;

import java.util.ArrayList;

import root_insurance.root_kata.model.Driver;

public class View {
	
	public void printDrivers(ArrayList<Driver> drivers) {
		for(Driver driver : drivers) {
			String driverName = driver.getName();
			int milesDriven = driver.getMilesDriven();
			int averageSpeed = driver.getAverageSpeed();
			String outputLine = driverName + ": " + milesDriven + " miles";
			if(milesDriven > 0) outputLine += " @ " + averageSpeed + "mph";
			System.out.println(outputLine);	
		}
	}
}
