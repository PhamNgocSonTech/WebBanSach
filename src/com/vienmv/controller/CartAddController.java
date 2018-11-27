package com.vienmv.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.vienmv.model.CartItem;
import com.vienmv.model.Product;
import com.vienmv.service.ProductService;
import com.vienmv.service.impl.ProductServiceImpl;

@WebServlet(urlPatterns = { "/admin/cart/add-to-cart" }) // ?pId=123
public class CartAddController extends HttpServlet {
	ProductService productService = new ProductServiceImpl();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String pId = req.getParameter("pId");

		Product product = productService.get(Integer.parseInt(pId));

		// KHI THEM SAN PHAM VAO GIO HANG MOT LAN NUA
		HttpSession httpSession = req.getSession();
		Object obj = httpSession.getAttribute("cart");
		if (obj != null) {
			CartItem cartItem = new CartItem();
			cartItem.setProduct(product);
			cartItem.setQuantity(1);
			cartItem.setUnitPrice(product.getPrice());

			Map<Integer, CartItem> map = new HashMap<Integer, CartItem>();
			// Su dung map de luu va tim kiem nhanh hon
			map.put(cartItem.getProduct().getId(), cartItem);

			httpSession.setAttribute("cart", map);// luu vao session

		} else {
			Map<Integer, CartItem> map = (Map<Integer, CartItem>) obj;
			CartItem cartItem = map.get(product.getId());
			// 1: Chua co san pham trong gio hang
			if (cartItem == null) {
				CartItem cartItems = new CartItem();
				cartItems.setProduct(product);
				cartItems.setQuantity(1);
				cartItems.setUnitPrice(product.getPrice());

				// Su dung map de luu va tim kiem nhanh hon
				map.put(cartItems.getProduct().getId(), cartItems);

				httpSession.setAttribute("cart", map);// luu vao session
			} else {
				// Truong hop da co roi
				cartItem.setQuantity(1 + cartItem.getQuantity());
				
				httpSession.setAttribute("cart", map);
			}
		}

		resp.sendRedirect(req.getContextPath() + "/admin/cart");
	}
}