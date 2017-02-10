package com.provinggrounds.sodukusolver.solver;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;

public class ConfirmSolver implements SolverInterface {
	
	private SolverUtil util = new SolverUtil();

	@Override
	public void process(Grid grid) {
		for(GridSquare mainGS : grid.getGridSquareList()){
			if(!mainGS.isConfirmed()){
				mainGS.setConfirmedNumber(mainGS.getConfirmedNumberFromSet());
				if(!mainGS.isConfirmed()){
					int mainX=mainGS.getX();
					int mainY=mainGS.getY();
					int mainParent=mainGS.getParent();
					
					List<GridSquare> tempGSListForSquare = util.getTempGSListForSquare(mainX, mainY, mainParent, grid);
					List<GridSquare> tempGSListForRow = util.getTempGSListForRow(mainX, mainY, grid);
					List<GridSquare> tempGSListForColumn = util.getTempGSListForColumn(mainX, mainY, grid);
					heuristicNumberFinder(mainGS, tempGSListForSquare);
					heuristicNumberFinder(mainGS, tempGSListForRow);
					heuristicNumberFinder(mainGS, tempGSListForColumn);
				}
			}
		}
	}

	private void heuristicNumberFinder(GridSquare mainGS, List<GridSquare> tempGSList) {
		Set<Integer> nonUniqueIntegersSet = new HashSet<Integer>();
		tempGSList.stream()
				.forEach(tempGS->nonUniqueIntegersSet.addAll(tempGS.getInitialSet()));

		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		mainGS.getInitialSet().stream().filter(number -> !nonUniqueIntegersSet.contains(number))
				.forEach(number -> uniqueNumbers.add(number));

		if (uniqueNumbers.size() == 1) {
			mainGS.setConfirmedNumber(uniqueNumbers.toArray(new Integer[1])[0]);
		}
	}
}
