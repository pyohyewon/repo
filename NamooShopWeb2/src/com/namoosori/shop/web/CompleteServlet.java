package com.namoosori.shop.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/complete.do")
public class CompleteServlet extends HttpServlet{
	private static final long serialVersionUID = -6255426892927710640L;

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
		if(session.getAttribute("loginName")!=null && req.getParameterValues("products") != null) {
				resp.sendRedirect("/WEB-INF/views/complete.jsp");				
			
		}else {
			resp.sendRedirect("login.jsp");
			return;
		}	
	}
	

}
