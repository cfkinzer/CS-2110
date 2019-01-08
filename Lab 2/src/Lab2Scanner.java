import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Lab2Scanner {

	public static void main(String[] args) {
		
		/* Scanner keyboard = new Scanner(System.in);
		ArrayList<Double> doubleList = new ArrayList<Double>();
		System.out.println("input 5 doubles one at a time, input a non-double to terminate");
		while(keyboard.hasNextDouble()) {
			double d = keyboard.nextDouble();
			doubleList.add(d);
		}
		double numerator = 0;
		for(int i = 0; i < 5; i++) {
			double num = doubleList.get(i);
			numerator = numerator + num;
		}
		double avg = (numerator / 5);
		System.out.println("the average of " + doubleList.get(0) + ", " + doubleList.get(1) + ", " + doubleList.get(2) + ", " + doubleList.get(3) + ", and " + doubleList.get(4) + " is " + avg);
		*/
		
		File theFile = new File("data1.txt");
		try {
			Scanner fileScnr = new Scanner(theFile);
			while (fileScnr.hasNext()) //while something to read
			{
			String str = fileScnr.nextLine(); //str gets the line
			System.out.println(str); // print this string
			}
			System.out.println(theFile.length());
			System.out.println(theFile.getAbsolutePath());
			fileScnr.close(); // close the file when done
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
