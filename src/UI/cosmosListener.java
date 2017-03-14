package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.IndexColorModel;

//Changes color to cosmos

public class cosmosListener implements ActionListener {
	private FractalUI fracUI;
               
    public cosmosListener(FractalUI f){
                    fracUI = f;
    }
 
    @Override
    public void actionPerformed(ActionEvent e) {
    IndexColorModel icm = ColorModelFactory.createRainbowColorModel(50);
    fracUI.setColorModel(icm);
    fracUI.updateFractal();
    }
               
 
}