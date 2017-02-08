package com.provinggrounds.sodukusolver.solver;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;

/**
 * Attempts to solve the GridSquare by looking at possible solution from other
 * GridSquares in the same column
 * 
 * @author HARBAL
 *
 */
class ColumnSolver implements SolverInterface {

	@Override
	public void process(GridSquare gridSquare, Grid grid) {
		grid.getGridSquareList().stream().filter(gridSquareTemp -> inSameColumn(gridSquare, gridSquareTemp))
				.forEach(gridSquareTemp -> removePossibleNumberFromGridSquare(gridSquare, gridSquareTemp));
		setConfirmedNumber(gridSquare);
	}

	/**
	 * Is the gridSquareTemp in same row as gridSquare and not the same grid
	 * 
	 * @param gridSquare
	 * @param gridSquareTemp
	 * @return
	 */
	private boolean inSameColumn(GridSquare gridSquare, GridSquare gridSquareTemp) {
		return gridSquareTemp.getX() == gridSquare.getX() && gridSquareTemp.getY() != gridSquare.getY();
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

	/**
	 * Sets the confirmed number in the GridSquare
	 * 
	 * @param gridSquare
	 */
	private void setConfirmedNumber(GridSquare gridSquare) {
		if (gridSquare.getInitialSet().size() == 1) {
			gridSquare.setConfirmedNumber(gridSquare.getConfirmedNumberFromSet());
		}
	}
}
