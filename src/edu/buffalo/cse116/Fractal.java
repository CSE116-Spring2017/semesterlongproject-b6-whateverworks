package edu.buffalo.cse116;

public interface Fractal {
	
	int[][] calcFrac();
	
	int escapeTime(Coord calc);
	
	double getXCoordinate(int row);
	
	double getYCoordinate(int column);
	
	void newEscapeDist(int dist);

}
