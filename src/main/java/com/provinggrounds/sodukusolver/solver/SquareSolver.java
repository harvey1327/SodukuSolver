package com.provinggrounds.sodukusolver.solver;

import com.provinggrounds.sodukusolver.domain.GridSquare;

class SquareSolver implements SolverInterface {
	
	private GridSquare gridSquare;
	
	SquareSolver(GridSquare gridSquare){
		this.gridSquare=gridSquare;
	}

	@Override
	public void process() {
		System.out.println(this.getClass().getName()+gridSquare.getX()+","+gridSquare.getY());
	}
}
