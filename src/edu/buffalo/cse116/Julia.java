package edu.buffalo.cse116;

//Julia Fractal

public class Julia implements Fractal{
	
	private int[][] _grid;
	
	private int _escapeDist;
	
	public Julia() {
		_grid = new int[512][512];
		_escapeDist = 2;
	}
	
	//Calculates fractal and returns array
	@Override
	public int[][] calcFrac(){
		for (int row = 0; row < 512; row++){
			for (int column = 0; column < 512; column++){
				Coord c = new Coord((-1.7 + (row * 0.006640625)), (-1.0 + (column * 0.00390625)));
				_grid[row][column] = escapeTime(c);
			}
		}
		return _grid;
	}
		
	//Calculates escape time
	@Override
	public int escapeTime(Coord calc){
		
		double xCalc = calc.x();
		
		double yCalc = calc.y();
		
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow(yCalc - 0, 2));
		
		int passes = 0;
		
		while(dist <= _escapeDist && passes < 255){
			
			double previousXCalc = xCalc;
			
			xCalc = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + -0.72689;
			
			yCalc = 2 * previousXCalc * yCalc + .188887;
			
			passes = passes + 1;
			
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow(yCalc - 0, 2));
		}
		
		return passes;
	}

	// returns x coordinate associated with pixel
	@Override
	public double getXCoordinate(int row){
		return -1.7 + (row * 0.006640625);
	}
			
	// returns y coordinate associated with pixel
	@Override
	public double getYCoordinate(int column){
		return -1 + (column * 0.00390625);
	}

	// Sets new escape distance for Julia
	@Override
	public void newEscapeDist(int dist) {
		_escapeDist = dist;
	}
		
}
	
