package edu.buffalo.cse116;

//Interface for all fractals

public interface Fractal {
	
	int[][] calcFrac();
	
	int escapeTime(Coord calc);
	
	double getXCoordinate(int row);
	
	double getYCoordinate(int column);
	
	void newEscapeDist(int dist);
	
	void newMaxEscapeTime(int maxEscapeTime);

	void newBounds(int lowerX, int upperX, int lowerY, int upperY);
	
	void newInterval();
	
	void beginningBounds();
}
