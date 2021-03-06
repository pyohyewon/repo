package com.namoosori.shop.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namoosori.namooshop.domain.Product;
import com.namoosori.namooshop.service.facade.ProductService;
import com.namoosori.namooshop.service.factory.NamooShopServiceFactory;

@WebServlet("/main.xhtml")
public class MainServlet extends HttpServlet{
	private static final long serialVersionUID = -5441914164986289841L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 
		doPost(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		// 
		HttpSession session = req.getSession();
		if(session.getAttribute("loginName") == null){
			resp.sendRedirect("login.jsp");
			return;
		}
		
		NamooShopServiceFactory factory = NamooShopServiceFactory.getInstance();
		ProductService productService = factory.getProductService();
		
		List<Product> products = productService.getAllProducts();
		
		req.setAttribute("products", products);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/main.jsp");
		dispatcher.forward(req, resp);
		
			
	}
}