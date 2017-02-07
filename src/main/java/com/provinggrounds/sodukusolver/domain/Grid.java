package com.provinggrounds.sodukusolver.domain;

import java.util.ArrayList;
import java.util.List;

public class Grid {

	private List<GridSquare> gridList = new ArrayList<GridSquare>();
	
	public Grid(){
		for(int y=1;y<=9;y++){
			for(int x=1;x<=9;x++){
				GridSquare gs = new GridSquare(y,x);
				gridList.add(gs);
			}
		}
	}
	
	public List<GridSquare> getGridList(){
		return gridList;
	}
}
