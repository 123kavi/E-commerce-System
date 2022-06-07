package com.cylonomic;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.cylonomic.service.UserService;

@Component
public class StoreAppStartupRunner implements CommandLineRunner{
/*create user role access*/
	@Autowired
	private UserService userService;
	
	@Override
	public void run(String... args) throws Exception {
		
		userService.createUser("admin1", "admin1", "admin1@admin.com", Arrays.asList("ROLE_USER", "ROLE_ADMIN"));	
		userService.createUser("seller", "seller", "seller@seller.com", Arrays.asList("ROLE_USER", "ROLE_SELLER"));	
	     
	
	}
}

