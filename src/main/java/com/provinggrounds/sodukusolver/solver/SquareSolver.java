package com.provinggrounds.sodukusolver.solver;

import java.util.HashSet;
import java.util.Set;

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
		grid.getGridSquareList().stream().filter(gridSquareTemp -> isGridSquareTempInSameParent(gridSquare, gridSquareTemp))
				.forEach(gridSquareTemp -> removePossibleNumberFromGridSquare(gridSquare, gridSquareTemp));
		setConfirmedNumberInGridSquare(gridSquare);
		if(!gridSquare.hasConfirmed()){
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
	private boolean isGridSquareTempInSameParent(GridSquare gridSquare, GridSquare gridSquareTemp) {
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
	private void setConfirmedNumberInGridSquare(GridSquare gridSquare) {
		if (gridSquare.hasConfirmed()) {
			gridSquare.setConfirmedNumber(gridSquare.getConfirmedNumberFromSet());
		}
	}
	
	private void setValueIfGridSquareHasUnique(GridSquare gridSquare, Grid grid) {
		Set<Integer> possibleIntegersSet = new HashSet<Integer>();
		grid.getGridSquareList().stream()
				.filter(gridSquareTemp -> isGridSquareTempInSameParent(gridSquare, gridSquareTemp)
						&& !gridSquareTemp.hasConfirmed())
				.forEach(gridSquareTemp->possibleIntegersSet.addAll(gridSquareTemp.getInitialSet()));

		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		gridSquare.getInitialSet().stream().filter(number -> !possibleIntegersSet.contains(number))
				.forEach(number -> uniqueNumbers.add(number));

		if (uniqueNumbers.size() == 1) {
			gridSquare.setConfirmedNumber(uniqueNumbers.toArray(new Integer[1])[0]);
		}
	}
}
