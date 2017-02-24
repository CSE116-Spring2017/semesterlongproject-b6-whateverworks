package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class MainProtoTest {

	/**
	 * Class containing Set of tests used to calculate the escape time for a 
	 * coordinate whose distance from the origin exceeds the escape distance after a single loop pass
	 * 
	 * Made by Brian Prais
	 * 
	 */
		
	
	/**
	 *  Test used on the Mandelbrot Fractal to test a point that exceeds the escape distance in one iteration of the loop.
	 */

@Test
	public void Mandelbrottest2() {
		Mandelbrot distLessEscapeDistM = new Mandelbrot();
		Coord p = new Coord (0.5946289062500001, 1.2949218750000122);
		assertEquals(1, distLessEscapeDistM.escapeTime(p));
	}
	/**
	 * Test used on the Julia Fractal to test a point that exceeds the escape distance in one iteration of the loop.
	 */
	@Test
	public void Juliatest2() {
		Julia distLessEscapeDistJ = new Julia();
		Coord p = new Coord (1.6933593749999853, 0.9765625);
		assertEquals(1, distLessEscapeDistJ.escapeTime(p));
	}
	
	/**
	 * Test used on the burning ship fractal to test none of the points in the Burning ship fractal have an escape time of 0 or 1.
	 */
	
	@Test
	public void BurningShiptest2() {
		BurningShip distLessEscapeDistB = new BurningShip();
		Coord p = new Coord (-1.7443359374999874, -0.017451171875000338);
	double q = 0;
	double z = 1;
	assertFalse(q == distLessEscapeDistB.escapeTime(p));
	assertFalse(z == distLessEscapeDistB.escapeTime(p));
	}
	/**
	 * Test used on the Multibrot Fractal to test a point that exceeds the escape distance in one iteration of the loop.
	 */
	@Test
	public void Multibrottest2() {
		Multibrot distLessEscapeDistMb = new Multibrot();
		Coord p = new Coord (0.9921875, 1.05625);
		assertEquals(1, distLessEscapeDistMb.escapeTime(p));
	}

}


