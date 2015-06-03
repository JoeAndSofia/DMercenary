package study2_interface.CalTime.vehicle;

import study2_interface.CalTime.vehicle.all.Common;

public class Car implements Common{

	@Override
	public double runTimer(double a, double b, double c) {
		return (a*b/c);
	}
	
}
