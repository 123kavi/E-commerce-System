package com.cylonomic.service;

import com.cylonomic.domain.Userinformation;
import com.cylonomic.domain.CartItem;
import com.cylonomic.domain.ShoppingCart;
import com.cylonomic.domain.User;


public interface ShoppingCartService {


	
	int getItemsNumber(User user);
	
	
	
}
