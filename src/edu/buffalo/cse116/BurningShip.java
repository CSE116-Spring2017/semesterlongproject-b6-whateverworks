package edu.buffalo.cse116;

import java.awt.Point;

public class BurningShip {
	
	int[][] _grid = new int[512][512];
	
	public BurningShip(){

	}
	
	//Calculates fractal and returns array
	public int[][] calcFrac(){
		
		for (int row = 0; row < 512; row++){
			for (int column = 0; column < 512; column++){
				Coord c = new Coord((-1.8 + (row * 0.0001953125)), ( -0.08 + (column * .000205078125)));
				// row side is domain/512 column side is range/512
				_grid[row][column] = escapeTime(c);
			}		
		}
		return _grid;
	}
		// Calculates escape time
	public int escapeTime(Coord calc){
		
		double currentX = calc.x();
		
		double currentY = calc.y();
		
		double xCalc = currentX;
		
		double yCalc = currentY;
		
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow(yCalc - 0, 2));
		
		int passes = 0;
		
		
		
		while(dist <= 2 && passes < 255){
			
			xCalc = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + currentX;
			
			yCalc = Math.abs(2 * xCalc * yCalc) + currentY;
			
			passes = passes + 1;
			
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow(yCalc - 0, 2));
			
		}
		
		return passes;
	}
		
	// returns escape time at a specific point in our grid
	public int gridEscapeTime(Point p){
		
		return _grid[p.x][p.y];
	}
	
	// returns x coordinate associated with pixel
	public double getXCoordinate(int row){
		return -1.8 + (row * 0.0001953125);
	}
		
	// returns y coordinate associated with pixel
	public double getYCoordinate(int column){
		return -.08 + (column * .000205078125);
	}
		

}
