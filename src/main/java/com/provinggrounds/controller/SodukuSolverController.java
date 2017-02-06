package com.provinggrounds.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SodukuSolverController {

	@RequestMapping(value ="/SodukuSolverHome")
	public String sodukuSolverHome(Model model){
		model.addAttribute("message", "MyMessage");
		return "SodukuSolverHome";
	}
}
