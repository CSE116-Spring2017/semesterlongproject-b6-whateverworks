package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import edu.buffalo.cse116.BurningShip;

//Changes fractal to Burning Ship

public class BurningShipListener implements ActionListener {

	private FractalUI fracUI;
	
	public BurningShipListener(FractalUI f){
		fracUI = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		BurningShip b = new BurningShip();
		fracUI.setBurningShip(b);
		fracUI.updateFractal();
	}

}
