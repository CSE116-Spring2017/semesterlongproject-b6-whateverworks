package UI;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

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
		int _gridFirstX = (int) e.getX();
		int _gridFirstY = (int) e.getY();
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		int _gridSecondX = (int) e.getX();
		int _gridSecondY = (int) e.getY();
		
		fracUI.setBounds(_gridFirstX, _gridFirstY, _gridSecondX, _gridSecondY);
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
