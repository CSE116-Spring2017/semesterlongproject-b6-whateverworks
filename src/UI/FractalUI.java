package UI;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import edu.buffalo.cse116.BurningShip;
import edu.buffalo.cse116.Fractal;
import edu.buffalo.cse116.Julia;
import edu.buffalo.cse116.Mandelbrot;
import edu.buffalo.cse116.Multibrot;

public class FractalUI {
	
	private Fractal _frac;
	
	public FractalUI(){
		
		//Creating Window
		JFrame window = new JFrame();
		window.setVisible(true);
		window.setSize(400, 400);
		
		//File Option
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem file = new JMenuItem("Exit");
		file.addActionListener(new ExitListener());
		fileMenu.add(file);
		
		//Fractal Option
		JMenu fracMenu = new JMenu("Fractal");
		
		JMenuItem mandelbrot = new JMenuItem("Mandelbrot");
		mandelbrot.addActionListener(new MandelbrotListener());
		fracMenu.add(mandelbrot);
		
		JMenuItem julia = new JMenuItem("Julia");
		julia.addActionListener(new JuliaListener());
		fracMenu.add(julia);
		
		JMenuItem multibrot = new JMenuItem("Multibrot");
		multibrot.addActionListener(new MultibrotListener());
		fracMenu.add(multibrot);
		
		JMenuItem burningship = new JMenuItem("Burning Ship");
		burningship.addActionListener(new BurningShipListener());
		fracMenu.add(burningship);
		
		//Color Option
		JMenu colorMenu = new JMenu("Color");
		
		
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(fracMenu);
		menuBar.add(colorMenu);
		
		window.setJMenuBar(menuBar);
		window.setVisible(true);
		window.setSize(400, 400);
		
		
		
		
	}
	
	public void setMandelbrot(Mandelbrot m){
		_frac = m;
	}
	
	public void setMultibrot(Multibrot m){
		_frac = m;
	}

	public void setBurningShip(BurningShip b) {
		_frac = b;	
	}

	public void setJulia(Julia j) {
		_frac = j;	
	}


}
