package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.buffalo.cse116.BurningShip;

public class BurningShipListener implements ActionListener {

	private FractalUI fracUI;

	@Override
	public void actionPerformed(ActionEvent e) {
		BurningShip j = new BurningShip();
		fracUI.setBurningShip(j);
	}

}
