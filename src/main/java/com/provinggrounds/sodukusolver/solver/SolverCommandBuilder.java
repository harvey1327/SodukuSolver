package com.provinggrounds.sodukusolver.solver;

import com.provinggrounds.sodukusolver.domain.GridSquare;

public class SolverCommandBuilder {

	public SolverCommand buildSolverCommand(GridSquare gridSquare){
		SolverInterface row = new RowSolver(gridSquare);
		SolverInterface col = new ColumnSolver(gridSquare);
		SolverInterface squ = new SquareSolver(gridSquare);
		
		SolverCommand sc = new SolverCommand();
		sc.addConcreteSolver(row);
		sc.addConcreteSolver(col);
		sc.addConcreteSolver(squ);
		return sc;
	}
}
