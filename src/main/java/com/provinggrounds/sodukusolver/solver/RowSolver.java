package com.provinggrounds.sodukusolver.solver;

import java.util.ArrayList;
import java.util.List;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;

/**
 * Removes Possible numbers for the current row
 * @author HARBAL
 *
 */
class RowSolver implements SolverInterface {

	@Override
	public void process(Grid grid) {
		for(GridSquare mainGS : grid.getGridSquareList()){
			if(!mainGS.isConfirmed()){
				int mainX=mainGS.getX();
				int mainY=mainGS.getY();
				List<GridSquare> tempGSList = getTempGSListForRow(mainX, mainY, grid);
				for(GridSquare tempGS : tempGSList){
					if(tempGS.isConfirmed()){
						mainGS.removePossibleNumber(tempGS.getConfirmedNumber());
					}
				}
			}
		}
	}
	
	private List<GridSquare> getTempGSListForRow(int mainX, int mainY, Grid grid){
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
