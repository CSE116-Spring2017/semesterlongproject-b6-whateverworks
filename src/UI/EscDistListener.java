package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

//changes escape distance

public class EscDistListener implements ActionListener {
	
	private FractalUI fracUI;
	private Scanner scanner;
	
	public EscDistListener(FractalUI f){
		fracUI = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		scanner = new Scanner(System.in);
	    System.out.print("Enter an integer for a new escape distance: ");
	    int escDist = scanner.nextInt();
	    fracUI.setEscapeDist(escDist);
	    fracUI.updateFractal();
	}

}
