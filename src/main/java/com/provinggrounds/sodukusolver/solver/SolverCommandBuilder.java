package com.provinggrounds.sodukusolver.solver;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class SolverCommandBuilder {
	
	private ApplicationContext context = new FileSystemXmlApplicationContext("src/main/springBeanConfig/SolverCommandBuilder.xml");
	
	public SolverCommand buildSolverCommand(){
		SolverInterface row = context.getBean("rowSolver", RowSolver.class);
		SolverInterface col = context.getBean("columnSolver", ColumnSolver.class);
		SolverInterface squ = context.getBean("squareSolver", SquareSolver.class);
		
		SolverCommand sc = context.getBean("solverCommand", SolverCommand.class);
		sc.addConcreteSolver(row);
		sc.addConcreteSolver(col);
		sc.addConcreteSolver(squ);
		return sc;
	}
}
