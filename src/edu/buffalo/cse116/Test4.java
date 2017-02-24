package edu.buffalo.cse116;

import static org.junit.Assert.*;

import org.junit.Test;

public class Test4 {

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
}


