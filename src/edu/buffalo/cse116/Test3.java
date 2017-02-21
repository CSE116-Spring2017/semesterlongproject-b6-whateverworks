package edu.buffalo.cse116;

import static org.junit.Assert.*;

import java.awt.Point;

import org.junit.Test;

public class Test3 {

	@Test
	public void Mandelbrottest() {
		Mandelbrot distLessEscapeDistM = new Mandelbrot();
		Coord p = new Coord (0.3207031250000001, -0.07109374999999386);
		assertEquals(254, distLessEscapeDistM.escapeDist(p));
	}
	
	@Test
	public void Juliatest() {
		Julia distLessEscapeDistJ = new Julia();
		Coord p = new Coord (1.0492187499999897, -0.234375);
		assertEquals(254, distLessEscapeDistJ.escapeDist(p));
	}
	
	@Test
	public void BurningShiptest() {
		BurningShip distLessEscapeDistB = new BurningShip();
		Coord p = new Coord (-1.7443359374999874, -0.017451171875000338);
		assertEquals(254, distLessEscapeDistB.escapeDist(p));
	}
	
	@Test
	public void Multibrottest() {
		Multibrot distLessEscapeDistMb = new Multibrot();
		Coord p = new Coord (0.5859375, 0.24375000000000108);
		assertEquals(254, distLessEscapeDistMb.escapeDist(p));
	}

}
