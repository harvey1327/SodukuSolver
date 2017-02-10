package com.provinggrounds.sodukusolver.solver;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;

public class ConfirmSolver implements SolverInterface {

	@Override
	public void process(Grid grid) {
		for(GridSquare mainGS : grid.getGridSquareList()){
			if(!mainGS.isConfirmed()){
				mainGS.setConfirmedNumber(mainGS.getConfirmedNumberFromSet());
				if(!mainGS.isConfirmed()){
					int mainX=mainGS.getX();
					int mainY=mainGS.getY();
					int mainParent=mainGS.getParent();
					
					List<GridSquare> tempGSListForSquare = getTempGSListForSquare(mainX, mainY, mainParent, grid);
					List<GridSquare> tempGSListForRow = getTempGSListForRow(mainX, mainY, grid);
					List<GridSquare> tempGSListForColumn = getTempGSListForColumn(mainX, mainY, grid);
					heuristicNumberFinder(mainGS, tempGSListForRow);
					heuristicNumberFinder(mainGS, tempGSListForColumn);
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
	
	private List<GridSquare> getTempGSListForRow(int mainX, int mainY, Grid grid){
		List<GridSquare> tempGSList = new ArrayList<GridSquare>();
		for(GridSquare tempGS : grid.getGridSquareList()){
			if(isGridSquareTempInSameRow(mainX, mainY, tempGS)){
				tempGSList.add(tempGS);
			}
		}
		return tempGSList;
	}
	
	private List<GridSquare> getTempGSListForColumn(int mainX, int mainY, Grid grid){
		List<GridSquare> tempGSList = new ArrayList<GridSquare>();
		for(GridSquare tempGS : grid.getGridSquareList()){
			if(isGridSquareTempInSameColumn(mainX, mainY, tempGS)){
				tempGSList.add(tempGS);
			}
		}
		return tempGSList;
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
	
	private boolean isGridSquareTempInSameColumn(int mainX, int mainY, GridSquare tempGS) {
		return tempGS.getX()==mainX&&tempGS.getY()!=mainY;
	}
	
	protected boolean isGridSquareTempInSameSquare(int mainX, int mainY, int mainParent, GridSquare tempGS) {
		return tempGS.getParent() == mainParent && tempGS.getX() != mainX && tempGS.getY() != mainY;
	}
	
	private boolean isGridSquareTempInSameRow(int mainX, int mainY, GridSquare tempGS) {
		return tempGS.getX()!=mainX&&tempGS.getY()==mainY;
	}
}
