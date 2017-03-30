package Tests;

import static org.junit.Assert.*;

//Required tests

import org.junit.Test;

import edu.buffalo.cse116.BurningShip;
import edu.buffalo.cse116.Coord;
import edu.buffalo.cse116.Julia;
import edu.buffalo.cse116.Mandelbrot;
import edu.buffalo.cse116.Multibrot;

public class MainTest {

	//Tests pixels row in association with x coordinate in fractal
	
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

	
	//Tests pixels column in association with y coordinate in fractal
	
	//JULIA
	
	@Test
	public void colZeroJulia() {
		Julia col = new Julia();
		assertEquals(-1.0, col.getYCoordinate(0), .0000000001);
	}
		
	@Test
	public void colLastJulia() {
		Julia col = new Julia();
		assertEquals(1.0, col.getYCoordinate(512), .0000000001);
	}
	
	@Test
	public void colMidJulia() {
		Julia col = new Julia();
		assertEquals(-0.00390625, col.getYCoordinate(255), .0000000001);
	}
		
	@Test
	public void colRandJulia() {
		Julia col = new Julia();
		assertEquals(-0.85546875, col.getYCoordinate(37), .0000000001);
	}
		
	//Mandelbrot
	
	@Test
	public void colZeroMandel() {
		Mandelbrot col = new Mandelbrot();
		assertEquals(-1.3, col.getYCoordinate(0), .0000000001);
	}
		
	@Test
	public void colLastMandel() {
		Mandelbrot col = new Mandelbrot();
		assertEquals(1.3, col.getYCoordinate(512), .0000000001);
	}
		
	@Test
	public void colMidMandel() {
		Mandelbrot col = new Mandelbrot();
		assertEquals(-0.005078125, col.getYCoordinate(255), .0000000001);
	}
		
	@Test
	public void colRandMandel() {
		Mandelbrot col = new Mandelbrot();
		assertEquals(0.705859375, col.getYCoordinate(395), .0000000001);
	}
		
	//Burning Ship
		
	@Test
	public void colZeroBurning() {
		BurningShip col = new BurningShip();
		assertEquals(-.08, col.getYCoordinate(0), .0000000001);
	}
		
	@Test
	public void colLastBurning() {
		BurningShip col = new BurningShip();
		assertEquals(0.025, col.getYCoordinate(512), .0000000001);
	}
		
	@Test
	public void colMidBurning() {
		BurningShip col = new BurningShip();
		assertEquals(-0.027705078125, col.getYCoordinate(255), .0000000001);
	}
		
	@Test
	public void colRandBurning() {
		BurningShip col = new BurningShip();
		assertEquals(-0.02298828125, col.getYCoordinate(278), .0000000001);
	}
		
	//Multibrot
	
	@Test
	public void colZeroMutli() {
		Multibrot col = new Multibrot();
		assertEquals(-1.3, col.getYCoordinate(0), .0000000001);
	}
		
	@Test
	public void colLastMutli() {
		Multibrot col = new Multibrot();
		assertEquals(1.3, col.getYCoordinate(512), .0000000001);
	}
		
	@Test
	public void colMidMutli() {
		Multibrot col = new Multibrot();
		assertEquals(-0.005078125, col.getYCoordinate(255), .0000000001);
	}
		
	@Test
	public void colRandMutli() {
		Multibrot col = new Multibrot();
		assertEquals(-0.756640625, col.getYCoordinate(107), .0000000001);
	}
	
	
		
	// Tests points whose distance never exceeds escape distance
	
	@Test
	public void BurningShiptest() {
		BurningShip distLessEscapeDistB = new BurningShip();
		Coord c = new Coord (-1.7443359374999874, -0.017451171875000338);
		assertEquals(255, distLessEscapeDistB.escapeTime(c));
	}
	
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
	
	
	
	// Tests points whose distance exceeds escape distance after a single pass
	
	@Test
	public void Mandelbrottest2() {
		Mandelbrot distLessEscapeDistM = new Mandelbrot();
		Coord p = new Coord (0.5946289062500001, 1.2949218750000122);
		assertEquals(1, distLessEscapeDistM.escapeTime(p));
	}
	
	@Test
	public void Juliatest2() {
		Julia distLessEscapeDistJ = new Julia();
		Coord p = new Coord (1.6933593749999853, 0.9765625);
		assertEquals(1, distLessEscapeDistJ.escapeTime(p));
	}
	
	@Test
	public void Multibrottest2() {
		Multibrot distLessEscapeDistMb = new Multibrot();
		Coord p = new Coord (0.9921875, 1.05625);
		assertEquals(1, distLessEscapeDistMb.escapeTime(p));
	}
	
	// Tests that none of the pixels in burning ship have an escape time of 0 or 1
	
	@Test
	public void BurningShiptest2() {
		BurningShip distLessEscapeDistB = new BurningShip();
		Coord p = new Coord (-1.7443359374999874, -0.017451171875000338);
	double q = 0;
	double z = 1;
	assertFalse(q == distLessEscapeDistB.escapeTime(p));
	assertFalse(z == distLessEscapeDistB.escapeTime(p));
	}
	
	
	//Tests that the 2d array has 512 rows and columns
	
	// BurningShip
	@Test
	public void BurningShipSizetest() {
		BurningShip arrLength = new BurningShip();
		int[][] arr = arrLength.calcFrac();
		assertEquals(512, arr.length);
		assertEquals(512, arr[0].length);		
	}
	
	//Julia
	@Test
	public void JuliaSizetest() {
		Julia arrLength = new Julia();
		int[][] arr = arrLength.calcFrac();
		assertEquals(512, arr.length);
		assertEquals(512, arr[0].length);		
	}
	
	//Mandelbrot
	@Test
	public void MandelbrotSizetest() {
		Mandelbrot arrLength = new Mandelbrot();
		int[][] arr = arrLength.calcFrac();
		assertEquals(512, arr.length);
		assertEquals(512, arr[0].length);	
	}
	
	// Multibrot
	@Test
	public void MultibrotSizetest() {
		Multibrot arrLength = new Multibrot();
		int[][] arr = arrLength.calcFrac();
		assertEquals(512, arr.length);
		assertEquals(512, arr[0].length);		
	}
	
	
	
	//Tests points with escape distances of 3 that have an escape time of 10
	
	@Test
    public void Mandelbrottest4() {
			Mandelbrot distLessEscapeDistM = new Mandelbrot();
            distLessEscapeDistM.newEscapeDist(3);
            Coord c = new Coord (0.46007827788650374, -0.3383561643835661);
            assertEquals(10 , distLessEscapeDistM.escapeTime(c));
    }
	
    @Test
    public void Juliatest4(){
            Julia distLessEscapeDistJ = new Julia();
            distLessEscapeDistJ.newEscapeDist(3);       
            Coord c = new Coord (1.4538160469667272, -0.13502935420743645);
            assertEquals(10 ,  distLessEscapeDistJ.escapeTime(c));
                   
    }
    
    @Test
    public void BurningShiptest4(){
            BurningShip distLessEscapeDistB = new BurningShip();
            distLessEscapeDistB.newEscapeDist(3);
            Coord c = new Coord (-1.6999999999999802, 0.0030136986301371603);
            assertEquals(10 ,  distLessEscapeDistB.escapeTime(c));        
    }
    
    @Test
    public void Multibrottest4(){
            Multibrot distLessEscapeDistMb = new Multibrot();
            distLessEscapeDistMb.newEscapeDist(3);
            Coord c = new Coord (0.7025440313111545, -0.5520547945205528);
            assertEquals(10 ,  distLessEscapeDistMb.escapeTime(c));

                   
    }
}