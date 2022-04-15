package com.book.service.impl;

import java.io.File;
import java.util.List;

import com.book.dao.CartDao;
import com.book.dao.ProductDao;
import com.book.dao.UserDao;
import com.book.dao.impl.CartDaoImpl;
import com.book.dao.impl.ProductDaoImpl;
import com.book.dao.impl.UserDaoImpl;
import com.book.model.Cart;
import com.book.model.Product;
import com.book.model.User;
import com.book.service.CartService;
import com.book.service.ProductService;
import com.book.service.UserService;

public class CartServiceImpl implements CartService {
	CartDao cartDao = new CartDaoImpl();

	@Override
	public List<Cart> search(String name) {
		return cartDao.search(name);
	}

	@Override
	public void insert(Cart cart) {
		cartDao.insert(cart);

	}

	@Override
	public List<Cart> getAll() {
		return cartDao.getAll();
	}

	@Override
	public Cart get(int id) {
		return cartDao.get(id);
	}

	@Override
	public void edit(Cart newCart) {
		Cart oldCart = cartDao.get(newCart.getId());

		oldCart.setBuyDate(newCart.getBuyDate());
		oldCart.setBuyer(newCart.getBuyer());
		
		
		cartDao.edit(oldCart);

	}

	@Override
	public void delete(int id) {
		cartDao.delete(id);
	}
}
