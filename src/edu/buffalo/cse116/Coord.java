package edu.buffalo.cse116;

public class Coord {
	
	double _x;
	double _y;
	
	public Coord(double x, double y){
		_x = x;
		_y = y;
	}
	
	public void setCoord(double x, double y){
		_x = x;
		_y = y;
	}
	
	public double x(){
		return _x;
	}
	
	public double y(){
		return _y;
	}

}
