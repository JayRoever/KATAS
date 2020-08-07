package root_insurance.root_kata.model;

public class Trip {

	private String startTime;
	private String endTime;
	private String distanceTraveled;
	
	public Trip(String startTime, String endTime, String distanceTraveled) {
		this.startTime = startTime;
		this.endTime = endTime;
		this.distanceTraveled = distanceTraveled;
	}

	public double getDistanceTraveled() {
		return Double.parseDouble(distanceTraveled);
	}
	
	/*
	 * Return the total elapsed time of the trip in minutes
	 */
	public int getTripTimeInMinuets() {
		return timeToMinuets(endTime) - timeToMinuets(startTime);
	}
	
	/*
	 * Takes in a string of a time on a 24-hour clock and returns the time in minutes since 00:00.
	 * 
	 * @param inputTime  string of time on a 24-hour clockk (ex "13:15")
	 * @return integer of total time since 00:00 in minutes
	 */
	private int timeToMinuets(String inputTime) {
		int timeInMinuets = 0;
		String[] hoursMinuets = inputTime.split(":");
		timeInMinuets += Integer.parseInt(hoursMinuets[0]) * 60;
		timeInMinuets += Integer.parseInt(hoursMinuets[1]);
		return timeInMinuets;
	}
	
}
