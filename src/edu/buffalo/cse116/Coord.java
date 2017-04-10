package edu.buffalo.cse116;

//Coordinate class for escape time calculation

public class Coord {
	
	double _x;
	double _y;
	
	//Allows points of double
	public Coord(double x, double y){
		_x = x;
		_y = y;
	}
	
	//returns x value
	public double x(){
		return _x;
	}
	
	//returns y value
	public double y(){
		return _y;
	}

	
}
