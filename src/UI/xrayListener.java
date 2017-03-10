package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.IndexColorModel;

public class xrayListener implements ActionListener {

private FractalUI fracUI;
	
	public xrayListener(FractalUI f){
		fracUI = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IndexColorModel icm = ColorModelFactory.createGrayColorModel(300);
		fracUI.setColorModel(icm);
		fracUI.updateFractal();
	}

}
