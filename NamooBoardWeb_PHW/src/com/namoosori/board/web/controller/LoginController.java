package com.namoosori.board.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namoosori.board.service.facade.UserService;
import com.namoosori.board.service.factory.NamooBoardServiceFactory;
@WebServlet("/user/login.do")
public class LoginController extends HttpServlet{
	private static final long serialVersionUID = 571709368286178055L;

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
		UserService userService = NamooBoardServiceFactory.getInstance().getUserService();

		//요청 파라미터
		String userId=req.getParameter("loginId");
		String password=req.getParameter("password");

		HttpSession session = req.getSession();

		if(userService.login(userId, password).isSuccess()) {
			//로그인 성공!
			session.setAttribute("loginName", userService.getUser(userId).getUserId());
			resp.sendRedirect("list.do");			
			
		} else if(!userService.login(userId, password).isSuccess()) {
			// 로그인 실패
			session.removeAttribute("loginName");
			session.setAttribute("loginUserId", userId);
			session.setAttribute("userPassword", password);	
			RequestDispatcher dispatcher = req.getRequestDispatcher("loginForm.do");
			dispatcher.forward(req, resp);
		}
	}
	
	

}
