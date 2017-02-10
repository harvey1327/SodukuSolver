package com.provinggrounds.sodukusolver.solver;

import java.util.ArrayList;
import java.util.List;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;

public class SolverUtil {

	protected List<GridSquare> getTempGSListForSquare(int mainX, int mainY, int mainParent, Grid grid){
		List<GridSquare> tempGSList = new ArrayList<GridSquare>();
		for(GridSquare tempGS : grid.getGridSquareList()){
			if(isGridSquareTempInSameSquare(mainX, mainY, mainParent, tempGS)){
				tempGSList.add(tempGS);
			}
		}
		return tempGSList;
	}

	private boolean isGridSquareTempInSameSquare(int mainX, int mainY, int mainParent, GridSquare tempGS) {
		return tempGS.getParent() == mainParent && tempGS.getX() != mainX && tempGS.getY() != mainY;
	}
	
	protected List<GridSquare> getTempGSListForColumn(int mainX, int mainY, Grid grid){
		List<GridSquare> tempGSList = new ArrayList<GridSquare>();
		for(GridSquare tempGS : grid.getGridSquareList()){
			if(isGridSquareTempInSameColumn(mainX, mainY, tempGS)){
				tempGSList.add(tempGS);
			}
		}
		return tempGSList;
	}
		
	private boolean isGridSquareTempInSameColumn(int mainX, int mainY, GridSquare tempGS) {
		return tempGS.getX()==mainX&&tempGS.getY()!=mainY;
	}
	
	protected List<GridSquare> getTempGSListForRow(int mainX, int mainY, Grid grid){
		List<GridSquare> tempGSList = new ArrayList<GridSquare>();
		for(GridSquare tempGS : grid.getGridSquareList()){
			if(isGridSquareTempInSameRow(mainX, mainY, tempGS)){
				tempGSList.add(tempGS);
			}
		}
		return tempGSList;
	}
	
	private boolean isGridSquareTempInSameRow(int mainX, int mainY, GridSquare tempGS) {
		return tempGS.getX()!=mainX&&tempGS.getY()==mainY;
	}
}
