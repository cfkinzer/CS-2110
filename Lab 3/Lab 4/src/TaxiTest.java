import static org.junit.Assert.*;

import org.junit.Test;

public class TaxiTest {

	@Test
	public void testPickUp() {
		Group g = new Group(3, "kill me", "please", 5);
		Taxi t = new Taxi(false, false, true, "kill me");
		t.pickUp(g);
		assertTrue(t.carryingPassengers());
	}

	@Test
	public void testCalculateFare() {
		Group g = new Group(3, "asd", "asd", 5);
		Taxi t = new Taxi(false, false, true, "asd");
		double f = t.calculateFare(g);
		assertTrue(f == 60);
	}
}
