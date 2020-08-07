package root_insurance.root_kata;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import root_insurance.root_kata.model.Trip;

public class TripTest {

	Trip trip1;
	Trip trip2;
	Trip trip3;
	
	@Before
	public void setUp() {
		trip1 = new Trip( "12:30", "13:30", "60.0");
		trip2 = new Trip( "10:45", "13:30", "35.4");
		trip3 = new Trip( "07:30", "07:35", "3.5");
	}
	
	@Test
	public void testGetDistanceTraveled() {
		Assert.assertEquals(60.0, trip1.getDistanceTraveled() , 0);
		Assert.assertEquals(35.4, trip2.getDistanceTraveled() , 0);
		Assert.assertEquals(3.5, trip3.getDistanceTraveled() , 0);
	}
	
	@Test
	public void testGetTripTimeInMinuets() {
		Assert.assertEquals(60, trip1.getTripTimeInMinuets());
		Assert.assertEquals(165, trip2.getTripTimeInMinuets());
		Assert.assertEquals(5, trip3.getTripTimeInMinuets());
	}
	
}
