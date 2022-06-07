package com.cylonomic.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.jpa.domain.Specification;

import com.cylonomic.domain.Userinformation;
import com.cylonomic.domain.Brand;
import com.cylonomic.domain.Category;
import com.cylonomic.domain.Province;

public class UserinformationSpecification {
	
	private UserinformationSpecification() {}
	
	@SuppressWarnings("serial")
	public static Specification<Userinformation> filterBy(Integer priceLow, Integer priceHigh, List<String> sizes, 
												  List<String> categories, List<String> brands/*, List<String> mails*/,  String search) {			
		return new Specification<Userinformation>() {
            @Override
            public Predicate toPredicate(Root<Userinformation> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate> predicates = new ArrayList<>();                
                query.distinct(true);                
                if (sizes!=null && !sizes.isEmpty()) {
                	Join<Userinformation, Province> joinSize = root.join("sizes");
                	predicates.add(criteriaBuilder.and(joinSize.get("value").in(sizes)));
                }
                if (categories!=null && !categories.isEmpty()) {
                	Join<Userinformation, Category> joinSize = root.join("categories");
                	predicates.add(criteriaBuilder.and(joinSize.get("name").in(categories)));
                }   
                if (brands!=null && !brands.isEmpty()) {
                	Join<Userinformation, Brand> joinSize = root.join("brands");
                	predicates.add(criteriaBuilder.and(joinSize.get("name").in(brands)));
                }  
                
        
                
                if(search!=null && !search.isEmpty()) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.like(root.get("title"), "%"+search+"%")));
                }
                if (priceLow!=null && priceLow >= 0) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.greaterThanOrEqualTo(root.get("price"), priceLow)));
                }
                if (priceHigh!=null && priceHigh >= 0) {
                    predicates.add(criteriaBuilder.and(criteriaBuilder.lessThanOrEqualTo(root.get("price"), priceHigh)));
                }
                return criteriaBuilder.and(predicates.toArray(new Predicate[predicates.size()]));
            }
        };		
	}
}
