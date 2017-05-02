package UI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

// records and implements the mouse movement

public class FracMouseListener implements MouseListener {
	
	private FractalUI fracUI;
	private int _gridFirstX, _gridFirstY, _gridSecondX, _gridSecondY;
	
	public FracMouseListener(FractalUI f){
		fracUI = f;
		_gridFirstX = 0;
		_gridFirstY = 0;
		_gridSecondX = 0;
		_gridSecondY = 0;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		//TODO
	}

	@Override
	public void mousePressed(MouseEvent e) {
		_gridFirstX = e.getX();
		_gridFirstY = e.getY();
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		_gridSecondX = e.getX();
		_gridSecondY = e.getY();
		
		fracUI.setBounds(_gridFirstX, _gridFirstY, _gridSecondX, _gridSecondY);
		fracUI.printRange();
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
