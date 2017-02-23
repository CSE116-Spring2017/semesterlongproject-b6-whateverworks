package edu.buffalo.cse116;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class JuliaTest {
	@Test
	public void colZero() {
		Julia col = new Julia();
		Coord c = new Coord (-1.7, -1.0);
		assertEquals(0, col.escapeTime(c));
	}
	
	@Test
	public void colMid() {
		Julia col = new Julia();
		Coord c = new Coord (0, 0);
		assertEquals(256, col.escapeTime(c));
	}
	
	@Test
	public void colEnd() {
		Julia col = new Julia();
		Coord c = new Coord (1.7, 1.0);
		assertEquals(512, col.escapeTime(c));
	}
	
	@Test
	public void colRandom() {
		Julia col = new Julia();
		Coord c = new Coord (-0.99609375, -0.5859375);
		assertEquals(106, col.escapeTime(c));
	}
	
}
