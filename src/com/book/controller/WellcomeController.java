package com.book.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.book.model.Product;
import com.book.service.CategoryService;
import com.book.service.ProductService;
import com.book.service.impl.CategoryServiceImpl;
import com.book.service.impl.ProductServiceImpl;
@WebServlet(urlPatterns="/welcome")

public class WellcomeController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();
	CategoryService cateService = new CategoryServiceImpl();
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Product> productList = productService.getAll();
		req.setAttribute("pwelcome", productList);

		req.getRequestDispatcher("/view/client/view/index.jsp").forward(req, resp);
	}
	

}
