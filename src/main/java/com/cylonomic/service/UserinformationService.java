package com.cylonomic.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.cylonomic.domain.User;
import com.cylonomic.domain.Userinformation;

public interface UserinformationService {

	
	
	
	

	
	List<Userinformation> findAllUserinformations();
	
	Page<Userinformation> findUserinformationsByCriteria(Pageable pageable, Integer priceLow, Integer priceHigh, List<String> provinces,
			List<String> categories, List<String> brands/*, List<String> mails*/,  String search);
		
	List<Userinformation> findFirstUserinformations();

	Userinformation findUserinformationById(Long id);
	
	Userinformation saveUserinformation(Userinformation userinformation);

	void deleteUserinformationById(Long id);
	
	List<String> getAllProvinces();

	List<String> getAllCategories();

	List<String> getAllBrands();
	//List<String> getAllMails();

	

}
