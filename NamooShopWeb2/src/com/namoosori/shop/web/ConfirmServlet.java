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

@WebServlet("/confirm.do")
public class ConfirmServlet extends HttpServlet{

	private static final long serialVersionUID = -1195923324159485629L;

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
		String[] products = req.getParameterValues("products");	

		if(session.getAttribute("loginName")==null) {
			resp.sendRedirect("login.jsp");
			return;
		}else if(products == null ) {
			resp.sendRedirect("main.xhtml");
		}

		Order order = OrderFactory.createOrder(products);	
		order.setPayment(req.getParameter("pay"));
		order.setShipAddress(req.getParameter("address"));
		
		req.setAttribute("products", order.getProducts());
		req.setAttribute("orderPrice", order.getTotalPrice());
		req.setAttribute("pay", order.getPayment());
		req.setAttribute("address", order.getShipAddress());

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/confirm.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}
