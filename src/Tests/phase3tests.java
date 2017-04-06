package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.buffalo.cse116.Coord;
import edu.buffalo.cse116.Mandelbrot;

public class phase3tests {

	@Test
    public void MandelbrotEscapeTimeChangeTest() {
			Mandelbrot etcTest = new Mandelbrot();
            etcTest.newMaxEscapeTime(135);
            Coord c = new Coord (0.3207031250000001, -0.07109374999999386);
            assertEquals(135 , etcTest.escapeTime(c));
    }
}
