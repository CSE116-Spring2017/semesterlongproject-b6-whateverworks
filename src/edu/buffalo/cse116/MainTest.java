package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainTest {

	// Test 3 without burning ship all work
	
	@Test
	public void Mandelbrottest() {
		Mandelbrot distLessEscapeDistM = new Mandelbrot();
		Coord c = new Coord (0.3207031250000001, -0.07109374999999386);
		assertEquals(255, distLessEscapeDistM.escapeTime(c));
	}
	
	@Test
	public void Juliatest() {
		Julia distLessEscapeDistJ = new Julia();
		Coord c = new Coord (1.0492187499999897, -0.234375);
		assertEquals(255, distLessEscapeDistJ.escapeTime(c));
	}
	
	@Test
	public void Multibrottest() {
		Multibrot distLessEscapeDistMb = new Multibrot();
		Coord c = new Coord (0.5859375, 0.24375000000000108);
		assertEquals(255, distLessEscapeDistMb.escapeTime(c));
	}
	
	
	
	// Test 4 without Mandelbrot all work
	@Test
	public void Juliatest2() {
		Julia distLessEscapeDistJ = new Julia();
		Coord p = new Coord (1.6933593749999853, 0.9765625);
		assertEquals(1, distLessEscapeDistJ.escapeTime(p));
	}
	
	@Test
	public void BurningShiptest2() {
		BurningShip distLessEscapeDistB = new BurningShip();
		Coord p = new Coord (-1.7443359374999874, -0.017451171875000338);
	double q = 0;
	double z = 1;
	assertFalse(q == distLessEscapeDistB.escapeTime(p));
	assertFalse(z == distLessEscapeDistB.escapeTime(p));
	}
	
	@Test
	public void Multibrottest2() {
		Multibrot distLessEscapeDistMb = new Multibrot();
		Coord p = new Coord (0.9921875, 1.05625);
		assertEquals(1, distLessEscapeDistMb.escapeTime(p));
	}

}
