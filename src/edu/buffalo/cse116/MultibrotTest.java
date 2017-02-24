package edu.buffalo.cse116;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MultibrotTest {
	@Test
	public void tZero() {
		Multibrot col = new Multibrot();
		Coord c = new Coord (-1.0, -1.3);
		assertEquals(0, col.escapeTime(c));
	}
	
	@Test
	public void tMid() {
		Multibrot col = new Multibrot();
		Coord c = new Coord (0, 0);
		assertEquals(256, col.escapeTime(c));
	}
	
	@Test
	public void tEnd() {
		Multibrot col = new Multibrot();
		Coord c = new Coord (1.0, 1.3);
		assertEquals(512, col.escapeTime(c));
	}
	
	@Test
	public void tRandom() {
		Multibrot col = new Multibrot();
		Coord c = new Coord (-0.94921875, -1.233984375);
		assertEquals(13, col.escapeTime(c));
	}
	
}
