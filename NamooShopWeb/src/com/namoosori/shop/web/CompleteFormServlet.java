package com.namoosori.shop.web;
  
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/complete.xhtml")
public class CompleteFormServlet extends HttpServlet{
	private static final long serialVersionUID = 6520219033463673806L;

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
		System.out.println("d");
		HttpSession session = req.getSession();
		if(session.getAttribute("loginId") == null) {
			resp.sendRedirect("login.xhtml");
			return;
		}else if(session.getAttribute("loginId") !=null && req.getParameterValues("products") != null) {
			resp.setContentType("text/html; charset=utf-8"); 
			req.setCharacterEncoding("utf-8");
			PrintWriter writer = resp.getWriter();
			
			writer.println("<html>");
			writer.println("<head>");
			writer.println("<title>주문 완료</title>");
			writer.println("<link href='./css/complete.css' rel='stylesheet' type='text/css'/>");
			writer.println("</head>");
			writer.println("<body>");
			writer.println("<div id='complete'>");
			writer.println("<form action=\"main.xhtml\" method=\"post\">");
			writer.println("<h3>상품 주문이 완료되었습니다.</h3>");
			writer.println("<input id='submit' type='submit' value='확인'/>");
			writer.println("</div></body>");
			writer.println("</html>");
		} else {
			resp.sendRedirect("main.xhtml");
			return;
		}

		
	}

	
}
