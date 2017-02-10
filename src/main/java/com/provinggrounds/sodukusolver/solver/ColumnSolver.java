package com.provinggrounds.sodukusolver.solver;

import java.util.List;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;

/**
 * Removes Possible numbers for the current column
 * @author HARBAL
 *
 */
class ColumnSolver implements SolverInterface {
	
	private SolverUtil util = new SolverUtil();

	@Override
	public void process(Grid grid) {
		for(GridSquare mainGS : grid.getGridSquareList()){
			if(!mainGS.isConfirmed()){
				int mainX=mainGS.getX();
				int mainY=mainGS.getY();
				List<GridSquare> tempGSList = util.getTempGSListForColumn(mainX, mainY, grid);
				for(GridSquare tempGS : tempGSList){
					if(tempGS.isConfirmed()){
						mainGS.removePossibleNumber(tempGS.getConfirmedNumber());
					}
				}
			}
		}
	}
}
