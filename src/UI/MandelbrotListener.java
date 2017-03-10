package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.buffalo.cse116.Mandelbrot;

public class MandelbrotListener implements ActionListener {
	
	private FractalUI fracUI;
	
	public MandelbrotListener(FractalUI f){
		fracUI = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Mandelbrot m = new Mandelbrot();
		fracUI.setMandelbrot(m);
		fracUI.updateFractal();
	}

}