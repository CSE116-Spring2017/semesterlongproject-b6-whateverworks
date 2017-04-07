package UI;

import java.awt.Dimension;
import java.awt.image.IndexColorModel;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import edu.buffalo.cse116.BurningShip;
import edu.buffalo.cse116.Fractal;
import edu.buffalo.cse116.Julia;
import edu.buffalo.cse116.Mandelbrot;
import edu.buffalo.cse116.Multibrot;
import edu.buffalo.fractal.FractalPanel;

//responsible for updating and displaying fractal

public class FractalUI {
	
	//Fractal in use
	private Fractal _frac;
	
	//Fractal Panel
	private FractalPanel _fracPanel;
	
	//Color model
	private IndexColorModel _colorModel;
	
	//Dimension of fractal
	private Dimension _dim = new Dimension(512,512);
	
	//Escape Distance in use
	private int _escapeDist;
	
	//Max Escape Time in use
	private int _maxEscapeTime;
	
	private int _gridFirstX;
	
	private int _gridFirstY;
	
	private int _gridLastX;
	
	private int _gridLastY;
	
	private JFrame _window;
	
	public FractalUI(){
		
		// sets default fractal, escape distance, and color model
		_frac = new Mandelbrot();
		_escapeDist = 2;
		_maxEscapeTime = 255;
		_colorModel = ColorModelFactory.createGrayColorModel(300);
		_gridFirstX = 0;
		_gridFirstY = 0;
		_gridLastX = 512;
		_gridLastY = 512;
		
		//Creating Window
		_window = new JFrame();
		_window.setVisible(true);
		_window.setSize(512, 512);
		_window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//File Option
		JMenu fileMenu = new JMenu("File");
		
		//Exit for file
		JMenuItem file = new JMenuItem("Exit");
		file.addActionListener(new ExitListener());
		fileMenu.add(file);
		
		
		//Fractal Option
		JMenu fracMenu = new JMenu("Fractal");
		
		//Mandelbrot for Fractal
		JMenuItem mandelbrot = new JMenuItem("Mandelbrot (default)");
		mandelbrot.addActionListener(new MandelbrotListener(this));
		fracMenu.add(mandelbrot);
		
		//Julia for Fractal
		JMenuItem julia = new JMenuItem("Julia");
		julia.addActionListener(new JuliaListener(this));
		fracMenu.add(julia);
		
		//Multibrot for Fractal
		JMenuItem multibrot = new JMenuItem("Multibrot");
		multibrot.addActionListener(new MultibrotListener(this));
		fracMenu.add(multibrot);
		
		//BurningShipbrot for Fractal
		JMenuItem burningship = new JMenuItem("Burning Ship");
		burningship.addActionListener(new BurningShipListener(this));
		fracMenu.add(burningship);
		
		
		//Color Option
		JMenu colorMenu = new JMenu("Color");
		
		//Xray for color
		JMenuItem xray = new JMenuItem("X-Ray (default)");
		xray.addActionListener(new xrayListener(this));
		colorMenu.add(xray);
		
		//Ocean for color
		JMenuItem ocean = new JMenuItem("Ocean");
        ocean.addActionListener(new oceanListener(this));
        colorMenu.add(ocean);
        
        //Cosmos for color
        JMenuItem cosmos = new JMenuItem("Cosmos");
        cosmos.addActionListener(new cosmosListener(this));
        colorMenu.add(cosmos);
        
        //Sunset for color
        JMenuItem sunset = new JMenuItem("Sunset");
        sunset.addActionListener(new sunsetListener(this));
        colorMenu.add(sunset);
        
        
        //Escape Distance Option
        JMenu escapeDistMenu = new JMenu("Escape Distance");
        
        //Change for escape distance
        JMenuItem change = new JMenuItem("Change");
        change.addActionListener(new EscDistListener(this));
        escapeDistMenu.add(change);
        
        
        //Max Escape Time Option
        JMenu maxEscapeTimeMenu = new JMenu("Max Escape Time");
        
        //Change for escape time
        JMenuItem changeEscT = new JMenuItem("Change");
        changeEscT.addActionListener(new EscTimeListener(this));
        maxEscapeTimeMenu.add(changeEscT);
        
        
	
		//FractalPanel
		_fracPanel = new FractalPanel();
		
		// adds all options to menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(fracMenu);
		menuBar.add(colorMenu);
		menuBar.add(escapeDistMenu);
		menuBar.add(maxEscapeTimeMenu);
		
		// adds all parts to window
		_window.setJMenuBar(menuBar);
		_window.add(_fracPanel);
		_window.setVisible(true);
		_window.setSize(400, 400);	
		
		
		_fracPanel.addMouseListener(new FracMouseListener(this));
	}
	
	
	//sets fractal as Mandelbrot
	public void setMandelbrot(Mandelbrot m){
		_frac = m;
	}
	
	//sets fractal as Multibrot
	public void setMultibrot(Multibrot m){
		_frac = m;
	}

	//sets fractal as BurningShip
	public void setBurningShip(BurningShip b) {
		_frac = b;	
	}

	//sets fractal as Julia
	public void setJulia(Julia j) {
		_frac = j;	
	}
	
	//sets color model
	public void setColorModel(IndexColorModel icm){
		_colorModel = icm;
	}
	
	//sets escape distance
	public void setEscapeDist(int ed){
		_escapeDist = ed;
	}

	//Updates fractal and image
	public void updateFractal() {
		_fracPanel.setSize(_dim);
		_fracPanel.setIndexColorModel(_colorModel);
		_frac.newEscapeDist(_escapeDist);
		_frac.newMaxEscapeTime(_maxEscapeTime);
		_frac.newBounds(_gridFirstX, _gridLastX, _gridFirstY, _gridLastY);
		_frac.beginningBounds();
		_frac.newInterval();
		_fracPanel.updateImage(_frac.calcFrac());
		_window.pack();
	}

	//sets max escape distance
	public void setMaxEscapeTime(int escTime) {
		_maxEscapeTime = escTime;
	}


	public void setLowerBounds(int gridFirstX, int gridFirstY) {
		_gridFirstX = gridFirstX;
		_gridFirstY = gridFirstY;
	}


	public void setUpperBounds(int gridLastX, int gridLastY) {
		_gridLastX = gridLastX;
		_gridLastY = gridLastY;
	}

}
