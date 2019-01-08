
public class Taxi {
	public boolean carryingPassengers;
	public boolean pickingUp;
	public boolean idle;
	private String location;
	
	Taxi(boolean hasPassengers, boolean pickUp, boolean still, String place) {
		carryingPassengers = hasPassengers;
		pickingUp = pickUp;
		idle = still;
		location = place;
	}
	
	public double calculateFare(Group people) {
		double a = people.size();
		double fare = a * 20;
		return fare;
	}
	
	public void driveTo(String l) {
		location = l;
	}
	
	public void pickUp(Group people) {
		carryingPassengers = true;
		pickingUp = false;
		idle = false;
		location = people.pickupLocation();
	}

	public boolean carryingPassengers() {
		// TODO Auto-generated method stub
		return carryingPassengers;
	}
	
}
