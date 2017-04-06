package edu.buffalo.cse116;

//Mandelbrot Fractal

public class Mandelbrot implements Fractal{
	
	// Grid to hold escape times
	private int[][] _grid;
	
	private int _escapeDist;
	
	private int _maxEscapeTime;
	
	// Populates array using escapeTime method
	public Mandelbrot(){
		_grid = new int[512][512];
		_escapeDist = 2;
		_maxEscapeTime = 255;
	}
	
	//Calculates fractal and returns array
	@Override
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
	@Override
	public int escapeTime(Coord calc){
		
		double currentX = calc.x();
		
		double currentY = calc.y();
		
		double xCalc = currentX;
		
		double yCalc = currentY;
		
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow(yCalc - 0, 2));
		
		int passes = 0;
		
		while(dist <= _escapeDist && passes < _maxEscapeTime){
			
			double previousXCalc = xCalc;
			
			xCalc = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + currentX;
			
			yCalc = 2 * previousXCalc * yCalc + currentY;
			
			passes = passes + 1;
			
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow(yCalc - 0, 2));
		}
		
		return passes;
	}
	
	
	// returns x coordinate associated with pixel
	@Override
	public double getXCoordinate(int row){
		return -2.15 + (row * 0.00537109375);
	}
	
	// returns y coordinate associated with pixel
	@Override
	public double getYCoordinate(int column){
		return -1.3 + (column * 0.005078125);
	}

	// sets new escape distance for Mandelbrot
	@Override
	public void newEscapeDist(int dist) {
		_escapeDist = dist;
	}

	@Override
	public void newMaxEscapeTime(int maxEscapeTime) {
		_maxEscapeTime = maxEscapeTime;
	}
	
}
