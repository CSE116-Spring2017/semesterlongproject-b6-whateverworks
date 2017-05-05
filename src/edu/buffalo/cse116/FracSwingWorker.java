package edu.buffalo.cse116;

import javax.swing.SwingWorker;

public class FracSwingWorker extends SwingWorker<WorkerResult, Void> {
	
	private Fractal _frac;
	private int _startingRow;
	private int _endingRow;
	
	public FracSwingWorker(Fractal f, int startingRow, int endingRow){
		_frac = f;
		_startingRow = startingRow;
		_endingRow = endingRow;
	}

	@Override
	protected WorkerResult doInBackground() throws Exception {
		_frac.setStartAndEnd(_startingRow, _endingRow);
		return new WorkerResult(_startingRow, _frac.calcFrac());
	}

}
