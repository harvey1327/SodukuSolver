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
				//TODO Refactor
				if(y>=1&&y<=3){
					if(x>=1&&x<=3){
						gs.setParent(1);
					} else if(x>=4&&x<=6){
						gs.setParent(2);
					}else if(x>=7&&x<=9){
						gs.setParent(3);
					}
				} else if(y>=4&&y<=6){
					if(x>=1&&x<=3){
						gs.setParent(4);
					} else if(x>=4&&x<=6){
						gs.setParent(5);
					}else if(x>=7&&x<=9){
						gs.setParent(6);
					}
				}else if(y>=7&&y<=9){
					if(x>=1&&x<=3){
						gs.setParent(7);
					} else if(x>=4&&x<=6){
						gs.setParent(8);
					}else if(x>=7&&x<=9){
						gs.setParent(9);
					}
				}
				
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
		SolverCommand sc = getSolverCommand();
		grid.getGridSquareList().forEach(gridSquare->sc.processCommands(gridSquare, grid));
	}
	
	private SolverCommand getSolverCommand(){
		SolverCommand sc = context.getBean("solverCommandBuilder",SolverCommandBuilder.class).buildSolverCommand();
		return sc;
	}
}
