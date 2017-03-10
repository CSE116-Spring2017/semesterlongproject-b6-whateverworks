package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.buffalo.cse116.Julia;

public class JuliaListener implements ActionListener {

	private FractalUI fracUI;
	
	public JuliaListener(FractalUI f){
		fracUI = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Julia j = new Julia();
		fracUI.setJulia(j);
		fracUI.updateFractal();
	}

}
