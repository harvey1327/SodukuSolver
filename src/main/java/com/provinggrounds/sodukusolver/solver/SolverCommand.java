package com.provinggrounds.sodukusolver.solver;

import java.util.ArrayList;
import java.util.List;

import com.provinggrounds.sodukusolver.domain.Grid;

public class SolverCommand {

	private List<SolverInterface> solverList = new ArrayList<SolverInterface>();
	
	void addConcreteSolver(SolverInterface solverInterface){
		solverList.add(solverInterface);
	}
	
	public void processCommands(Grid grid){
		solverList.forEach(solverInterface->solverInterface.process(grid));
	}
}
