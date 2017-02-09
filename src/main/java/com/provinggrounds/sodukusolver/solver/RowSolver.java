package com.provinggrounds.sodukusolver.solver;

import java.util.HashSet;
import java.util.Set;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;

/**
 * Attempts to solve the GridSquare by looking at possible solution from other
 * GridSquares in the same row
 * 
 * @author HARBAL
 *
 */
class RowSolver implements SolverInterface {

	@Override
	public void process(GridSquare gridSquare, Grid grid) {
		grid.getGridSquareList().stream().filter(gridSquareTemp -> isGridSquareTempInSameRow(gridSquare, gridSquareTemp))
				.forEach(gridSquareTemp -> removePossibleNumberFromGridSquare(gridSquare, gridSquareTemp));
		setConfirmedNumberInGridSquare(gridSquare);
		if(!gridSquare.isConfirmed()){
			setValueIfGridSquareHasUnique(gridSquare, grid);
		}
	}

	/**
	 * Is the gridSquareTemp in same row as gridSquare and not the same grid
	 * 
	 * @param gridSquare
	 * @param gridSquareTemp
	 * @return
	 */
	private boolean isGridSquareTempInSameRow(GridSquare gridSquare, GridSquare gridSquareTemp) {
		return gridSquareTemp.getY() == gridSquare.getY() && gridSquareTemp.getX() != gridSquare.getX();
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
	private void setConfirmedNumberInGridSquare(GridSquare gridSquare) {
		if (gridSquare.isInitialSetSizeOne()) {
			gridSquare.setConfirmedNumber(gridSquare.getConfirmedNumberFromSet());
		}
	}
	
	private void setValueIfGridSquareHasUnique(GridSquare gridSquare, Grid grid) {
		Set<Integer> possibleIntegersSet = new HashSet<Integer>();
		grid.getGridSquareList().stream()
				.filter(gridSquareTemp -> isGridSquareTempInSameRow(gridSquare, gridSquareTemp)
						&& !gridSquareTemp.isConfirmed())
				.forEach(gridSquareTemp->possibleIntegersSet.addAll(gridSquareTemp.getInitialSet()));

		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		gridSquare.getInitialSet().stream().filter(number -> !possibleIntegersSet.contains(number))
				.forEach(number -> uniqueNumbers.add(number));

		if (uniqueNumbers.size() == 1) {
			gridSquare.setConfirmedNumber(uniqueNumbers.toArray(new Integer[1])[0]);
		}
	}
}
