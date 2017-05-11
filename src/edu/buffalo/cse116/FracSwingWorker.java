package edu.buffalo.cse116;

import javax.swing.SwingWorker;

public class FracSwingWorker extends SwingWorker<WorkerResult, Void> {
	
	private Fractal _frac;
	private int _startingRow;
	private int _endingRow;
	
	//uses values from SwingWoker method in Frac UI
	public FracSwingWorker(Fractal f, int startingRow, int endingRow){
		_frac = f;
		_startingRow = startingRow;
		_endingRow = endingRow;
	}
	
	//passes values to be used in ComputePool
	@Override
	protected WorkerResult doInBackground() throws Exception {
		return new WorkerResult(_startingRow, _frac.calcFrac(_startingRow, _endingRow));
	}

}
