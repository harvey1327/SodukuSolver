package com.provinggrounds.sodukusolver.domain;

import java.util.List;

public class Grid {

	private List<GridSquare> gridSquareList;
	
	public List<GridSquare> getGridSquareList(){
		return gridSquareList;
	}
	
	public void setGridSquareList(List<GridSquare> list){
		this.gridSquareList=list;
	}
	
	public String toString(){
		return gridSquareList.toString();
	}
}
