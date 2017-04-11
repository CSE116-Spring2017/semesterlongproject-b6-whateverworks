package edu.buffalo.cse116;

//Julia Fractal

public class Julia implements Fractal{
	
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
	
	public Julia() {
		_grid = new int[512][512];
		_escapeDist = 2;
		_maxEscapeTime = 255;
		_lowerX = 0;
		_lowerY = 0;
		_upperX = 512;
		_upperY = 512;
		_rowInterval = 0.006640625;
		_columnInterval = 0.00390625;
		_xBound = -1.7;
		_yBound = -1.0;
		_prevRowInterval = 0.006640625;
		_prevColumnInterval = 0.00390625;
		_prevXBound = -1.7;
		_prevYBound = -1;
	}
	
	//Calculates fractal and returns array
	@Override
	public int[][] calcFrac(){
		for (int row = 0; row < 512; row++){
			for (int column = 0; column < 512; column++){
				Coord c = new Coord((_xBound + (row * _rowInterval)), (_yBound + (column * _columnInterval)));
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
		
		while(dist <= _escapeDist && passes < _maxEscapeTime){
			
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
		return _prevXBound + (row * _prevRowInterval);
	}
			
	// returns y coordinate associated with pixel
	@Override
	public double getYCoordinate(int column){
		return _prevYBound + (column * _prevColumnInterval);
	}

	// Sets new escape distance for Julia
	@Override
	public void newEscapeDist(int dist) {
		_escapeDist = dist;
	}
	
	//Sets new escape time for Julia 
	@Override
	public void newMaxEscapeTime(int maxEscapeTime){
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
		_rowInterval = (getXCoordinate(_upperX) - _xBound) / 512;
		_columnInterval = (getYCoordinate(_upperY) - _yBound) / 512;
	}
	
	@Override
	public void beginningBounds() {
		_prevRowInterval = _rowInterval;
		_prevColumnInterval = _columnInterval;
		_prevXBound = _xBound;
		_prevYBound = _yBound;
		_xBound = getXCoordinate(_lowerX);
		_yBound = getYCoordinate(_lowerY);
	}

	@Override
	public void reset() {
		_lowerX = 0;
		_lowerY = 0;
		_upperX = 512;
		_upperY = 512;
		_rowInterval = 0.006640625;
		_columnInterval = 0.00390625;
		_xBound = -1.7;
		_yBound = -1.0;
		_prevRowInterval = 0.006640625;
		_prevColumnInterval = 0.00390625;
		_prevXBound = -1.7;
		_prevYBound = -1;
	}
		
}