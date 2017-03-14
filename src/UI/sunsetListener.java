
package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.IndexColorModel;

//Changes color to sunset

public class sunsetListener implements ActionListener {

private FractalUI fracUI;
	
	public sunsetListener(FractalUI f){
		fracUI = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IndexColorModel icm = ColorModelFactory.createRainbowColorModel(257);
		fracUI.setColorModel(icm);
		fracUI.updateFractal();
	}

}
