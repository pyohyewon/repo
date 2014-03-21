package com.namoosori.shop.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namoosori.namooshop.domain.Order;

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
		if(session.getAttribute("loginName") == null){
			resp.sendRedirect("login.jsp");
			return;
		}
		
		String[] products = req.getParameterValues("products");		
		System.out.println(products);
		if(products != null && products.length > 0) {
			//주문한 상품이 있는 경우 주문확인화면으로 Forward

			Order order = OrderFactory.createOrder(products);	
		
			req.setAttribute("products", order.getProducts());
			req.setAttribute("orderPrice", order.getTotalPrice());
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/order.jsp");
			dispatcher.forward(req, resp);
		} else {
			//주문한 상품이 없으면 요청화면으로 redirect
			resp.sendRedirect("main.xhtml");
				
		}
	}
	
	

}
