package com.book.dao;

import java.util.List;

import com.book.model.Cart;
import com.book.model.CartItem;
import com.book.model.Category;

public interface CartItemDao {
	void insert(CartItem cartItem);

	void edit(CartItem cartItem);

	void delete(String id);

	CartItem get(String name);

	CartItem get(int id);

	List<CartItem> getAll();

	List<CartItem> search(String name);
}
