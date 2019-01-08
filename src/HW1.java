import java.lang.Math;
import java.util.Arrays;

public class HW1 {

	public static double pi(int n) {
		double pi = 0;
		for (int i = 0; i < 30000000; i++) {
			pi += Math.pow(-1, i + 1)/((2*i)-1);
		}
		pi *= 4;
		pi -= 4;
		int x = (int) (pi * Math.pow(10, n));
		double result = x / Math.pow(10, n);
		return result;
	}
	
	public static String easter(int y) {
	int a = y % 19;
	int b = y / 100;
	int c = y % 100;
	int d = b / 4;
	int e = b % 4;
	int g = (8 * b + 13) / 25;
	int h = (19 * a + b - d - g + 15) % 30;
	int j = c / 4;
	int k = c % 4;
	int m = (a + 11 * h) / 319;
	int r = (2 * e + 2 * j - k - h + m + 32) % 7;
	int n = (h - m + r + 90) / 25;
	int p = (h - m + r + n + 19) % 32;
	String month = "";
	String day = String.valueOf(p);
	if(n == 1)
		month = "January";
	if(n == 2)
		month = "February";
	if(n == 3)
		month = "March";
	if(n == 4)
		month = "April";
	if(n == 5)
		month = "May";
	if(n == 6)
		month = "June";
	if(n == 7)
		month = "July";
	if(n == 8)
		month = "August";
	if(n == 9)
		month = "September";
	if(n == 10)
		month = "October";
	if(n == 11)
		month = "November";
	if(n == 12)
		month = "December";
	return month + " " + day;
	
	}
	
	public static String escape(double v) {
		v = v * 0.44704;
		double mass = 1.3 * Math.pow(10, 22);
		double radius = 1.153 * Math.pow(10, 6);
		double g = 6.67 * Math.pow(10, -11);
		double vNeeded = Math.pow((2*g*mass/radius), 1/2);
		if(v < vNeeded) {
			return "The astronaut will return to Halley's Comet";
		}
		else {
			mass = Math.pow(v, 2) * radius / (2 * g);
			return "The astronaut will not return to Halley's Comet."
					+ " In order for the astronaut to return, the comet would need to"
					+ " have a mass larger than " + mass + " kg.";
		}
	}
	
	public static int[] random(int r, int a, int b, int m) {
		int[] values = new int[25];
		int newR = 0;
		for(int i = 0; i < 25; i++) {
			newR = (a * r + b) % m;
			values[i] = newR;
			r = newR;
		}
		return values;
	}
	
	public static void main(String[] args) {
		System.out.println(pi(5)); //expect 3.14159
		System.out.println(pi(3)); //expect 3.141
		System.out.println(easter(2001)); //expect April 15
		System.out.println(easter(2017)); //expect April 16
		System.out.println(escape(1)); //expect return to comet
		System.out.println(escape(35)); //expect no return to comet, m = 2.1 E18
		System.out.println(Arrays.toString(random(19, 47, 92, 13))); //expect random array
		System.out.println(Arrays.toString(random(4, 219, 14, 89))); //expect random array
	}

}