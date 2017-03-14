package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.IndexColorModel;

public class oceanListener implements ActionListener {

//Changes color to ocean
	
private FractalUI fracUI;

        public oceanListener(FractalUI f){
                fracUI = f;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
                IndexColorModel icm = ColorModelFactory.createBluesColorModel(300);
                fracUI.setColorModel(icm);
                fracUI.updateFractal();
        }

}
