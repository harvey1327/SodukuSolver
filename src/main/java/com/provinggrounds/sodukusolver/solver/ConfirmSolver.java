package com.provinggrounds.sodukusolver.solver;

import java.util.HashSet;
import java.util.Set;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;

public class ConfirmSolver implements SolverInterface {

	@Override
	public void process(GridSquare gridSquare, Grid grid) {
		gridSquare.setConfirmedNumber(gridSquare.getConfirmedNumberFromSet());
		if(!gridSquare.isConfirmed()){
			//setValueIfGridSquareHasUniqueInColumn(gridSquare, grid);
		}
		if(!gridSquare.isConfirmed()){
			//setValueIfGridSquareHasUniqueInRow(gridSquare, grid);
		}if(!gridSquare.isConfirmed()){
			setValueIfGridSquareHasUniqueInSquare(gridSquare, grid);	
		}
	}
	
	private void setValueIfGridSquareHasUniqueInColumn(GridSquare gridSquare, Grid grid) {
		Set<Integer> nonUniqueIntegersSet = new HashSet<Integer>();
		grid.getGridSquareList().stream()
				.filter(gridSquareTemp -> isGridSquareTempInSameColumn(gridSquare, gridSquareTemp)
						&& !gridSquareTemp.isConfirmed())
				.forEach(gridSquareTemp->nonUniqueIntegersSet.addAll(gridSquareTemp.getInitialSet()));

		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		gridSquare.getInitialSet().stream().filter(number -> !nonUniqueIntegersSet.contains(number))
				.forEach(number -> uniqueNumbers.add(number));

		if (uniqueNumbers.size() == 1) {
			gridSquare.setConfirmedNumber(uniqueNumbers.toArray(new Integer[1])[0]);
		}
	}
	
	private void setValueIfGridSquareHasUniqueInSquare(GridSquare gridSquare, Grid grid) {
		Set<Integer> nonUniqueIntegersSet = new HashSet<Integer>();
		grid.getGridSquareList().stream()
				.filter(gridSquareTemp -> isGridSquareTempInSameSquare(gridSquare, gridSquareTemp)
						&& !gridSquareTemp.isConfirmed())
				.forEach(gridSquareTemp->nonUniqueIntegersSet.addAll(gridSquareTemp.getInitialSet()));

		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		gridSquare.getInitialSet().stream().filter(number -> !nonUniqueIntegersSet.contains(number))
				.forEach(number -> uniqueNumbers.add(number));

		if (uniqueNumbers.size() == 1) {
			gridSquare.setConfirmedNumber(uniqueNumbers.toArray(new Integer[1])[0]);
		}
	}
	
	private void setValueIfGridSquareHasUniqueInRow(GridSquare gridSquare, Grid grid) {
		Set<Integer> nonUniqueIntegersSet = new HashSet<Integer>();
		grid.getGridSquareList().stream()
				.filter(gridSquareTemp -> isGridSquareTempInSameRow(gridSquare, gridSquareTemp)
						&& !gridSquareTemp.isConfirmed())
				.forEach(gridSquareTemp->nonUniqueIntegersSet.addAll(gridSquareTemp.getInitialSet()));

		Set<Integer> uniqueNumbers = new HashSet<Integer>();
		gridSquare.getInitialSet().stream().filter(number -> !nonUniqueIntegersSet.contains(number))
				.forEach(number -> uniqueNumbers.add(number));

		if (uniqueNumbers.size() == 1) {
			gridSquare.setConfirmedNumber(uniqueNumbers.toArray(new Integer[1])[0]);
		}
	}
	
	private boolean isGridSquareTempInSameColumn(GridSquare gridSquare, GridSquare gridSquareTemp) {
		int x = gridSquare.getX();
		int y = gridSquare.getY();
		return gridSquareTemp.getX() == x && gridSquareTemp.getY() != y;
	}
	
	protected boolean isGridSquareTempInSameRow(GridSquare gridSquare, GridSquare gridSquareTemp) {
		int x = gridSquare.getX();
		int y = gridSquare.getY();
		return gridSquareTemp.getY() == y && gridSquareTemp.getX() != x;
	}
	
	protected boolean isGridSquareTempInSameSquare(GridSquare gridSquare, GridSquare gridSquareTemp) {
		int x = gridSquare.getX();
		int y = gridSquare.getY();
		int parent = gridSquare.getParent();
		return gridSquareTemp.getParent() == parent && gridSquareTemp.getX() != x && gridSquareTemp.getY() != y;
	}
}
