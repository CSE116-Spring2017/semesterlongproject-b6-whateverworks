package edu.buffalo.cse116;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test2 {
	
	//JULIA
	
	@Test
	public void colZeroJulia() {
		Julia col = new Julia();
		assertEquals(-1.0, col.getYCoordinate(0), .0000000001);
	}
	
	//Mandelbrot
	
	@Test
	public void colZeroMandel() {
		Mandelbrot col = new Mandelbrot();
		assertEquals(-1.3, col.getYCoordinate(0), .0000000001);
	}
	
	//Burning Ship
	
	@Test
	public void colZeroBurning() {
		BurningShip col = new BurningShip();
		assertEquals(-.08, col.getYCoordinate(0), .0000000001);
	}
	
	//Multibrot
	
	@Test
	public void colZeroMutli() {
		Multibrot col = new Multibrot();
		assertEquals(-1.3, col.getYCoordinate(0), .0000000001);
	}
}