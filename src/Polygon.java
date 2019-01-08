import java.util.*;

public class Polygon {
	
	private ArrayList<Point> vertices;
	
	public Polygon() {
		vertices = new ArrayList<Point>();
	}
	
	public ArrayList<Point> getVertices() {
		return vertices;
	}
	
	public void setVertices(ArrayList<Point> vertices) {
		this.vertices = vertices;
	}
	
	public boolean hasVertex(Point p) {
		return vertices.contains(p);
		// boolean flag = false;
		// for(Point p1:vertices) {
			// if(p.equals(p1)) {
				// flag = true;
			// }
		// }
		// return flag;
	}
	
	public static void main(String[] args) {
		Polygon poly = new Polygon();
		Point p1 = new Point(0, 0);
		Point p2 = new Point(1, 0);
		Point p3 = new Point(1, 1);
		Point p4 = new Point(0, 1);
		poly.vertices.add(p1);
		poly.vertices.add(p2);
		poly.vertices.add(p3);
		poly.vertices.add(p4);
		
		System.out.println(poly.hasVertex(p1));
		Point p = new Point(0, 0);
		System.out.println(poly.hasVertex(p));
	}

}
