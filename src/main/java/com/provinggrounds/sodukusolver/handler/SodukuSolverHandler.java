package com.provinggrounds.sodukusolver.handler;

import java.util.ArrayList;
import java.util.List;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;
import com.provinggrounds.sodukusolver.solver.SolverCommand;
import com.provinggrounds.sodukusolver.solver.SolverCommandBuilder;

public class SodukuSolverHandler {

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
			SolverCommand sc = getSolverCommand(gs);
			sc.processCommands();
		}
	}
	
	private SolverCommand getSolverCommand(GridSquare gridSquare){
		SolverCommand sc = new SolverCommandBuilder().buildSolverCommand(gridSquare);
		return sc;
	}
}
