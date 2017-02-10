package com.provinggrounds.sodukusolver.solver;

import java.util.List;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;

/**
 * Removes Possible numbers for the current square
 * @author HARBAL
 *
 */
class SquareSolver implements SolverInterface {
	
	private SolverUtil util = new SolverUtil();

	@Override
	public void process(Grid grid) {
		for(GridSquare mainGS : grid.getGridSquareList()){
			if(!mainGS.isConfirmed()){
				int mainX=mainGS.getX();
				int mainY=mainGS.getY();
				int mainParent=mainGS.getParent();
				List<GridSquare> tempGSList = util.getTempGSListForSquare(mainX, mainY, mainParent, grid);
				for(GridSquare tempGS : tempGSList){
					if(tempGS.isConfirmed()){
						mainGS.removePossibleNumber(tempGS.getConfirmedNumber());
					}
				}
			}
		}
	}
}
