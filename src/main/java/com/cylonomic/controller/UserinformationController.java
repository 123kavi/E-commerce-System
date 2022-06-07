package com.cylonomic.controller;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.cylonomic.domain.Userinformation;
import com.cylonomic.domain.UserinformationBuilder;
import com.cylonomic.domain.PDFExporter;

import com.cylonomic.domain.Brand;
import com.cylonomic.domain.Category;
import com.cylonomic.domain.Province;
import com.cylonomic.domain.User;
import com.cylonomic.service.UserService;

import com.cylonomic.service.UserinformationService;
import com.lowagie.text.DocumentException;
import org.springframework.stereotype.Service;
@Controller
@RequestMapping("/userinformation")

public class UserinformationController {

	@Autowired
	private UserinformationService userinformationService;
	private List<User> Userinformation;
	
	
	/*add users/filter part*/
	
	    @RequestMapping("/add")
	    public String addUserinformation (Model model) {
		Userinformation userinformation = new Userinformation ();
		model.addAttribute("userinformation", userinformation);
		model.addAttribute("allProvinces", userinformationService.getAllProvinces());
		model.addAttribute("allBrands", userinformationService.getAllBrands());
	    model.addAttribute("allCategories", userinformationService.getAllCategories());
		return "addUserinformation";
	}
	
	    @RequestMapping(value="/add", method=RequestMethod.POST)
	    public String addUserinformationPost(@ModelAttribute("userinformation") Userinformation userinformation, HttpServletRequest request) {
		Userinformation newUserinformation = new UserinformationBuilder()
				.withUname(userinformation.getUname())
				.umailAvailable(userinformation.getUmail())
				.withPhone(userinformation.getPhone())
				.imageLink(userinformation.getPicture())
				.provincesAvailable(Arrays.asList(request.getParameter("province").split("\\s*,\\s*")))
				.ofCategories(Arrays.asList(request.getParameter("category").split("\\s*,\\s*")))
				.ofBrand(Arrays.asList(request.getParameter("brand").split("\\s*,\\s*")))
				//.ofMail(Arrays.asList(request.getParameter("mail").split("\\s*,\\s*")))
				.build();		
		userinformationService.saveUserinformation (newUserinformation);	
		return "redirect:userinformation-list";
	}
	
	
	/*get information as list*/
	@RequestMapping("/userinformation-list")
	public String userinformationList(Model model) {
	List<Userinformation> userinformations = userinformationService.findAllUserinformations();
	model.addAttribute("userinformations", userinformations);
	return "userinformationList";
	}
	
	
	/*edit information*/
	
	    @RequestMapping("/edit")
	    public String editUserinformation (@RequestParam("id") Long id, Model model) {
		Userinformation userinformation = userinformationService.findUserinformationById(id);
		String preselectedProvinces = "";
		for (Province province : userinformation.getProvinces()) {
			preselectedProvinces += (province.getValue() + ",");
		}
		String preselectedBrands = "";
		for (Brand brand : userinformation.getBrands()) {
			preselectedBrands += (brand.getName() + ",");
		}
		
	
		String preselectedCategories = "";
		for (Category category : userinformation.getCategories()) {
			preselectedCategories += (category.getName() + ",");
		}		
		model.addAttribute("userinformation", userinformation);
		model.addAttribute("preselectedProvinces", preselectedProvinces);
		model.addAttribute("preselectedBrands", preselectedBrands);

		model.addAttribute("preselectedCategories", preselectedCategories);
		model.addAttribute("allProvinces", userinformationService.getAllProvinces());
		model.addAttribute("allBrands", userinformationService.getAllBrands());

		model.addAttribute("allCategories", userinformationService.getAllCategories());
		return "editUserinformation";
	}
	
	    @RequestMapping(value="/edit", method=RequestMethod.POST)
	    public String editUserinformationPost(@ModelAttribute("userinformation") Userinformation userinformation, HttpServletRequest request) {		
		Userinformation newUserinformation = new UserinformationBuilder()
				.withUname(userinformation.getUname())
				.umailAvailable(userinformation.getUmail())
				.withPhone(userinformation.getPhone())
				.imageLink(userinformation.getPicture())
				.provincesAvailable(Arrays.asList(request.getParameter("province").split("\\s*,\\s*")))
				.ofCategories(Arrays.asList(request.getParameter("category").split("\\s*,\\s*")))
				.ofBrand(Arrays.asList(request.getParameter("brand").split("\\s*,\\s*")))
		
				.build();
		newUserinformation.setId(userinformation.getId());
		userinformationService.saveUserinformation(newUserinformation);	
		return "redirect:userinformation-list";
	}
	
	    
	    
	/*delete information*/
	@RequestMapping("/delete")
	public String deleteUserinformation (@RequestParam("id") Long id) {
		userinformationService.deleteUserinformationById(id);
		return "redirect:userinformation-list";
	}
	
	

	/*export details as pdf*/
	
	@GetMapping("/export")
    public void exportToPDF(HttpServletResponse response) throws DocumentException, IOException {
        response.setContentType("application/pdf");
        DateFormat dateFormatter = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss");
        String currentDateTime = dateFormatter.format(new Date());
         
        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=users_" + currentDateTime + ".pdf";
        response.setHeader(headerKey, headerValue);
         
        List<Userinformation> userinformations = userinformationService.findAllUserinformations();
         
        PDFExporter exporter = new PDFExporter(userinformations);
        exporter.export(response);
         
    }

	
}