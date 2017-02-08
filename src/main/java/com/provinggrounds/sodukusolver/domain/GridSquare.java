package com.provinggrounds.sodukusolver.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GridSquare {
	
	private Set<Integer> initialSet = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
	
	private int confirmedNumber;
	
	private int x;
	
	private int y;
	
	public int getConfirmedNumber(){
		return confirmedNumber;
	}
	
	public void setConfirmedNumber(int confirmedNumber){
		this.confirmedNumber=confirmedNumber;
		if(confirmedNumber!=0){
			initialSet.clear();
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
	
	public String toString(){
		return "|X:"+x+"|Y:"+y+"|Conf:"+confirmedNumber+"|Set:"+initialSet.toString();
	}
}
