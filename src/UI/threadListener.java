package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Scanner;

public class threadListener implements ActionListener {

	private FractalUI fracUI;
	private Scanner scanner;
	
	public threadListener(FractalUI f){
		fracUI = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		scanner = new Scanner(System.in);
	    System.out.print("Enter an integer between 1-128: ");
	    int threads = 0;
	    
	    // displays error if invalid entry
	    try{
	    	threads = scanner.nextInt();
	    }
	    catch(InputMismatchException ime){
	    	System.out.println("Invalid input!");
	    	threads = 1;
	    }
	    
	    if(threads < 1 || threads > 128){
	    	System.out.println("Invalid input!");
	    	threads = 1;
	    }
	    
	    fracUI.setThreads(threads);
	    fracUI.updateFractal();
	}

}
