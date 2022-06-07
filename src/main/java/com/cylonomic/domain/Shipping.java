package com.cylonomic.domain;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

@Entity
public class Shipping {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String receiver;
	@OneToOne(cascade= CascadeType.ALL, orphanRemoval = true)
	@JoinColumn(name = "address_id")
	private Address address;	
	@OneToOne
	private Order order;


	
}
