package com.provinggrounds.sodukusolver.solver;

import java.util.HashSet;
import java.util.Set;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;

public abstract class SolverUtil {


	/**
	 * Is the gridSquareTemp in same solving area
	 * 
	 * @param gridSquare
	 * @param gridSquareTemp
	 * @return
	 */
	protected abstract boolean isGridSquareTempInSameArea(GridSquare gridSquare, GridSquare gridSquareTemp);
	
	/**
	 * Remove number from the gridSquare possibleNumber set
	 * 
	 * @param gridSquare
	 * @param gridSquareTemp
	 */
	protected void removePossibleNumberFromGridSquare(GridSquare gridSquare, GridSquare gridSquareTemp) {
		gridSquare.removePossibleNumber(gridSquareTemp.getConfirmedNumber());
	}

	/**
	 * Sets the confirmed number in the GridSquare
	 * 
	 * @param gridSquare
	 */
	protected void setConfirmedNumberInGridSquare(GridSquare gridSquare) {
		if (gridSquare.isInitialSetSizeOne()) {
			gridSquare.setConfirmedNumber(gridSquare.getConfirmedNumberFromSet());
		}
	}
	
	/**
	 * Analysis to decide if a possible value is unique to the Grid Square
	 * @param gridSquare
	 * @param grid
	 */
	protected void setValueIfGridSquareHasUnique(GridSquare gridSquare, Grid grid) {
		Set<Integer> possibleIntegersSet = new HashSet<Integer>();
		grid.getGridSquareList().stream()
				.filter(gridSquareTemp -> isGridSquareTempInSameArea(gridSquare, gridSquareTemp)
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
