package com.provinggrounds.sodukusolver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.provinggrounds.sodukusolver.domain.Grid;
import com.provinggrounds.sodukusolver.handler.SodukuSolverHandler;

@Controller
@SessionAttributes(value={"grid","size"})
public class SodukuSolverController {
	
	private final int size = 9;
	
	private SodukuSolverHandler handler = new SodukuSolverHandler();

	@RequestMapping(value ="/SodukuSolverHome", method=RequestMethod.GET)
	public String getSodukuSolverHome(Model model){
		Grid grid=handler.createGrid(size);
		
		model.addAttribute("grid", grid);
		model.addAttribute("size", size);
		
		System.out.println("GET: "+grid);
		return "SodukuSolverHome";
	}
	
	@RequestMapping(value ="/SodukuSolverHome", method=RequestMethod.POST)
	public String postSodukuSolverHome(@ModelAttribute("grid") Grid grid){
		handler.processChain(grid);
		System.out.println("POST: "+grid);
		return "SodukuSolverHome";
	}
}
