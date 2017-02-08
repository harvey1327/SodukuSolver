package com.provinggrounds.sodukusolver.handler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;
import com.provinggrounds.sodukusolver.solver.SolverCommand;
import com.provinggrounds.sodukusolver.solver.SolverCommandBuilder;

public class SodukuSolverHandler {
	
	private ApplicationContext context = new FileSystemXmlApplicationContext("src/main/springBeanConfig/SodukuSolverHandler.xml");

	public Grid createGrid(int size){
		Grid grid = new Grid();
		List<GridSquare> list = new ArrayList<GridSquare>();
		for(int y=1;y<=size;y++){
			for(int x=1;x<=size;x++){
				GridSquare gs = new GridSquare();
				gs.setX(x);
				gs.setY(y);
				list.add(gs);
			}
		}
		grid.setGridSquareList(list);
		return grid;
	}
	
	public void processChain(Grid grid){
		//Just one iteration over the Grid
		for(GridSquare gs : grid.getGridSquareList()){
			SolverCommand sc = getSolverCommand();
			sc.processCommands(gs, grid);
		}
	}
	
	private SolverCommand getSolverCommand(){
		SolverCommand sc = context.getBean("solverCommandBuilder",SolverCommandBuilder.class).buildSolverCommand();
		return sc;
	}
}
