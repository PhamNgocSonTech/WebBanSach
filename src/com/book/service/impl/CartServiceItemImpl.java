package com.book.service.impl;

import java.io.File;
import java.util.List;

import com.book.dao.CartDao;
import com.book.dao.CartItemDao;
import com.book.dao.ProductDao;
import com.book.dao.UserDao;
import com.book.dao.impl.CartDaoImpl;
import com.book.dao.impl.CartItemDaoImpl;
import com.book.dao.impl.ProductDaoImpl;
import com.book.dao.impl.UserDaoImpl;
import com.book.model.Cart;
import com.book.model.CartItem;
import com.book.model.Product;
import com.book.model.User;
import com.book.service.CartItemService;
import com.book.service.CartService;
import com.book.service.ProductService;
import com.book.service.UserService;

public class CartServiceItemImpl implements CartItemService {
	CartItemDao cartItemDao = new CartItemDaoImpl();

	@Override
	public void insert(CartItem cartItem) {
		cartItemDao.insert(cartItem);
		
	}

	@Override
	public void edit(CartItem newCartItem) {
		CartItem oldCartItem = cartItemDao.get(newCartItem.getId());
		oldCartItem.setCart(newCartItem.getCart());
		oldCartItem.setProduct(newCartItem.getProduct());
		oldCartItem.setQuantity(newCartItem.getQuantity());
		oldCartItem.setUnitPrice(newCartItem.getUnitPrice());
		
		cartItemDao.edit(oldCartItem);
	}

	@Override
	public void delete(String id) {
		cartItemDao.delete(id);
	}

	@Override
	public CartItem get(int id) {
		return cartItemDao.get(id);
	}

	@Override
	public List<CartItem> getAll() {
		return cartItemDao.getAll();
	}

	@Override
	public List<CartItem> search(String keyword) {
		return cartItemDao.search(keyword);
	}

	
}
