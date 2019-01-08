import java.awt.Color;

/** Christian Kinzer 
 * cfk5ax
 * CS 2110 HW8
 */

public class Recursion {
	
	private static Turtle turtle;
	
	public static String reverseString(String s) {
		if (s.length() <= 1) { // if the String is a single Char
			return s; // return the same String
		}
		else { // if the String is multiple Chars
			String x = s.substring(0, s.length() - 1); // x = String - the last Char
			return Character.toString(s.charAt(s.length() - 1)) + reverseString(x); // return the last Char + reverseString(x) 
		}
	} 
	
	public static int waysToClimb(int n) { 
		if (n < 4) { // if there are 1, 2, or 3 stairs
			return n; // there are 1, 2, or 3 possibilites
		}
		else { // if there are more than 3 stairs
			return waysToClimb(n - 1) + waysToClimb(n - 2); // add the number of ways possible after taking a small stride and after taking a long stride
		}
	}
	
	public static int Ackermann(int m, int n) {
		if (m == 0) { // if m is 0
			return n + 1; // return n + 1 (first line of the piecewise function)
		}
		else if (m > 0 && n == 0) { // if m is positive and n = 0
			return Ackermann(m-1, 1); // return A(m-1, 1) (second line of the piecewise function)
		}
		else if (m > 0 && n > 0) { // if m and n are both positive
			return Ackermann(m - 1, Ackermann(m, n - 1)); // return A(m-1, A(m, n-1)) (third line of the piecewise function)
		}
		else { // if the input is invalid
			return -1; // return -1
		}
	}
	
	public static int handShakes(int n) {
		if (n == 2) { // if there are 2 people in the room
			return 1; // there can only be one handshake
		}
		else if (n > 2) { // if there are more than 2 people in the room
			return (n - 1) + handShakes(n - 1); // the first person shakes everyone else's hand (n-1) and the next person follows suit, not counting the first person
		}
		else { // if there are less than 2 people in the room
			return 0; // no handshakes
		}
	}
	
	public static double squareRootGuess(double x, double g) {
		if ((x - .0001) < Math.pow(g, 2) && Math.pow(g, 2) < (x + .0001)) { // if the guess is within bounds
			return g; // return the guess
		}
		else { // if the guess is not within bounds
			double f = ((g + (x/g)) / 2); // f = new guess by the function provided
			return squareRootGuess(x, f); // try again but now with f
		}
	}
	public static double squareRoot(double x) {
		return squareRootGuess(x, 0.00000000000001); // does square root guess with a small positive number to avoid dividing by 0
	}
	
	public static void koch(int n) { // draws a koch curve of length 10
		if (n == 0) { // if the order is 0
			turtle.forward(4); // draw  a straight line
		}
		else { // if the order is not 0
			koch(n-1); // do a koch of n-1
			turtle.left(60); // turn the turtle
			koch(n-1); // do another koch
			turtle.left(-120); // turn the turtle
			koch(n-1); // do another koch
			turtle.left(60); // turn the turtle
			koch(n-1); // do another koch
		}
	}
	
	public static void snowflake(int n) {
		World w = new World(1500, 800, Color.WHITE); // make the world
		turtle = new Turtle(w, -200, 50); // make the turtle
		turtle.setDelay(0);
		turtle.setPenWidth(2);
		koch(n); // draw a koch curve
		turtle.left(-120); // rotate the turtle
		koch(n); // draw another koch curve
		turtle.left(-120); // turn the turtle
		koch(n); // draw another koch, making an equilateral triangle of koch curves
	}
	
	public static void main(String[] args) {
		System.out.println(reverseString("CS is fun")); // expect "nuf si SC", returns "nuf si SC"
		System.out.println(reverseString("a")); // expect "a", returns "a"
		System.out.println(waysToClimb(5)); // expect 8, returns 8
		System.out.println(waysToClimb(4)); // expect 5, returns 5
		System.out.println(Ackermann(2, 3)); // expect 9, returns 9
		System.out.println(Ackermann(0, 1)); // expect 2, returns 2
		System.out.println(handShakes(4)); // expect 6, returns 6
		System.out.println(handShakes(5)); // expect 10, returns 10
		System.out.println(squareRoot(4)); // expect close to 2, returns 2.000000000664688
		System.out.println(squareRoot(1)); // expect close to 1, returns 1.0000257818707534
		snowflake(4); // expects a bigger koch snowflake, returns a bigger snowflake
		//snowflake(3); // expects a smaller koch snowflake, returns a smaller snowflake
	}
}
