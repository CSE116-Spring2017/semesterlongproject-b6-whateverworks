package edu.buffalo.cse116;

public class Julia {
	
	int[][] _grid = new int[512][512];

	public Julia(){
		
		for (int row = 0; row < 512; row++){
			for (int column = 0; column < 512; column++){
				Coord c = new Coord((-1.7 + (row * 0.006640625)), (-1.0 + (column * 0.00390625)));
				_grid[row][column] = escapeTime(c);
			}
		}
	}
		
	public int escapeTime(Coord calc){
		
		double xCalc = calc.x();
		
		double yCalc = calc.y();
		
		double dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow(yCalc - 0, 2));
		
		int passes = 0;
		
		while(dist <= 2 && passes < 255){
			
			xCalc = Math.pow(xCalc, 2) - Math.pow(yCalc, 2) + xCalc;
			
			yCalc = 2 * xCalc * yCalc + yCalc;
			
			passes = passes + 1;
			
			dist = Math.sqrt(Math.pow((xCalc - 0), 2) + Math.pow(yCalc - 0, 2));
		}
		
		return passes;
	}
	
	
	public int gridEscapeTime(int row, int column){
		
		return _grid[row][column];
	}

	
	public int col(Coord y) { 	//allows us to plug in a coord to test
		int column = 0; 		//set up a variable that can return our col
		for (int row = 0; row <= 512; row++){	//iterates through our array 
			for (int col = 0; column <= 512; column++){
				if(escapeTime(y) == _grid[row][col]){	//the coord we want to test goes through Steve's method and gets  
					column = col;						//value of escapetime that is originally stored in our array
				}										//the if statement matches up that tested value with 
			}											//the value already in the grid and returns the column
		}
		return column;
	}
		
}
	
