package edu.buffalo.cse116;

import java.awt.Point;

// Steven LeFebvre

public class Mandelbrot {
	
	// Grid to hold escape times
	int[][] _grid = new int[512][512];

	
	// Populates array using escapeTime method
	public Mandelbrot(){
		
		for (int row = 0; row < 512; row++){
			for (int column = 0; column < 512; column++){
				Coord c = new Coord((-2.15 + (row * .00431640625)), (-1.3 + (column * 0.005078125)));
				_grid[row][column] = escapeTime(c);
			}
		}
	}
		
	
	// Calculates escape time which is the number of passes
	public int escapeTime(Coord calc){
		
		double currentX = calc.x();
		
		double currentY = calc.y();
		
		double xCalc = currentX;
		
		double yCalc = currentY;
		
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow(yCalc - 0, 2));
		
		int passes = 0;
		
		while(dist <= 2 && passes < 255){
			
			xCalc = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + currentX;
			
			yCalc = 2 * xCalc * yCalc + currentY;
			
			passes = passes + 1;
			
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow(yCalc - 0, 2));
		}
		
		return passes;
	}
	
	// returns escape time at a specific point in our grid
	public int gridEscapeTime(Point p){
	
		return _grid[p.x][p.y];
	}
}
