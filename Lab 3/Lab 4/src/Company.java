
public class Company {
	public int availableDrivers;
	public Time timeUntilDriver;
	
	public double calculateFare(Group people) {
		double a = people.size();
		double fare = a * 20;
		return fare;
	}
}
