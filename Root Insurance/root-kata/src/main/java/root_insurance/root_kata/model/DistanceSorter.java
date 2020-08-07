package root_insurance.root_kata.model;

import java.util.Comparator;

public class DistanceSorter implements Comparator<Driver> {

	@Override
	public int compare(Driver o1, Driver o2) {
		return o2.getMilesDriven() - o1.getMilesDriven();
	}

}
