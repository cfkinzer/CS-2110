import java.nio.charset.MalformedInputException;
import java.util.Scanner;

public class SocSecProcessor {

	public static boolean isValid(String ssn) throws SocSecException {
		String regex = "[0-9] {3}-[0-9] {2}-[0-9] {4}";
		if (ssn.matches(regex)) {
			return true;
		}
		if (ssn.length() != 11) {
			throw new SocSecException("SSN contains the wrong number of characters");
		}
		for (char ch : ssn.toCharArray()) {
			if (!Character.isDigit(ch)) {
				if (!(ch == '-')) {
					throw new SocSecException("SSN contains a character that is not a digit");
				}
			}
		}
		for (char ch : ssn.toCharArray()) {
			if (ch == '-') {
				if (!(ssn.charAt(3) == '-') || !(ssn.charAt(6) == '-')) {
					throw new SocSecException("SSN contains dashes at wrong positions");
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		boolean done = false;
		while (!done) {
			try {
				System.out.println("Name?");
				String name = scan.next();
				System.out.println("SSN?");
				String ssn = scan.next();
				if (isValid(ssn)) {
					System.out.println("Valid // " + name + " // " + ssn);
				}
			} catch (SocSecException exception) {
				System.out.println("Invalid // " + exception.getMessage());
			} finally {
				System.out.println("Continue?");
				if (scan.next().equals("N")) {
					done = true;
				}
			}
		}
	}
}
