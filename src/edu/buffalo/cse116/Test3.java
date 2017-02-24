package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test3 {

	// not working properly
	
	@Test
	public void BurningShiptest() {
		BurningShip distLessEscapeDistB = new BurningShip();
		Coord c = new Coord (-1.7443359374999874, -0.017451171875000338);
		assertEquals(255, distLessEscapeDistB.escapeTime(c));
	}
	

}
