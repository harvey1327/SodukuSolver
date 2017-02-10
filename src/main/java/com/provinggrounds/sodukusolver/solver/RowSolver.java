package com.provinggrounds.sodukusolver.solver;

import java.util.List;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;
import com.provinggrounds.sodukusolver.solver.SolverUtil.Area;

/**
 * Removes Possible numbers for the current row
 * @author HARBAL
 *
 */
class RowSolver implements SolverInterface {
	
	private SolverUtil util = new SolverUtil();

	@Override
	public void process(Grid grid) {
		grid.getGridSquareList().stream()
				.filter(mainGS -> !mainGS.isConfirmed())
				.forEach(mainGS -> processRemoves(mainGS, grid));
	}

	private void processRemoves(GridSquare mainGS, Grid grid) {
		List<GridSquare> tempGSList = util.getTempGSListForArea(mainGS.getX(), mainGS.getY(), mainGS.getParent(),Area.ROW,grid);
		tempGSList.stream()
				.filter(tempGS -> tempGS.isConfirmed())
				.forEach(tempGS -> mainGS.removePossibleNumber(tempGS.getConfirmedNumber()));
	}
}
