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
class SquareSolver extends SolverUtil implements SolverInterface {

	@Override
	public void process(GridSquare gridSquare, Grid grid) {
		grid.getGridSquareList().stream().filter(gridSquareTemp -> isGridSquareTempInSameArea(gridSquare, gridSquareTemp))
				.forEach(gridSquareTemp -> removePossibleNumberFromGridSquare(gridSquare, gridSquareTemp));
		setConfirmedNumberInGridSquare(gridSquare);
		if(!gridSquare.isConfirmed()){
			//setValueIfGridSquareHasUnique(gridSquare, grid);
		}
	}

	@Override
	protected boolean isGridSquareTempInSameArea(GridSquare gridSquare, GridSquare gridSquareTemp) {
		int x = gridSquare.getX();
		int y = gridSquare.getY();
		int parent = gridSquare.getParent();
		return gridSquareTemp.getParent() == parent && gridSquareTemp.getX() != x && gridSquareTemp.getY() != y;
	}
}
