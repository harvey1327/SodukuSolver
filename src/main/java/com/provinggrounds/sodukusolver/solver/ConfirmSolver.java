package com.provinggrounds.sodukusolver.solver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;
import com.provinggrounds.sodukusolver.solver.SolverUtil.Area;

public class ConfirmSolver implements SolverInterface {
	
	private SolverUtil util = new SolverUtil();

	@Override
	public void process(Grid grid) {
		grid.getGridSquareList().stream()
				.filter(mainGS -> !mainGS.isConfirmed())
				.forEach(mainGS -> confirmNumber(mainGS, grid));
	}
	
	private void confirmNumber(GridSquare mainGS, Grid grid){
		mainGS.setConfirmedNumber(mainGS.getConfirmedNumberFromSet());
		if(!mainGS.isConfirmed()){
			processHeuristic(mainGS, grid);
		}
	}

	private void processHeuristic(GridSquare mainGS, Grid grid) {
		List<GridSquare> tempGSListForSquare = util.getTempGSListForArea(mainGS.getX(), mainGS.getY(), mainGS.getParent(),Area.SQUARE,grid);
		List<GridSquare> tempGSListForRow = util.getTempGSListForArea(mainGS.getX(), mainGS.getY(), mainGS.getParent(),Area.ROW,grid);
		List<GridSquare> tempGSListForColumn = util.getTempGSListForArea(mainGS.getX(), mainGS.getY(), mainGS.getParent(),Area.COLUMN,grid);
		heuristicNumberFinder(mainGS, tempGSListForSquare);
		heuristicNumberFinder(mainGS, tempGSListForRow);
		heuristicNumberFinder(mainGS, tempGSListForColumn);
	}

	private void heuristicNumberFinder(GridSquare mainGS, List<GridSquare> tempGSList) {
		Set<Integer> nonUniqueIntegersSet = new HashSet<Integer>();
		tempGSList.stream()
				.forEach(tempGS->nonUniqueIntegersSet.addAll(tempGS.getInitialSet()));

		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		mainGS.getInitialSet().stream()
				.filter(number -> !nonUniqueIntegersSet.contains(number))
				.forEach(number -> uniqueNumbers.add(number));

		if (uniqueNumbers.size() == 1) {
			mainGS.setConfirmedNumber(uniqueNumbers.toArray(new Integer[1])[0]);
		}
	}
}
