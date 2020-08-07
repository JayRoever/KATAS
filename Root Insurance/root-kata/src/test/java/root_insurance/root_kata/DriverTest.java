package root_insurance.root_kata;

import org.junit.Before;
import org.junit.Test;
import org.junit.Assert;

import root_insurance.root_kata.model.Driver;
import root_insurance.root_kata.model.Trip;

public class DriverTest {

	Trip trip1;
	Trip trip2;
	Trip trip3;
	Driver driver1;
	Driver driver2;
	Driver driver3;

	
	@Before
	public void setUp() {
		trip1 = new Trip( "12:30", "13:30", "60.0");
		trip2 = new Trip( "10:45", "13:30", "35.4");
		trip3 = new Trip( "07:30", "07:35", "3.5");
		
		driver1 = new Driver("FirstDriver");
		driver2 = new Driver("SecondDriver");
		driver3 = new Driver("EmptyDriver");
		
		driver1.addTrip(trip1);
		driver2.addTrip(trip2);
		driver2.addTrip(trip3);
	}
	
	@Test
	public void testGetMilesDriven1Trip() {
		Assert.assertEquals(60,  driver1.getMilesDriven());
	}
	
	@Test
	public void testGetMilesDrivenMultiTrips() {
		Assert.assertEquals(39,  driver2.getMilesDriven());
	}
	
	@Test
	public void testGetMilesDrivenNoTrips() {
		Assert.assertEquals(0,  driver3.getMilesDriven());
	}
	
	@Test
	public void testGetAverageSpeed1Trip() {
		Assert.assertEquals(60, driver1.getAverageSpeed());
	}
	
	@Test
	public void testGetAverageSpeedMultiTrip() {
		Assert.assertEquals(14, driver2.getAverageSpeed());
	}
	
	@Test
	public void testGetAverageSpeedNoTrip() {
		Assert.assertEquals(0, driver3.getAverageSpeed());
	}
	
	@Test 
	public void testAddTripOver100MPH() {
		driver3.addTrip(new Trip( "12:30", "13:30", "100.1"));
		Assert.assertEquals(0,  driver3.getMilesDriven());
	}
	
	@Test 
	public void testAddTrip100MPH() {
		driver3.addTrip(new Trip( "12:30", "13:30", "100.0"));
		Assert.assertEquals(100,  driver3.getMilesDriven());
	}
	
	@Test 
	public void testAddTrip5MPH() {
		driver3.addTrip(new Trip( "12:30", "13:30", "5.0"));
		Assert.assertEquals(5,  driver3.getMilesDriven());
	}
	
	@Test 
	public void testAddTripUnder5MPH() {
		driver3.addTrip(new Trip( "12:30", "13:30", "4.9"));
		Assert.assertEquals(0,  driver3.getMilesDriven());
	}
}
