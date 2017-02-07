package com.provinggrounds.sodukusolver.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.provinggrounds.sodukusolver.domain.Grid;

@Controller
public class SodukuSolverController {

	@RequestMapping(value ="/SodukuSolverHome", method=RequestMethod.GET)
	public String sodukuSolverHome(Model model){
		Grid grid = new Grid();
		
		model.addAttribute("grid", grid);
		model.addAttribute("size", 9);
		return "SodukuSolverHome";
	}
}
