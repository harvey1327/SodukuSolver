package com.provinggrounds.sodukusolver.solver;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;

class RowSolver implements SolverInterface {

	@Override
	public void process(GridSquare gridSquare, Grid grid) {
		int row = gridSquare.getY();

		for(GridSquare gridSquareTemp : grid.getGridSquareList()){
			if(gridSquareTemp.getY()==row&&gridSquareTemp.getX()!=gridSquare.getX()){
				gridSquare.removePossibleNumber(gridSquareTemp.getConfirmedNumber());
			}
		}
		setConfirmedNumber(gridSquare);
	}
	
	private void setConfirmedNumber(GridSquare gridSquare){
		if(gridSquare.getInitialSet().size()==1){
			gridSquare.setConfirmedNumber(gridSquare.getConfirmedNumberFromSet());
		}
	}

}
