package com.provinggrounds.sodukusolver.solver;

import com.provinggrounds.sodukusolver.domain.GridSquare;

class RowSolver implements SolverInterface {
	
	private GridSquare gridSquare;
	
	RowSolver(GridSquare gridSquare){
		this.gridSquare=gridSquare;
	}

	@Override
	public void process() {
		System.out.println(this.getClass().getName()+gridSquare.getX()+","+gridSquare.getY());
	}

}
