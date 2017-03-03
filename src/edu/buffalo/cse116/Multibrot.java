package edu.buffalo.cse116;

public class Multibrot {

	int[][] _grid = new int[512][512];

	public Multibrot(){
	}
	
	//Calculates fractal and returns array
	public int[][] calcFrac(){
		for (int row = 0; row < 512; row++){
			for (int column = 0; column < 512; column++){
				Coord c = new Coord((-1 + (row * .00390625)), (-1.3 + (column * .00507812)));
				_grid[row][column] = escapeTime(c);
			}
		}
		return _grid;
	}
	
	public int escapeTime(Coord calc){
		double currentX = calc.x();
		double currentY = calc.y();
		double xCalc = calc.x();
		double yCalc = calc.y();
		double dist = Math.sqrt(Math.pow(xCalc - 0, 2) + Math.pow(yCalc - 0, 2));
		int passes = 0;
		while (dist <=2 && passes < 255){
			double previousXCalc = xCalc;
			xCalc = Math.pow(xCalc, 3) - (3 * xCalc * Math.pow(yCalc, 2)) + currentX;
			yCalc = (3 * Math.pow(previousXCalc, 2) * yCalc) - Math.pow(yCalc, 3) + currentY;
			passes = passes + 1;
			dist = Math.sqrt(Math.pow(xCalc - 0, 2) + Math.pow(yCalc - 0, 2));
		}
		return passes;
	}
	
	// returns escape time at a specific point in our grid
		/*public int gridEscapeTime(Point p){
			
			return _grid[p.x][p.y];
		}*/
	
	// returns x coordinate associated with pixel
	public double getXCoordinate(int row){
		return -1 + (row * .00390625);
	}
			
	// returns y coordinate associated with pixel
	public double getYCoordinate(int column){
		return -1.3 + (column * .005078125);
	}
}