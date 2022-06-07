package com.cylonomic.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.cylonomic.domain.UserAnalysi;
import com.cylonomic.service.UserAnalysiService;



@Controller
public class UserAnalysiController {
	
	@Autowired
	private UserAnalysiService service;
	
	@PostMapping("/addUserAnalysi")
	public String addEmployee(@RequestBody UserAnalysi userAnalysi)
	{
		return service.saveUserAnalysi(userAnalysi);
	}
    @GetMapping("/barChart")
	public String getAllUserAnalysi(Model model) {	
		
	List<String> nameList= service.getAllUserAnalysi().stream().map(x->x.getName()).collect(Collectors.toList());
	List<Integer> quntiList = service.getAllUserAnalysi().stream().map(x-> x.getQunti()).collect(Collectors.toList());
	model.addAttribute("name", nameList);
	model.addAttribute("qunti", quntiList);
	return "barChart";
	
	}
}
