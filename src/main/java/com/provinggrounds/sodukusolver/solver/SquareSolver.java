package com.provinggrounds.sodukusolver.solver;

import java.util.ArrayList;
import java.util.List;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;

/**
 * Removes Possible numbers for the current square
 * @author HARBAL
 *
 */
class SquareSolver implements SolverInterface {

	@Override
	public void process(Grid grid) {
		for(GridSquare mainGS : grid.getGridSquareList()){
			if(!mainGS.isConfirmed()){
				int mainX=mainGS.getX();
				int mainY=mainGS.getY();
				int mainParent=mainGS.getParent();
				List<GridSquare> tempGSList = getTempGSListForSquare(mainX, mainY, mainParent, grid);
				for(GridSquare tempGS : tempGSList){
					if(tempGS.isConfirmed()){
						mainGS.removePossibleNumber(tempGS.getConfirmedNumber());
					}
				}
			}
		}
	}
	
	private List<GridSquare> getTempGSListForSquare(int mainX, int mainY, int mainParent, Grid grid){
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
}
