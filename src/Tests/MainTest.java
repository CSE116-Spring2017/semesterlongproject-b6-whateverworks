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
		assertEquals(.6, row.getXCoordinate(2048), .0000000000001);
	}
		
	@Test
	public void rowRandMandel() {
		Mandelbrot row = new Mandelbrot();
		assertEquals(-1.6867431640625, row.getXCoordinate(345), .00000000000001);
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
		assertEquals(1.7, row.getXCoordinate(2048), .0000000000001);
	}
		
	@Test
	public void rowRandJulia() {
		Julia row = new Julia();
		assertEquals(-1.427734375, row.getXCoordinate(164), .0000000001);
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
		assertEquals(-1.7, row.getXCoordinate(2048), .0000000000001);
	}
		
	@Test
	public void rowRandBurning() {
		BurningShip row = new BurningShip();
		assertEquals(-1.7794921875, row.getXCoordinate(420), .00000000001);
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
		assertEquals(1.0, row.getXCoordinate(2048), .0000000000001);
	}
		
	@Test
	public void rowRandMutli() {
		Multibrot row = new Multibrot();
		assertEquals(-0.712890625, row.getXCoordinate(294), .0000000001);
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
		assertEquals(1.0, col.getYCoordinate(2048), .0000000001);
	}
	
	@Test
	public void colMidJulia() {
		Julia col = new Julia();
		assertEquals(-0.7509765625, col.getYCoordinate(255), .00000000001);
	}
		
	@Test
	public void colRandJulia() {
		Julia col = new Julia();
		assertEquals(-0.9638671875, col.getYCoordinate(37), .0000000001);
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
		assertEquals(1.3, col.getYCoordinate(2048), .0000000001);
	}
		
	@Test
	public void colMidMandel() {
		Mandelbrot col = new Mandelbrot();
		assertEquals(-0.97626953125, col.getYCoordinate(255), .000000000001);
	}
		
	@Test
	public void colRandMandel() {
		Mandelbrot col = new Mandelbrot();
		assertEquals(-0.79853515625, col.getYCoordinate(395), .000000000001);
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
		assertEquals(0.025, col.getYCoordinate(2048), .0000000001);
	}
		
	@Test
	public void colMidBurning() {
		BurningShip col = new BurningShip();
		assertEquals(-0.06692626953125, col.getYCoordinate(255), .000000000000001);
	}
		
	@Test
	public void colRandBurning() {
		BurningShip col = new BurningShip();
		assertEquals(-0.0657470703125, col.getYCoordinate(278), .00000000000001);
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
		assertEquals(1.3, col.getYCoordinate(2048), .00001);
	}
		
	@Test
	public void colMidMutli() {
		Multibrot col = new Multibrot();
		assertEquals(-0.97626953125, col.getYCoordinate(255), .000000000001);
	}
		
	@Test
	public void colRandMutli() {
		Multibrot col = new Multibrot();
		assertEquals(-1.16416015625, col.getYCoordinate(107), .000000000001);
	}
	
	
		
	// Tests points whose distance never exceeds escape distance
	
	@Test
	public void BurningShipSizetest() {
		BurningShip arrLength = new BurningShip();
		BurningShip arrLength2 = new BurningShip();
		BurningShip arrLength3 = new BurningShip();
		BurningShip arrLength4 = new BurningShip();
		FractalUI frc = new FractalUI();
		frc.setThreads(4);
		int[][] arr = arrLength.calcFrac(0, 512);
		int[][] arr2 = arrLength.calcFrac(512, 1024);
		int[][] arr3 = arrLength.calcFrac(1024, 1536);
		int[][] arr4 = arrLength.calcFrac(1536, 2048);
		assertEquals(512, arr.length);
		assertEquals(512, arr2.length);
		assertEquals(512, arr3.length);
		assertEquals(512, arr4.length);
		assertEquals(512, arr[0].length);
		assertEquals(512, arr2[0].length);
		assertEquals(512, arr3[0].length);
		assertEquals(512, arr4[0].length);
	}
	
	//Julia
	@Test
	public void JuliaSizetest() {
		Julia arrLength = new Julia();
		Julia arrLength2 = new Julia();
		Julia arrLength3 = new Julia();
		Julia arrLength4 = new Julia();
		FractalUI frc = new FractalUI();
		frc.setThreads(4);
		int[][] arr = arrLength.calcFrac(0, 512);
		int[][] arr2 = arrLength2.calcFrac(512, 1024);
		int[][] arr3 = arrLength3.calcFrac(1024, 1536);
		int[][] arr4 = arrLength4.calcFrac(1536, 2048);
		assertEquals(512, arr.length);
		assertEquals(512, arr2.length);
		assertEquals(512, arr3.length);
		assertEquals(512, arr4.length);
		assertEquals(512, arr[0].length);
		assertEquals(512, arr2[0].length);
		assertEquals(512, arr3[0].length);
		assertEquals(512, arr4[0].length);
	}
	
	//Mandelbrot
	@Test
	public void MandelbrotSizetest() {
		Mandelbrot arrLength = new Mandelbrot();
		Mandelbrot arrLength2 = new Mandelbrot();
		Mandelbrot arrLength3 = new Mandelbrot();
		Mandelbrot arrLength4 = new Mandelbrot();
		FractalUI frc = new FractalUI();
		frc.setThreads(4);
		int[][] arr = arrLength.calcFrac(0, 512);
		int[][] arr2 = arrLength2.calcFrac(512, 1024);
		int[][] arr3 = arrLength3.calcFrac(1024, 1536);
		int[][] arr4 = arrLength4.calcFrac(1536, 2048);
		assertEquals(512, arr.length);
		assertEquals(512, arr2.length);
		assertEquals(512, arr3.length);
		assertEquals(512, arr4.length);
		assertEquals(512, arr[0].length);
		assertEquals(512, arr2[0].length);
		assertEquals(512, arr3[0].length);
		assertEquals(512, arr4[0].length);
	}
	
	// Multibrot
	@Test
	public void MultibrotSizetest() {
		Multibrot arrLength = new Multibrot();
		Multibrot arrLength2 = new Multibrot();
		Multibrot arrLength3 = new Multibrot();
		Multibrot arrLength4 = new Multibrot();
		FractalUI frc = new FractalUI();
		frc.setThreads(4);
		int[][] arr = arrLength.calcFrac(0, 512);
		int[][] arr2 = arrLength2.calcFrac(512, 1024);
		int[][] arr3 = arrLength3.calcFrac(1024, 1536);
		int[][] arr4 = arrLength4.calcFrac(1536, 2048);
		assertEquals(512, arr.length);
		assertEquals(512, arr2.length);
		assertEquals(512, arr3.length);
		assertEquals(512, arr4.length);
		assertEquals(512, arr[0].length);
		assertEquals(512, arr2[0].length);
		assertEquals(512, arr3[0].length);
		assertEquals(512, arr4[0].length);	
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
		assertEquals(2048, arr.length);
		assertEquals(2048, arr[0].length);		
	}
	
	//Julia
	@Test
	public void JuliaSizetest() {
		Julia arrLength = new Julia();
		int[][] arr = arrLength.calcFrac();
		assertEquals(2048, arr.length);
		assertEquals(2048, arr[0].length);		
	}
	
	//Mandelbrot
	@Test
	public void MandelbrotSizetest() {
		Mandelbrot arrLength = new Mandelbrot();
		int[][] arr = arrLength.calcFrac();
		assertEquals(2048, arr.length);
		assertEquals(2048, arr[0].length);	
	}
	
	// Multibrot
	@Test
	public void MultibrotSizetest() {
		Multibrot arrLength = new Multibrot();
		int[][] arr = arrLength.calcFrac();
		assertEquals(2048, arr.length);
		assertEquals(2048, arr[0].length);		
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
    
    //tests points whose distance never exceeds escape distance with a max escape time of 135
    @Test
    public void MandelbrotEscapeTimeChangeTest() {
			Mandelbrot etcTestM = new Mandelbrot();
            etcTestM.newMaxEscapeTime(135);
            Coord c = new Coord (0.3207031250000001, -0.07109374999999386);
            assertEquals(135 , etcTestM.escapeTime(c));
    }
	
	@Test
    public void BurningShiptest5() {
		BurningShip etcTestB = new BurningShip();
		etcTestB.newMaxEscapeTime(135);
		Coord c = new Coord (-1.7443359374999874, -0.017451171875000338);
		assertEquals(135 ,  etcTestB.escapeTime(c));
    }
	
	@Test
	public void MultibrotEscTime() {
		Multibrot etcTestMB = new Multibrot();
		etcTestMB.newMaxEscapeTime(135);
		Coord c = new Coord (0.5859375, 0.24375000000000108);
		assertEquals(135, etcTestMB.escapeTime(c));
	}
	
	@Test
	public void JuliaTest5(){
		Julia etcTestJ = new Julia();
		etcTestJ.newMaxEscapeTime(135); 
		Coord c = new Coord (1.0492187499999897, -0.234375);
		assertEquals(135, etcTestJ.escapeTime(c));
	}
}
