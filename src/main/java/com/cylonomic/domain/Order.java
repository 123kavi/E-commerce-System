package com.cylonomic.domain;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="user_order")
public class Order {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	
	@OneToMany(mappedBy="order", cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private List<CartItem> cartItems;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Shipping shipping;
	
	@OneToOne(cascade=CascadeType.ALL, fetch = FetchType.LAZY)
	private Payment payment;

	@ManyToOne(fetch = FetchType.LAZY)
	private User user;


	
	
}
