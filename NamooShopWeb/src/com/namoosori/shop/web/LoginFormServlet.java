package com.namoosori.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
@WebServlet("/login.xhtml")
public class LoginFormServlet extends HttpServlet{

	private static final long serialVersionUID = -1696164789992580551L;

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
		//로그인된 경우 로그인사용자 페이지로 바로 이동
		if(session.getAttribute("loginId") != null) {
			resp.sendRedirect("main.xhtml");
			return;
		}

		
		resp.setContentType("text/html; charset=utf-8"); 		
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>로그인</title>");
		writer.println("<link href='./css/order.css' rel='stylesheet' type='text/css'/>");
		writer.println("</head>");
		writer.println("<body><div id='loginDiv'>");
		writer.println("<form action=\"login.do\" method=\"post\">");
		
		String loginId = "";
		String password = "";
		
		
		Boolean isLogin = null;
		if (session.getAttribute("isLogin") != null) {
			isLogin = (Boolean) session.getAttribute("isLogin");
			if (isLogin == false) {
				writer.println("<h5>[!] 로그인 정보가 일치하지 않습니다. 다시 입력하세요.</h5>");
				loginId = (String) session.getAttribute("loginId");
				password = (String) session.getAttribute("password");
			}
		}
		
		writer.println("<table class='alignCenter'>");
		writer.println("<tr>");
		writer.println("<td> 로그인 ID</td>");
		writer.println("<td><input class='inputText' type='text' name='loginId' value='"+loginId+"'/></td>");
		writer.println("</tr>");
		writer.println("<tr>");
		writer.println("<td>패스워드</td>");
		writer.println("<td><input class='inputText' type='password' name='password' value='"+password+"'/></td>");
		writer.println("</tr>");
		writer.println("</table>");
		writer.println("<input type='submit' value='로그인' class='button' />");
		writer.println("</form>");
		writer.println("</div></body>");
		writer.println("");
		writer.println("</html>");

		
	}
}
