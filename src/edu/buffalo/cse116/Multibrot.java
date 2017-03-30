package edu.buffalo.cse116;

//Multibrot Fractal

public class Multibrot implements Fractal {

	private int[][] _grid;
	
	private int _escapeDist;

	public Multibrot(){
		_grid = new int[512][512];
		_escapeDist = 2;
	}
	
	//Calculates fractal and returns array
	@Override
	public int[][] calcFrac(){
		for (int row = 0; row < 512; row++){
			for (int column = 0; column < 512; column++){
				Coord c = new Coord((-1 + (row * .00390625)), (-1.3 + (column * .00507812)));
				_grid[row][column] = escapeTime(c);
			}
		}
		return _grid;
	}
	
	//Calculates escape time
	@Override
	public int escapeTime(Coord calc){
		double currentX = calc.x();
		double currentY = calc.y();
		double xCalc = calc.x();
		double yCalc = calc.y();
		double dist = Math.sqrt(Math.pow(xCalc - 0, 2) + Math.pow(yCalc - 0, 2));
		int passes = 0;
		while (dist <= _escapeDist && passes < 255){
			double previousXCalc = xCalc;
			xCalc = Math.pow(xCalc, 3) - (3 * xCalc * Math.pow(yCalc, 2)) + currentX;
			yCalc = (3 * Math.pow(previousXCalc, 2) * yCalc) - Math.pow(yCalc, 3) + currentY;
			passes = passes + 1;
			dist = Math.sqrt(Math.pow(xCalc - 0, 2) + Math.pow(yCalc - 0, 2));
		}
		return passes;
	}
	
	
	// returns x coordinate associated with pixel
	@Override
	public double getXCoordinate(int row){
		return -1 + (row * .00390625);
	}
			
	// returns y coordinate associated with pixel
	@Override
	public double getYCoordinate(int column){
		return -1.3 + (column * .005078125);
	}

	// sets new escape time for Multibrot
	@Override
	public void newEscapeDist(int dist) {
		_escapeDist = dist;
	}
}