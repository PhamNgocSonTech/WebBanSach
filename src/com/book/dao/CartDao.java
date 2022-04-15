package com.book.dao;

import java.util.List;

import com.book.model.Cart;
import com.book.model.Category;

public interface CartDao {
	void insert(Cart cart);

	void edit(Cart cart);

	void delete(int id);

	Cart get(String name);

	Cart get(int id);

	List<Cart> getAll();

	List<Cart> search(String name);
}
