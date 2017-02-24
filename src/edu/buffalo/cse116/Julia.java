package edu.buffalo.cse116;

public class Julia {
	
	int[][] _grid = new int[512][512];

	public Julia(){
		
	}
	
	//Calculates fractal and returns array
	public int[][] calcFrac(){
		for (int row = 0; row < 512; row++){
			for (int column = 0; column < 512; column++){
				Coord c = new Coord((-1.7 + (row * 0.006640625)), (-1.0 + (column * 0.00390625)));
				_grid[row][column] = escapeTime(c);
			}
		}
		return _grid;
	}
		
	public int escapeTime(Coord calc){
		
		double xCalc = calc.x();
		
		double yCalc = calc.y();
		
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow(yCalc - 0, 2));
		
		int passes = 0;
		
		while(dist <= 2 && passes < 255){
			
			xCalc = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + -0.72689;
			
			yCalc = 2 * xCalc * yCalc + .188887;
			
			passes = passes + 1;
			
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow(yCalc - 0, 2));
		}
		
		return passes;
	}
	
	
	public int gridEscapeTime(int row, int column){
		
		return _grid[row][column];
	}

	// returns x coordinate associated with pixel
	public double getXCoordinate(int row){
		return -1.7 + (row * 0.006640625);
	}
			
	// returns y coordinate associated with pixel
	public double getYCoordinate(int column){
		return -1 + (column * 0.00390625);
	}
		
}
	
