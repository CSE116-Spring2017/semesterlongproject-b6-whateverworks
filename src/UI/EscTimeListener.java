package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.InputMismatchException;
import java.util.Scanner;

//changes escape distance

public class EscTimeListener implements ActionListener {

	private FractalUI fracUI;
	private Scanner scanner;

	public EscTimeListener(FractalUI f){
		fracUI = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		scanner = new Scanner(System.in);
		System.out.print("Enter an integer for a new escape time: ");
		int escTime = 0;

		// displays error if invalid entry
		try{
			escTime = scanner.nextInt();
		}
		catch(InputMismatchException ime){
			System.out.println("Invalid input!");
			escTime = 255;
		}

		if(escTime < 1){
			System.out.println("Invalid input!");
			escTime = 255;
		}

		if(escTime > 255){
			System.out.println("Invalid input!");
			escTime = 255;
		}

		fracUI.setMaxEscapeTime(escTime);
		fracUI.updateFractal();
	}
}
 
