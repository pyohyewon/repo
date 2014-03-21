package com.namoosori.shop.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namoosori.namooshop.service.facade.CustomerService;
import com.namoosori.namooshop.service.factory.NamooShopServiceFactory;

@WebServlet("/login.do")
public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 3726843598739947134L;

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
		CustomerService customerService = NamooShopServiceFactory.getInstance().getCustomerService();
		
		
		//요청 파라미터
		String userId=req.getParameter("loginId");
		String password=req.getParameter("password");
		
		HttpSession session = req.getSession();

		if(customerService.login(userId, password)) {
			//로그인 성공!
			session.setAttribute("loginName", customerService.getCustomer(userId).getName());
			resp.sendRedirect("main.xhtml");			
			
		} else if(!customerService.login(userId, password)) {
			// 로그인 실패
			session.removeAttribute("loginName");
			session.setAttribute("loginUserId", userId);
			session.setAttribute("userPassword", password);	
			RequestDispatcher dispatcher = req.getRequestDispatcher("login.jsp");
			dispatcher.forward(req, resp);
		}
	}
	
	

}