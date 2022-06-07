	
package com.cylonomic.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cylonomic.domain.Userinformation;
import com.cylonomic.service.UserinformationService;
@Controller
public class HomeController {
@Autowired
	private UserinformationService userinformationService;
	
	
	 @RequestMapping("/")
	 public String index(Model model) {		
		List<Userinformation> userinformations = userinformationService.findFirstUserinformations();
		model.addAttribute("userinformations", userinformations);
		return "index";
	}

	
}
