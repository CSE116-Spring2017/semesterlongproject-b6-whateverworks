package UI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.MouseInfo;

public class FracMouseListener implements MouseListener {
	
	private FractalUI fracUI;
	
	public FracMouseListener(FractalUI f){
		fracUI = f;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//TODO
	}

	@Override
	public void mousePressed(MouseEvent e) {
		int gridFirstX = (int) e.getX();
		int gridFirstY = (int) e.getY();
		
		fracUI.setLowerBounds(gridFirstX, gridFirstY);
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int gridLastX = (int) e.getX();
		int gridLastY = (int) e.getY();
		
		fracUI.setUpperBounds(gridLastX, gridLastY);
		fracUI.updateFractal();
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		//TODO
	}

}
