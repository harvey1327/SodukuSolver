package com.provinggrounds.sodukusolver.solver;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;
/**
 * Given any GridSquare we want to find out the parent square it resides in get all other GridSquares 
 * @author HARBAL
 *
 */
class SquareSolver implements SolverInterface {

	@Override
	public void process(GridSquare gridSquare, Grid grid) {
		System.out.println(this.getClass().getName()+gridSquare.getX()+","+gridSquare.getY());
	}
}
