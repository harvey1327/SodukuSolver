package com.provinggrounds.sodukusolver.solver;

import java.util.ArrayList;
import java.util.List;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;

public class SolverUtil {
	
	protected enum Area {
		SQUARE, COLUMN, ROW
	}
	
	protected List<GridSquare> getTempGSListForArea(int mainX, int mainY, int mainParent, Area area, Grid grid) {
		List<GridSquare> tempGSList = new ArrayList<GridSquare>();
		grid.getGridSquareList().stream()
				.filter(tempGS -> isGridSquareTempInSameArea(mainX, mainY, mainParent, area, tempGS))
				.forEach(tempGS -> tempGSList.add(tempGS));
		return tempGSList;
	}
	
	private boolean isGridSquareTempInSameArea(int mainX, int mainY, int mainParent, Area area, GridSquare tempGS) {
		if(area.equals(Area.SQUARE)){
			return isGridSquareTempInSameSquare(mainX, mainY, mainParent, tempGS);
		} else if(area.equals(Area.COLUMN)){
			return isGridSquareTempInSameColumn(mainX, mainY, tempGS);
		} else if(area.equals(Area.ROW)){
			return isGridSquareTempInSameRow(mainX, mainY, tempGS);
		} else {
			return false;
		}
	}
	
	private boolean isGridSquareTempInSameSquare(int mainX, int mainY, int mainParent, GridSquare tempGS) {
		return tempGS.getParent() == mainParent && (tempGS.getX() != mainX || tempGS.getY() != mainY);
	}
	
	private boolean isGridSquareTempInSameColumn(int mainX, int mainY, GridSquare tempGS) {
		return tempGS.getX()==mainX&&tempGS.getY()!=mainY;
	}
	
	private boolean isGridSquareTempInSameRow(int mainX, int mainY, GridSquare tempGS) {
		return tempGS.getX()!=mainX&&tempGS.getY()==mainY;
	}
}
