package com.provinggrounds.sodukusolver.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GridSquare {
	
	private Set<Integer> initialSet = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
	
	private int confirmedNumber=0;
	
	public int getConfirmedNumber(){
		return confirmedNumber;
	}
	
	public boolean setConfirmedNumber(){
		boolean result=false;
		if(initialSet.size()==1){
			Iterator<Integer> iterator=initialSet.iterator();
			confirmedNumber=iterator.next();
			result=true;
		}
		return result;
	}
	
	public boolean removePossibleNumber(Integer remove){
		return initialSet.remove(remove);
	}
	
	public Set<Integer> getInitialSet(){
		return initialSet;
	}
}
