
public class Group {
	private int size;
	private String pickupLocation;
	private String destination;
	private int timeToWait;
	
	public Group(int a, String b, String c, int d) {
		size = a;
		pickupLocation = b;
		destination = c;
		timeToWait = d;
	}

	public double size() {
		// TODO Auto-generated method stub
		return size;
	}

	public String pickupLocation() {
		// TODO Auto-generated method stub
		return pickupLocation;
	}
	
}
