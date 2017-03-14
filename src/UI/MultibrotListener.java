package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.buffalo.cse116.Multibrot;

//Changes fractal to Multibrot

public class MultibrotListener implements ActionListener {

	private FractalUI fracUI;
	
	public MultibrotListener(FractalUI f){
		fracUI = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Multibrot m = new Multibrot();
		fracUI.setMultibrot(m);
		fracUI.updateFractal();
	}

}