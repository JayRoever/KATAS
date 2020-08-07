package root_insurance.root_kata.dao;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import root_insurance.root_kata.model.Driver;
import root_insurance.root_kata.model.Trip;

public class FileIO implements InputDAO{
	
	private String filePath;
	private Map<String, Driver> drivers;
	
	public FileIO(String filePath) {
		this.filePath = filePath;
		this.drivers = new HashMap<String, Driver>();
	}
	
	public ArrayList<Driver> loadData() throws IOException {
		FileReader fileReader = new FileReader(filePath);
	    BufferedReader reader = new BufferedReader(fileReader);
			String line;
			while((line = reader.readLine()) != null) {
				mapLineToDrivers(line);
			}
			reader.close();
		return new ArrayList<Driver>(drivers.values());
	}
	
	private Map<String, Driver> mapLineToDrivers(String line) {
		String[] lineData = line.split(" ");
		String driverName = lineData[1];
		switch(lineData[0]) {
		case "Driver" :
			drivers.put(driverName, new Driver(driverName));
			break;
		case "Trip" :
			try {
				drivers.get(driverName).addTrip(new Trip(lineData[2], lineData[3], lineData[4]));
			} catch(NullPointerException e) {
				System.out.println("Driver Not Found To Assign Trip");
			}
			
			break;
		default:
			System.out.println("Error Reading Line Data");
		}
		return drivers;
	}
	
}