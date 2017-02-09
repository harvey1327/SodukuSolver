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
class ColumnSolver extends SolverUtil implements SolverInterface {

	@Override
	public void process(GridSquare gridSquare, Grid grid) {
		grid.getGridSquareList().stream().filter(gridSquareTemp -> isGridSquareTempInSameArea(gridSquare, gridSquareTemp))
				.forEach(gridSquareTemp -> removePossibleNumberFromGridSquare(gridSquare, gridSquareTemp));
		setConfirmedNumberInGridSquare(gridSquare);
		if(!gridSquare.isConfirmed()){
			setValueIfGridSquareHasUnique(gridSquare, grid);
		}
	}

	@Override
	protected boolean isGridSquareTempInSameArea(GridSquare gridSquare, GridSquare gridSquareTemp) {
		int x=gridSquare.getX();
		int y=gridSquare.getY();
		return gridSquareTemp.getX() == x && gridSquareTemp.getY() != y;
	}
}
