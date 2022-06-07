package com.cylonomic.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserAnalysi {

	@Id
	private int qunti;
	private String name;
	public int getQunti() {
		return qunti;
	}
	public void setQunti(int qunti) {
		this.qunti = qunti;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
}
