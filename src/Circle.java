
public class Circle {

	private double radius;
	private Point center;
	
	public Circle(double radius, Point center) {
		this.radius = radius;
		this.center = center;
	}
	
	public Circle() {
		radius = 1.0;
		center = new Point(4, 6);
	}
	
	public String toString() {
		return "Center: " + center + ", Radius: " + radius;
	}
	
	public boolean equals(Object o) {
		if(o instanceof Circle){
			Circle c2 = (Circle)o;
			return (this.radius == c2.radius) && (this.center.equals(c2.center));
		}
		else {
			return false;
		}
	}
	
	public static void main(String[] args) {
		Circle c = new Circle();
		// System.out.println(c);
		Circle c2 = new Circle();
		System.out.println(c2.equals(c)); // dif circles with same values
		Point p = new Point(1, 1);
		Circle c3 = new Circle(5.0, p);
		System.out.println(c3.equals(c)); // dif circles with dif values
		System.out.println(c.equals(c)); // same circle
		
		
	}
	
}
