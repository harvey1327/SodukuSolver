package com.provinggrounds.sodukusolver.solver;

import com.provinggrounds.sodukusolver.domain.GridSquare;

class RowSolver implements SolverInterface {

	@Override
	public void process(GridSquare gridSquare) {
		System.out.println(this.getClass().getName()+gridSquare.getX()+","+gridSquare.getY());
	}

}
