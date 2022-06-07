package com.cylonomic.domain;

import java.math.BigDecimal;
import java.util.List;

public class ShoppingCart {
	
	private List<CartItem> cartItems;

	public ShoppingCart(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	
	
	public int getItemCount() {
		return this.cartItems.size();
	}	
	
	public List<CartItem> getCartItems() {
		return cartItems;
	}
	public void setCartItems(List<CartItem> cartItems) {
		this.cartItems = cartItems;
	}

	
}
