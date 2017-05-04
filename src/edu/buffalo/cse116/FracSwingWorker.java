package edu.buffalo.cse116;

import javax.swing.SwingWorker;

public class FracSwingWorker extends SwingWorker<WorkerResult, Void> {
	
	private Fractal _frac;
	
	public FracSwingWorker(Fractal f){
		_frac = f;
	}

	@Override
	protected WorkerResult doInBackground() throws Exception {
		
		return null;
	}

}
