package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test3 {

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
	public void BurningShiptest() {
		BurningShip distLessEscapeDistB = new BurningShip();
		Coord c = new Coord (-1.7443359374999874, -0.017451171875000338);
		assertEquals(255, distLessEscapeDistB.escapeTime(c));
	}
	
	@Test
	public void Multibrottest() {
		Multibrot distLessEscapeDistMb = new Multibrot();
		Coord c = new Coord (0.5859375, 0.24375000000000108);
		assertEquals(255, distLessEscapeDistMb.escapeTime(c));
	}
	

}
