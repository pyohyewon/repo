package com.namoosori.shop.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/order.do")
public class OrderServlet extends HttpServlet{

	private static final long serialVersionUID = -1588822978316313012L;

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
		if(session.getAttribute("loginId") == null) {
			resp.sendRedirect("login.xhtml");
			return;
		}
		
		req.setCharacterEncoding("utf-8");
		String[] products = req.getParameterValues("products");
		
		if(products != null && products.length > 0) {
			//주문한 상품이 있는 경우 주문확인화면으로 Forward
			RequestDispatcher dispatcher = req.getRequestDispatcher("order.xhtml");
			dispatcher.forward(req, resp);
		} else {
			//주문한 상품이 없으면 요청화면으로 redirect
			resp.sendRedirect("main.xhtml");
			
		}
	}
	
	

}
