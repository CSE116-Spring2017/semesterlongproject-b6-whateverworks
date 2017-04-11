package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class resetListener implements ActionListener{
	
	private FractalUI fracUI;
	
	
	public resetListener(FractalUI f){
		fracUI = f;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		fracUI.reset();
		fracUI.updateFractal();
	}

}