package edu.buffalo.cse116;

//Burning Ship Fractal.

public class BurningShip implements Fractal {
	
	private int[][] _grid;
	
	private int _escapeDist;
	
	
	public BurningShip(){
		_grid = new int[512][512];
		_escapeDist = 2;
	}
	
	//Calculates fractal and returns array
	@Override
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
	@Override
	public int escapeTime(Coord calc){
		
		double currentX = calc.x();
		
		double currentY = calc.y();
		
		double xCalc = currentX;
		
		double yCalc = currentY;
		
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow(yCalc - 0, 2));
		
		int passes = 0;
		
		
		while(dist <= _escapeDist && passes < 255){
			
			double previousXCalc = xCalc;
			
			xCalc = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + currentX;
			
			yCalc = Math.abs(2 * previousXCalc * yCalc) + currentY;
			
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
	@Override
	public double getXCoordinate(int row){
		return -1.8 + (row * 0.0001953125);
	}
		
	// returns y coordinate associated with pixel
	@Override
	public double getYCoordinate(int column){
		return -.08 + (column * .000205078125);
	}

	@Override
	public void newEscapeDist(int dist) {
		_escapeDist = dist;
	}
		

}
