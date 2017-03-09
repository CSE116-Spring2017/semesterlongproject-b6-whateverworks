package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import edu.buffalo.cse116.Multibrot;

public class MultibrotListener implements ActionListener {

	private FractalUI fracUI;

	@Override
	public void actionPerformed(ActionEvent e) {
		Multibrot j = new Multibrot();
		fracUI.setMultibrot(j);
	}

}

