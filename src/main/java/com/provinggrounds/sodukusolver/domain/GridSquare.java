package com.provinggrounds.sodukusolver.domain;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class GridSquare {
	
	private Set<Integer> initialSet = new HashSet<Integer>(Arrays.asList(1,2,3,4,5,6,7,8,9));
	
	private int parent;
	
	private int confirmedNumber;
	
	private int x;
	
	private int y;
	
	public int getConfirmedNumber(){
		return confirmedNumber;
	}
	
	public boolean isConfirmed(){
		return confirmedNumber!=0;
	}
	
	public void setConfirmedNumber(int confirmedNumber){
		if(confirmedNumber!=0){
			this.confirmedNumber=confirmedNumber;
			this.initialSet = new HashSet<Integer>(Arrays.asList(confirmedNumber));
		}
	}
	
	public int getConfirmedNumberFromSet(){
		if(initialSet.size()==1){
			return initialSet.toArray(new Integer[1])[0];
		} else {
			return 0;
		}
	}
	
	public void removePossibleNumber(Integer remove){
		initialSet.remove(remove);
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
	
	public int getParent(){
		return parent;
	}
	
	public void setParent(int parent){
		this.parent=parent;
	}
	
	public String toString(){
		return "|X:"+x+"|Y:"+y+"|Conf:"+confirmedNumber+"|Set:"+initialSet.toString();
	}
}
