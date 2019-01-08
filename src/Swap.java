
public class Swap {

	public static void main(String[] args) {
		int a = 0, b = 1, c = 2, d = 3;
		int temp = b;
		b = a;
		a = temp;
		
		System.out.println(a + " " + b);
		
		swap(c, d);
		System.out.println(c + " " + d);
		
		int[] x = {1}, y = {2};
		
		swap(x, y);
		System.out.println(x[0] + " " + y[0]);
	}
	
	public static void swap(int[] x, int[] y) {
		int temp = y[0];
		y[0] = x[0];
		x[0] = temp;
	}
	
	public static void swap(int x, int y) {
		int temp = y;
		y = x;
		x = temp;
	}
}
