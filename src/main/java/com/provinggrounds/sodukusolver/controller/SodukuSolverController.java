package com.provinggrounds.sodukusolver.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.domain.GridSquare;

@Controller
public class SodukuSolverController {
	
	private final int size = 9;

	@RequestMapping(value ="/SodukuSolverHome", method=RequestMethod.GET)
	public String getSodukuSolverHome(Model model){
		Grid grid = new Grid();
		grid.setGridSquareList(getGridList());
		model.addAttribute("grid", grid);
		model.addAttribute("size", size);
		System.out.println("GET");
		System.out.println(grid);
		return "SodukuSolverHome";
	}
	
	@RequestMapping(value ="/SodukuSolverHome", method=RequestMethod.POST)
	public String postSodukuSolverHome(@ModelAttribute("grid") Grid grid){
		System.out.println("POST");
		System.out.println(grid);
		return "SodukuSolverHome";
	}
	
	private List<GridSquare> getGridList(){
		List<GridSquare> list = new ArrayList<GridSquare>();
		for(int y=1;y<=size;y++){
			for(int x=1;x<=size;x++){
				GridSquare gs = new GridSquare();
				gs.setX(x);
				gs.setY(y);
				list.add(gs);
			}
		}
		return list;
	}
}
