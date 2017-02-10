package com.provinggrounds.sodukusolver.solver;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;

/**
 * Removes Possible numbers for the current row
 * @author HARBAL
 *
 */
class RowSolver implements SolverInterface {

	@Override
	public void process(GridSquare gridSquare, Grid grid) {
		grid.getGridSquareList().stream()
		.filter(gridSquareTemp -> isGridSquareTempInSameRow(gridSquare, gridSquareTemp))
		.forEach(gridSquareTemp -> removePossibleNumberFromGridSquare(gridSquare, gridSquareTemp));
	}

	protected boolean isGridSquareTempInSameRow(GridSquare gridSquare, GridSquare gridSquareTemp) {
		int x = gridSquare.getX();
		int y = gridSquare.getY();
		return gridSquareTemp.getY() == y && gridSquareTemp.getX() != x;
	}
	
	/**
	 * Remove number from the gridSquare possibleNumber set
	 * 
	 * @param gridSquare
	 * @param gridSquareTemp
	 */
	private void removePossibleNumberFromGridSquare(GridSquare gridSquare, GridSquare gridSquareTemp) {
		gridSquare.removePossibleNumber(gridSquareTemp.getConfirmedNumber());
	}
}
