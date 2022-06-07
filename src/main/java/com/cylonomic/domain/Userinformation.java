package com.cylonomic.domain;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Userinformation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String uname;
	private String umail;	
	private String phone;
	private String role;
	
	@OneToMany(mappedBy="userinformation", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Province> provinces;
		@OneToMany(mappedBy="userinformation", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Brand> brands;
	
	//@OneToMany(mappedBy="article", cascade = CascadeType.ALL, orphanRemoval = true)
//	private Set<CusMail> cusMails;
	
	
	@OneToMany(mappedBy="userinformation", cascade = CascadeType.ALL, orphanRemoval = true)
	private Set<Category> categories;
	
	
	public Userinformation() {
	}
	

	

	public void addProvince(Province province) {
        provinces.add(province);
        province.setUserinformation(this);
    }
 
    public void removeProvince(Province province) {
        provinces.remove(province);
        province.setUserinformation(null);
    }
    
	public void addCategory(Category category) {
        categories.add(category);
        category.setUserinformation(this);
    }
 
    public void removeCategory(Category category) {
    	categories.remove(category);
        category.setUserinformation(null);
    }
    
	public void addProvince(Brand brand) {
        brands.add(brand);
        brand.setUserinformation(this);
    }
 
    public void removeProvince(Brand brand) {
    	brands.remove(brand);
        brand.setUserinformation(null);
    }
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getUmail() {
		return umail;
	}
	public void setUmail(String umail) {
		this.umail = umail;
	}
	public Set<Province> getProvinces() {
		return provinces;
	}
	public void setProvinces(Set<Province> provinces) {
		this.provinces = provinces;
	}
	public Set<Brand> getBrands() {
		return brands;
	}
	public void setBrands(Set<Brand> brands) {
		this.brands = brands;
	}
	public Set<Category> getCategories() {
		return categories;
	}
	public void setCategories(Set<Category> categories) {
		this.categories = categories;
	}
	public String getPicture() {
		return role;
	}
	public void setPicture(String picture) {
		this.role = picture;
	}




	public Userinformation getUserinformation() {
		// TODO Auto-generated method stub
		return null;
	}


















}
