package com.provinggrounds.sodukusolver.domain;

import java.util.ArrayList;
import java.util.List;

public class Grid {

	private List<GridSquare> gridList = new ArrayList<GridSquare>();
	
	public Grid(){
		for(int i=0;i<81;i++){
			gridList.add(i, new GridSquare());
		}
	}
	
	public List<GridSquare> getGridList(){
		return gridList;
	}
}
