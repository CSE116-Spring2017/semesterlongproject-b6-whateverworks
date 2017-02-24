package edu.buffalo.cse116;

import static org.junit.Assert.*;

import java.lang.reflect.Array;
/** Delete this before submission
* Im having trouble with the second assert statement for each test
*/
import org.junit.Test;
// This class determines if the fractal's arrays are the proper size
public class Test5 {
// BurningShip
	@Test
	public void BurningShipSizetest() {
		int arr[][] = BurningShip.calcFrac();
		assertEquals(512, arr.length);
		assertEquals(512, arr.get(0).length);
		
		
	}
  //Julia
	@Test
	public void JuliaSizetest() {
		int arr[][] = Julia.calcFrac();
		assertEquals(512, arr.length);
		assertEquals(512, arr.get(0).length);
		
		
	}
  //Mandelbrot
	@Test
	public void MandelbrotSizetest() {
		int arr[][] = Mandelbrot.calcFrac();
		assertEquals(512, arr.length);
		assertEquals(512, arr.get(0).length);
		
		
	}
  // Multibrot
	@Test
	public void MultibrotSizetest() {
		int arr[][] = Multibrot.calcFrac();
		assertEquals(512, arr.length);
		assertEquals(512, arr.get(0).length);
		
		
	}
	

}
