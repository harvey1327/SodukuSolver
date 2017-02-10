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
				GridSquare gs = createGridSquare(x, y);
				
				//-------ForTesting------
				TEST_createGridSquare(gs);
				//-----------------------
				
				list.add(gs);
			}
		}
		grid.setGridSquareList(list);
		return grid;
	}
	
	private GridSquare createGridSquare(int x, int y){
		GridSquare gs = new GridSquare();
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
		return gs;
	}
	
	public void processChain(Grid grid){
		SolverCommand sc = getSolverCommand();
		for (int i = 1; i <= 1000; i++) {
			sc.processCommands(grid);
		}
	}
	
	private SolverCommand getSolverCommand(){
		SolverCommand sc = context.getBean("solverCommandBuilder",SolverCommandBuilder.class).buildSolverCommand();
		return sc;
	}
	
	private void TEST_createGridSquare(GridSquare gs){
		TEST_INTERNAL(6, 1, 1, gs);
		TEST_INTERNAL(7, 1, 8, gs);
		TEST_INTERNAL(8, 1, 2, gs);
		
		TEST_INTERNAL(4, 2, 8, gs);
		TEST_INTERNAL(6, 2, 4, gs);
		TEST_INTERNAL(8, 2, 7, gs);
		
		TEST_INTERNAL(1, 3, 8, gs);
		TEST_INTERNAL(2, 3, 9, gs);
		TEST_INTERNAL(6, 3, 5, gs);
		TEST_INTERNAL(7, 3, 3, gs);
		
		TEST_INTERNAL(1, 4, 3, gs);
		TEST_INTERNAL(2, 4, 8, gs);
		TEST_INTERNAL(3, 4, 2, gs);
		
		TEST_INTERNAL(7, 6, 7, gs);
		TEST_INTERNAL(8, 6, 6, gs);
		TEST_INTERNAL(9, 6, 3, gs);
		
		TEST_INTERNAL(3, 7, 8, gs);
		TEST_INTERNAL(4, 7, 9, gs);
		TEST_INTERNAL(8, 7, 4, gs);
		TEST_INTERNAL(9, 7, 5, gs);
		
		TEST_INTERNAL(2, 8, 5, gs);
		TEST_INTERNAL(4, 8, 2, gs);
		TEST_INTERNAL(6, 8, 3, gs);
		
		TEST_INTERNAL(2, 9, 7, gs);
		TEST_INTERNAL(3, 9, 9, gs);
		TEST_INTERNAL(4, 9, 4, gs);
	}
	private void TEST_INTERNAL(int x, int y, int val, GridSquare gs){
		if(gs.getX()==x&&gs.getY()==y){
			gs.setConfirmedNumber(val);
		}
	}
}
