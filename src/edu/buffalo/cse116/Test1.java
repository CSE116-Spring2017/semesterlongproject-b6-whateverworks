package edu.buffalo.cse116;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class Test1 {
	
	//Mandelbrot
	
	@Test
	public void rowZeroMandel() {
		Mandelbrot row = new Mandelbrot();
		assertEquals(-2.15, row.getXCoordinate(0), .0000000000001);
	}
	
	@Test
	public void rowMaxMandel() {
		Mandelbrot row = new Mandelbrot();
		assertEquals(.6, row.getXCoordinate(512), .0000000000001);
	}
	
	@Test
	public void rowRandMandel() {
		Mandelbrot row = new Mandelbrot();
		assertEquals(-0.29697265625, row.getXCoordinate(345), .0000000000001);
	}
	
	//Julia
	
	@Test
	public void rowZeroJulia() {
		Julia row = new Julia();
		assertEquals(-1.7, row.getXCoordinate(0), .0000000000001);
	}
	
	@Test
	public void rowMaxJulia() {
		Julia row = new Julia();
		assertEquals(1.7, row.getXCoordinate(512), .0000000000001);
	}
	
	@Test
	public void rowRandJulia() {
		Julia row = new Julia();
		assertEquals(-0.6109375, row.getXCoordinate(164), .0000000000001);
	}
		
	//Burning Ship
	
	@Test
	public void rowZeroBurning() {
		BurningShip row = new BurningShip();
		assertEquals(-1.8, row.getXCoordinate(0), .0000000000001);
	}
	
	@Test
	public void rowMaxBurning() {
		BurningShip row = new BurningShip();
		assertEquals(-1.7, row.getXCoordinate(512), .0000000000001);
	}
	
	@Test
	public void rowRandBurning() {
		BurningShip row = new BurningShip();
		assertEquals(-1.71796875, row.getXCoordinate(420), .0000000000001);
	}
	
	//Multibrot
	
	@Test
	public void rowZeroMutli() {
		Multibrot row = new Multibrot();
		assertEquals(-1.0, row.getXCoordinate(0), .0000000000001);
	}
	
	@Test
	public void rowMaxMutli() {
		Multibrot row = new Multibrot();
		assertEquals(1.0, row.getXCoordinate(512), .0000000000001);
	}
	
	@Test
	public void rowRandMutli() {
		Multibrot row = new Multibrot();
		assertEquals(.1484375, row.getXCoordinate(294), .0000000000001);
	}
}