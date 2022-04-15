package com.book.service.impl;

import java.util.List;

import com.book.dao.CategoryDao;
import com.book.dao.impl.CategoryDaoImpl;
import com.book.model.Category;
import com.book.model.User;
import com.book.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	CategoryDao categoryDao = new CategoryDaoImpl();

	@Override
	public void insert(Category category) {
		categoryDao.insert(category);

	}

	@Override
	public void edit(Category newCategory) {
		Category oldCate = categoryDao.get(newCategory.getId());
		oldCate.setName(newCategory.getName());
		categoryDao.edit(oldCate);

	}

	@Override
	public void delete(int id) {
		categoryDao.delete(id);

	}

	@Override
	public Category get(int id) {
		return categoryDao.get(id);
	}

	@Override
	public Category get(String name) {
		return categoryDao.get(name);
	}

	@Override
	public List<Category> getAll() {
		return categoryDao.getAll();
	}

	@Override
	public List<Category> search(String username) {
		return categoryDao.search(username);
	}
}