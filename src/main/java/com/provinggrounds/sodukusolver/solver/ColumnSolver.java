package com.provinggrounds.sodukusolver.solver;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;

/**
 * Given any GridSquare find all other GridSquares within the Column
 * @author HARBAL
 *
 */
class ColumnSolver implements SolverInterface {
	
	@Override
	public void process(GridSquare gridSquare, Grid grid) {
		int column = gridSquare.getX();

		for(GridSquare gridSquareTemp : grid.getGridSquareList()){
			if(gridSquareTemp.getX()==column&&gridSquareTemp.getY()!=gridSquare.getY()){
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
