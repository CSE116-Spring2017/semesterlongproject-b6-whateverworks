package UI;

import java.awt.Dimension;
import java.awt.image.IndexColorModel;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.SwingWorker;

import edu.buffalo.cse116.BurningShip;
import edu.buffalo.cse116.ComputePool;
import edu.buffalo.cse116.FracSwingWorker;
import edu.buffalo.cse116.Fractal;
import edu.buffalo.cse116.Julia;
import edu.buffalo.cse116.Mandelbrot;
import edu.buffalo.cse116.Multibrot;
import edu.buffalo.cse116.WorkerResult;
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
	private Dimension _dim = new Dimension(2048, 2048);
	
	//Escape Distance in use
	private int _escapeDist;
	
	private int _threads;
	
	//Max Escape Time in use
	private int _maxEscapeTime;
	
	private int _gridFirstX;
	
	private int _gridFirstY;
	
	private int _gridLastX;
	
	private int _gridLastY;
	
	private JFrame _window;
	
	private ComputePool _cp;
	
	public FractalUI(){
		
		// sets default fractal, escape distance, and color model
		_frac = new Mandelbrot();
		_escapeDist = 2;
		_maxEscapeTime = 255;
		_colorModel = ColorModelFactory.createGrayColorModel(300);
		_gridFirstX = 0;
		_gridFirstY = 0;
		_gridLastX = 2048;
		_gridLastY = 2048;
		_threads = 1;
		_cp = new ComputePool();
		
		//Creating Window
		_window = new JFrame();
		_window.setVisible(true);
		_window.setSize(2048, 2048);
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
        
        
        //Reset Option
        JMenu resetMenu = new JMenu("Reset");
        
        //Resets Zoom
        JMenuItem reset = new JMenuItem("Reset Zoom");
        reset.addActionListener(new resetListener(this));
        resetMenu.add(reset);
        
        //Thread Option
        JMenu threadMenu = new JMenu("Threads");
        
        JMenuItem changeThread = new JMenuItem("Change");
        changeThread.addActionListener(new threadListener(this));
        threadMenu.add(changeThread);
	
		//FractalPanel
		_fracPanel = new FractalPanel();
		_fracPanel.setSize(_dim);
		_cp.changePanel(_fracPanel);
		
		// adds all options to menu
		JMenuBar menuBar = new JMenuBar();
		menuBar.add(fileMenu);
		menuBar.add(fracMenu);
		menuBar.add(colorMenu);
		menuBar.add(escapeDistMenu);
		menuBar.add(maxEscapeTimeMenu);
		menuBar.add(resetMenu);
		menuBar.add(threadMenu);
		
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
		_frac.newEscapeDist(_escapeDist);
	}

	//Updates fractal and image
	public void updateFractal() {
		_fracPanel.setIndexColorModel(_colorModel);
		_cp.clearPool();
		_cp.generateFractal(2048, createThreads(_threads));
		//_window.pack();
	}

	private SwingWorker<WorkerResult, Void>[] createThreads(int threads) {
		SwingWorker<WorkerResult, Void>[] sws = new FracSwingWorker[threads];
		int endingRow = (2048 / threads);
		int sectionSize = (2048 / threads);
		int remainder = 2048 % threads;
		int startingRow = 0;
		for(int i = 0; i < threads; i++){
			if(i < threads - 1){
				FracSwingWorker fsw = new FracSwingWorker(_frac, startingRow, endingRow);
				startingRow = endingRow;
				endingRow = endingRow + sectionSize;
				sws[i] = fsw;
			}
			else{
				FracSwingWorker fsw = new FracSwingWorker(_frac, startingRow, endingRow + remainder);
				sws[i] = fsw;
			}
		}
		return sws;
	}


	//sets max escape distance
	public void setMaxEscapeTime(int escTime) {
		_maxEscapeTime = escTime;
		_frac.newMaxEscapeTime(_maxEscapeTime);
	}

	// sets bounds for the fractal
	public void setBounds(int gridFirstX, int gridFirstY, int gridSecondX, int gridSecondY) {
		if (gridFirstX > gridSecondX){
			_gridFirstX = gridSecondX;
			_gridLastX = gridFirstX;
		}
		else{
			_gridFirstX = gridFirstX;
			_gridLastX = gridSecondX;
		}
		
		if (gridFirstY > gridSecondY){
			_gridFirstY = gridSecondY;
			_gridLastY = gridFirstY;
		}
		else{
			_gridFirstY = gridFirstY;
			_gridLastY = gridSecondY;
		}
		_frac.newBounds(_gridFirstX, _gridLastX, _gridFirstY, _gridLastY);
		_frac.beginningBounds();
		_frac.newInterval();
	}
	// prints out the X and Y coordinate ranges
	public void printRange() {
		System.out.println("X coordinate range displayed: " + _gridFirstX + " - " + _gridLastX);
		System.out.println("Y coordinate range displayed: " + _gridFirstY + " - " + _gridLastY);
		
	}
	// resets the bounds
	public void reset() {
		_gridFirstX = 0;
		_gridFirstY = 0;
		_gridLastX = 2048;
		_gridLastY = 2048;
		_frac.reset();
		printRange();
	}


	public void setThreads(int threads) {
		_threads = threads;
	}

}
