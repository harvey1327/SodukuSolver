package com.provinggrounds.sodukusolver.solver;

import java.util.ArrayList;
import java.util.List;

import com.provinggrounds.sodukusolver.domain.GridSquare;

public class SolverCommand {

	private List<SolverInterface> solverList = new ArrayList<SolverInterface>();
	
	void addConcreteSolver(SolverInterface solverInterface){
		solverList.add(solverInterface);
	}
	
	public void processCommands(GridSquare gridSquare){
		for(SolverInterface solverInterface : solverList){
			solverInterface.process(gridSquare);
		}
	}
}
