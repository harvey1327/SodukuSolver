package com.provinggrounds.sodukusolver.solver;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;


/**
 * Given any GridSquare we want to find out the parent square it resides in get
 * all other GridSquares
 * 
 * @author HARBAL
 *
 */
class SquareSolver implements SolverInterface {

	@Override
	public void process(GridSquare gridSquare, Grid grid) {
		grid.getGridSquareList().stream().filter(gridSquareTemp -> inSameSquare(gridSquare, gridSquareTemp))
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
	private boolean inSameSquare(GridSquare gridSquare, GridSquare gridSquareTemp) {
		int x = gridSquare.getX();
		int y = gridSquare.getY();
		int parent = gridSquare.getParent();
		return gridSquareTemp.getParent() == parent && gridSquareTemp.getX() != x && gridSquareTemp.getY() != y;
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
