package edu.buffalo.cse116;

//Multibrot Fractal

public class Multibrot implements Fractal {

	// Grid to hold escape times
	private int[][] _grid;
		
	private int _escapeDist;
		
	private int _maxEscapeTime;
		
	private int _lowerX;
		
	private int _upperX;

	private int _lowerY;

	private int _upperY;
		
	private double _rowInterval;
		
	private double _columnInterval;
	
	private double _xBound;
		
	private double _yBound;
		
	private double _prevRowInterval;
		
	private double _prevColumnInterval;
		
	private double _prevXBound;
		
	private double _prevYBound;
		
	// Populates array using escapeTime method
	public Multibrot(){
		_grid = new int[512][512];
		_escapeDist = 2;
		_maxEscapeTime = 255;
		_lowerX = 0;
		_lowerY = 0;
		_upperX = 512;
		_upperY = 512;
		_rowInterval = .00390625;
		_columnInterval = .00507812;
		_xBound = -1;
		_yBound = -1.3;
		_prevRowInterval = .00390625;
		_prevColumnInterval = .00507812;
		_prevXBound = -1;
		_prevYBound = -1.3;
	}
	
	//Calculates fractal and returns array
	@Override
	public int[][] calcFrac(){
		for (int row = 0; row < 512; row++){
			for (int column = 0; column < 512; column++){
				Coord c = new Coord((-1 + (row * _rowInterval)), (-1.3 + (column * _columnInterval)));
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
		while (dist <= _escapeDist && passes < _maxEscapeTime){
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
		return _prevXBound + (row * _prevRowInterval);
	}
			
	// returns y coordinate associated with pixel
	@Override
	public double getYCoordinate(int column){
		return _prevYBound + (column * _prevColumnInterval);
	}

	// sets new escape time for Multibrot
	@Override
	public void newEscapeDist(int dist) {
		_escapeDist = dist;
	}

	@Override
	public void newMaxEscapeTime(int maxEscapeTime) {
		_maxEscapeTime = maxEscapeTime;	
	}

	@Override
	public void newBounds(int lowerX, int upperX, int lowerY, int upperY) {
		_lowerX = lowerX;
		_lowerY = lowerY;
		_upperX = upperX;
		_upperY = upperY;
	}

	@Override
	public void newInterval() {
		_prevRowInterval = _rowInterval;
		_prevColumnInterval = _columnInterval;
		_rowInterval = (getXCoordinate(_upperX) - _xBound) / 512;
		_columnInterval = (getYCoordinate(_upperY) - _yBound) / 512;
	}
	
	@Override
	public void beginningBounds() {
		_prevXBound = _xBound;
		_prevYBound = _yBound;
		_xBound = getXCoordinate(_lowerX);
		_yBound = getYCoordinate(_lowerY);
	}


}