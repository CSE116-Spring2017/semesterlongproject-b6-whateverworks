package edu.buffalo.cse116;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test2 {
	
	//JULIA
	
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
	
	//MULTIBROT
	
	@Test
	public void multiZero() {
		Multibrot col = new Multibrot();
		Coord c = new Coord (-1.0, -1.3);
		assertEquals(0, col.escapeTime(c));
	}
	
	@Test
	public void multiMid() {
		Multibrot col = new Multibrot();
		Coord c = new Coord (0, 0);
		assertEquals(256, col.escapeTime(c));
	}
	
	@Test
	public void multiEnd() {
		Multibrot col = new Multibrot();
		Coord c = new Coord (1.0, 1.3);
		assertEquals(512, col.escapeTime(c));
	}
	
	@Test
	public void multiRandom() {
		Multibrot col = new Multibrot();
		Coord c = new Coord (-0.94921875, -1.233984375);
		assertEquals(13, col.escapeTime(c));
	}
	
	//BURNINGSHIP
	
	@Test
	public void burningZero() {
		BurningShip col = new BurningShip();
		Coord c = new Coord (-1.8, -0.08);
		assertEquals(0, col.escapeTime(c));
	}
	
	@Test
	public void burningMid() {
		BurningShip col = new BurningShip();
		Coord c = new Coord (-0.05, -0.0275);
		assertEquals(256, col.escapeTime(c));
	}
	
	@Test
	public void burningEnd() {
		BurningShip col = new BurningShip();
		Coord c = new Coord (1.7, 0.025);
		assertEquals(512, col.escapeTime(c));
	}
	
	@Test
	public void burningRandom() {
		BurningShip col = new BurningShip();
		Coord c = new Coord (1.23515625, 0.0110546875);
		assertEquals(444, col.escapeTime(c));
	}
	
	//MANDELBROT
	
	@Test
	public void mandelZero() {
		Mandelbrot col = new Mandelbrot();
		Coord c = new Coord (-2.15, -1.3);
		assertEquals(0, col.escapeTime(c));
	}
	
	@Test
	public void mandelMid() {
		Mandelbrot col = new Mandelbrot();
		Coord c = new Coord (-0.775, 0);
		assertEquals(256, col.escapeTime(c));
	}
	
	@Test
	public void mandelEnd() {
		Mandelbrot col = new Mandelbrot();
		Coord c = new Coord (0.6, 1.3);
		assertEquals(512, col.escapeTime(c));
	}
	
	@Test
	public void mandelRandom() {
		Mandelbrot col = new Mandelbrot();
		Coord c = new Coord (-0.1197265625, 0.61953125);
		assertEquals(378, col.escapeTime(c));
	}
	
}
