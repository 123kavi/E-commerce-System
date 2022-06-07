package com.cylonomic.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import com.cylonomic.domain.User;
import com.cylonomic.service.ShoppingCartService;

@ControllerAdvice
public class GlobalControllerAdvice {
	
	public static final String DEFAULT_ERROR_VIEW = "error";
		
	@Autowired
	private ShoppingCartService shoppingCartService;

	@ModelAttribute
	public void populateModel(Model model) {	
		  Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		   if (auth != null && auth.isAuthenticated() && !(auth instanceof AnonymousAuthenticationToken)) {				
		   User user =  (User) auth.getPrincipal(); 
		   if (user != null) {
				model.addAttribute("shoppingCartItemNumber", shoppingCartService.getItemsNumber(user) );
			}
		} else { 
			model.addAttribute("shoppingCartItemNumber", 0);
		} 
	}
	

	
	
}
