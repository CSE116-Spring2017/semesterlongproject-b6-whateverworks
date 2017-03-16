package Tests;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.buffalo.cse116.BurningShip;
import edu.buffalo.cse116.Coord;
import edu.buffalo.cse116.Julia;
import edu.buffalo.cse116.Mandelbrot;
import edu.buffalo.cse116.Multibrot;

public class Phase2Tests {

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
