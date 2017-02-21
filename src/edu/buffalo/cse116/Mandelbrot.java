package edu.buffalo.cse116;

public class Mandelbrot {
	
	int[][] _grid = new int[512][512];

	public Mandelbrot(){
		
		for (int row = 0; row <= 512; row++){
			for (int column = 0; column <= 512; column++){
				Coord c = new Coord((-2.15 + (row * .00431640625)), (-1.3 + (column * .005078125)));
				_grid[row][column] = escapeTime(c);
			}
		}
	}
		
		
	public int escapeTime(Coord calc){
		
		double xCalc = calc.x();
		
		double yCalc = calc.y();
		
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow(yCalc - 0, 2));
		
		int passes = 0;
		
		while(dist <= 2 && passes < 255){
			
			xCalc = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + xCalc;
			
			yCalc = 2 * xCalc * yCalc + yCalc;
			
			passes = passes + 1;
			
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow(yCalc - 0, 2));
		}
		
		return passes;
	}
	
	
	public int gridEscapeTime(int row, int column){
		
		return _grid[row][column];
	}
}
