package edu.buffalo.cse116;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class MandelbrotTest {

	@Test
	public void tZero() {
		Mandelbrot col = new Mandelbrot();
		Coord c = new Coord (-2.15, -1.3);
		assertEquals(0, col.escapeTime(c));
	}
	
	@Test
	public void tMid() {
		Mandelbrot col = new Mandelbrot();
		Coord c = new Coord (-0.775, 0);
		assertEquals(256, col.escapeTime(c));
	}
	
	@Test
	public void tEnd() {
		Mandelbrot col = new Mandelbrot();
		Coord c = new Coord (0.6, 1.3);
		assertEquals(512, col.escapeTime(c));
	}
	
	@Test
	public void tRandom() {
		Mandelbrot col = new Mandelbrot();
		Coord c = new Coord (-0.1197265625, 0.61953125);
		assertEquals(378, col.escapeTime(c));
	}
}
