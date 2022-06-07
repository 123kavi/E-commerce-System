package com.cylonomic.domain;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Province implements Comparable<Province> {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="userinformation_id")
	private Userinformation userinformation;	
	private String value;
		
	public Province() {
		
		
	}
	
	public Province(String value, Userinformation userinformation) {
		this.value = value;
		this.userinformation = userinformation;
	}
		
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	public Userinformation getUserinformation() {
		return userinformation;
	}
	public void setUserinformation(Userinformation userinformation) {
		this.userinformation = userinformation;
	}

	@Override
	public int compareTo(Province s) {
		return this.value.compareTo(s.getValue());		
	}
	
	
	
}
