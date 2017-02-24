package edu.buffalo.cse116;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class BurningShipTest {
	@Test
	public void tZero() {
		BurningShip col = new BurningShip();
		Coord c = new Coord (-1.8, -0.08);
		assertEquals(0, col.escapeTime(c));
	}
	
	@Test
	public void tMid() {
		BurningShip col = new BurningShip();
		Coord c = new Coord (-0.05, -0.0275);
		assertEquals(256, col.escapeTime(c));
	}
	
	@Test
	public void tEnd() {
		BurningShip col = new BurningShip();
		Coord c = new Coord (1.7, 0.025);
		assertEquals(512, col.escapeTime(c));
	}
	
	@Test
	public void tRandom() {
		BurningShip col = new BurningShip();
		Coord c = new Coord (1.23515625, 0.0110546875);
		assertEquals(444, col.escapeTime(c));
	}
	
}
