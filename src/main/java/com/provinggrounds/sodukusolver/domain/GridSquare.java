package com.provinggrounds.sodukusolver.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.function.Predicate;

public class GridSquare {
	
	private Set<Integer> initialSet = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
	
	private int limit;
	
	private int confirmedNumber;
	
	private int x;
	
	private int y;
	
	public int getConfirmedNumber(){
		return confirmedNumber;
	}
	
	public void setConfirmedNumber(int confirmedNumber){
		if(confirmedNumber!=0){
			this.confirmedNumber=confirmedNumber;
			initialSet.removeIf((Integer i)->i!=confirmedNumber);
		}
	}
	
	public int getConfirmedNumberFromSet(){
		if(initialSet.size()!=1){
			return 0;
		} else {
			return initialSet.toArray(new Integer[1])[0];
		}
	}
	
	public boolean removePossibleNumber(Integer remove){
		return initialSet.remove(remove);
	}
	
	public Set<Integer> getInitialSet(){
		return initialSet;
	}
	
	public int getY(){
		return y;
	}
	
	public int getX(){
		return x;
	}
	
	public void setX(int x){
		this.x=x;
	}
	
	public void setY(int y){
		this.y=y;
	}
	
	public void setLimit(int limit){
		this.limit=limit;
	}
	
	public int getLimit(){
		return limit;
	}
	
	public String toString(){
		return "|X:"+x+"|Y:"+y+"|Conf:"+confirmedNumber+"|Set:"+initialSet.toString();
	}
}
