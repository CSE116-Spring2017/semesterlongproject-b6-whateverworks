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
	
	public FractalUI(){
		
		_frac = new Mandelbrot();
		_escapeDist = 2;
		_colorModel = ColorModelFactory.createGrayColorModel(300);
		
		
		//Creating Window
		JFrame window = new JFrame();
		window.setVisible(true);
		window.setSize(512, 512);
		
		//File Option
		JMenu fileMenu = new JMenu("File");
		
		JMenuItem file = new JMenuItem("Exit");
		file.addActionListener(new ExitListener());
		fileMenu.add(file);
		
		//Fractal Option
		JMenu fracMenu = new JMenu("Fractal");
		
		JMenuItem mandelbrot = new JMenuItem("Mandelbrot (default)");
		mandelbrot.addActionListener(new MandelbrotListener(this));
		fracMenu.add(mandelbrot);
		
		JMenuItem julia = new JMenuItem("Julia");
		julia.addActionListener(new JuliaListener(this));
		fracMenu.add(julia);
		
		JMenuItem multibrot = new JMenuItem("Multibrot");
		multibrot.addActionListener(new MultibrotListener(this));
		fracMenu.add(multibrot);
		
		JMenuItem burningship = new JMenuItem("Burning Ship");
		burningship.addActionListener(new BurningShipListener(this));
		fracMenu.add(burningship);
		
		//Color Option
		JMenu colorMenu = new JMenu("Color");
		
		JMenuItem xray = new JMenuItem("X-Ray (default)");
		xray.addActionListener(new xrayListener(this));
		colorMenu.add(xray);
		
		JMenuItem ocean = new JMenuItem("Ocean");
        ocean.addActionListener(new oceanListener(this));
        colorMenu.add(ocean);
        
        JMenuItem cosmos = new JMenuItem("Cosmos");
        cosmos.addActionListener(new cosmosListener(this));
        colorMenu.add(cosmos);
        

        JMenuItem sunset = new JMenuItem("Sunset");
        sunset.addActionListener(new sunsetListener(this));
        colorMenu.add(sunset);
        
        //Escape Distance Option
        JMenu escapeDistMenu = new JMenu("Escape Distance");
        
        JMenuItem change = new JMenuItem("Change");
        change.addActionListener(new EscDistListener(this));
        escapeDistMenu.add(change);
        
        
	
		//FractalPanel
		_fracPanel = new FractalPanel();
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(fracMenu);
		menuBar.add(colorMenu);
		menuBar.add(escapeDistMenu);
		
		window.setJMenuBar(menuBar);
		window.add(_fracPanel);
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
	
	public void setColorModel(IndexColorModel icm){
		_colorModel = icm;
	}
	
	public void setEscapeDist(int ed){
		_escapeDist = ed;
	}

	public void updateFractal() {
		_fracPanel.setSize(_dim);
		_fracPanel.setIndexColorModel(_colorModel);
		_frac.newEscapeDist(_escapeDist);
		_fracPanel.updateImage(_frac.calcFrac());
	}
	
}
