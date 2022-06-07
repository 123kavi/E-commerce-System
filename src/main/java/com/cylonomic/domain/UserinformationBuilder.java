package com.cylonomic.domain;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserinformationBuilder {
		
	private String uname;
	private String umail;	
	private String phone;
	private String picture;
	private List<String> provinces;
	private List<String> categories;
	private List<String> brands;
	//private List<String> mails;
	
	public UserinformationBuilder() {
	}
	
	public UserinformationBuilder withUname(String uname) {
		this.uname = uname;
		return this;
	}
	
	public UserinformationBuilder umailAvailable(String umail) {
		this.umail = umail;
		return this;
	}
	
	public UserinformationBuilder withPhone(String phone) {
		this.phone = phone;
		return this;
	}
	
	public UserinformationBuilder imageLink(String picture) {
		this.picture = picture;
		return this;
	}
	
	public UserinformationBuilder provincesAvailable(List<String> provinces) {
		this.provinces = provinces;
		return this;
	}
	
	public UserinformationBuilder ofCategories(List<String> categories) {
		this.categories = categories;
		return this;
	}
	
	public UserinformationBuilder ofBrand(List<String> brands) {
		this.brands = brands;
		return this;
	}

	
	
	
	public Userinformation build() {
		Userinformation userinformation = new Userinformation();
		userinformation.setUname(this.uname);
		userinformation.setPhone(this.phone);
		userinformation.setUmail(this.umail);
		userinformation.setPicture(this.picture);		
		
		if (this.provinces != null && !this.provinces.isEmpty()) {
			Set<Province> provinceElements = new HashSet<>();
			for (String val : this.provinces) {
				provinceElements.add(new Province(val,userinformation));
			}	
			userinformation.setProvinces(provinceElements);
		}
		
		if (this.categories != null && !this.categories.isEmpty() ) {
			Set<Category> catElements = new HashSet<>();
			for (String val : this.categories) {
				catElements.add(new Category(val,userinformation));
			}
			userinformation.setCategories(catElements);
		}		
		if (this.brands != null && !this.brands.isEmpty() ) {
			Set<Brand> brandlements = new HashSet<>();
			for (String val : this.brands) {
				brandlements.add(new Brand(val,userinformation));
			}
			userinformation.setBrands(brandlements);
		}		
	
		
		return userinformation;
	}


	
}