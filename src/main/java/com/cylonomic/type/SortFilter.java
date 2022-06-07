package com.cylonomic.type;

import org.springframework.data.domain.Sort;

public class SortFilter {
	
	private String sortType;
	
	public SortFilter(String type) {
		this.sortType = type;
	}
	
	public Sort getSortType() {
		if (this.sortType == null) {
			return Sort.by("id").descending();
		}		
		switch(this.sortType) {
			case "priceasc":
				return Sort.by("phone").ascending();
			case "pricedesc":
				return Sort.by("phone").descending();
			case "alphasc":
				return Sort.by("uname").ascending();
			case "alphdesc":
				return Sort.by("uname").descending();
			default: 
				return Sort.by("id").descending();
				
		}
	}
	
	
}
