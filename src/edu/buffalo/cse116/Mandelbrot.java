package edu.buffalo.cse116;

// Steven LeFebvre

public class Mandelbrot {
	
	// Grid to hold escape times
	int[][] _grid = new int[512][512];

	
	// Populates array using escapeTime method
	public Mandelbrot(){
		
	}
	
	//Calculates fractal and returns array
	public int[][] calcFrac(){
		for (int row = 0; row < 512; row++){
			for (int column = 0; column < 512; column++){
				Coord c = new Coord((-2.15 + (row * 0.00537109375)), (-1.3 + (column * 0.005078125)));
				_grid[row][column] = escapeTime(c);
			}
		}
		return _grid;
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
			
			double previousXCalc = xCalc;
			
			xCalc = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + currentX;
			
			yCalc = 2 * previousXCalc * yCalc + currentY;
			
			passes = passes + 1;
			
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow(yCalc - 0, 2));
		}
		
		return passes;
	}
	
	// returns escape time at a specific point in our grid
		/*public int gridEscapeTime(Point p){
			
			return _grid[p.x][p.y];
		}*/
	
	// returns x coordinate associated with pixel
	public double getXCoordinate(int row){
		return -2.15 + (row * 0.00537109375);
	}
	
	// returns y coordinate associated with pixel
	public double getYCoordinate(int column){
		return -1.3 + (column * 0.005078125);
	}
	
}
