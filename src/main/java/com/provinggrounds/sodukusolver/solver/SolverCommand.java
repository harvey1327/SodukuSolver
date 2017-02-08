package com.provinggrounds.sodukusolver.solver;

import java.util.ArrayList;
import java.util.List;

public class SolverCommand {

	private List<SolverInterface> solverList = new ArrayList<SolverInterface>();
	
	void addConcreteSolver(SolverInterface solverInterface){
		solverList.add(solverInterface);
	}
	
	public void processCommands(){
		for(SolverInterface solverInterface : solverList){
			solverInterface.process();
		}
	}
}
