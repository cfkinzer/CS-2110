
public class InClassPoints {

	public static void main(String[] args) {
		double m = points(12, 10);
		System.out.println(m);
	}
	
	public static double points(double x, double y) {
		
		if(x >= 0 && y >= 0) {
			return x * y;
			
		}
		
		if(x < 0 && y >= 0) {
			return x - y;
					
		}
		
		if(x < 0 && y < 0) {
			return x / y;
			
		}
		
		else {
			return x + y;
					
		}
	}
	
}
