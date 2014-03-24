package com.namoosori.board.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.board.service.facade.UserService;
import com.namoosori.board.service.factory.NamooBoardServiceFactory;
@WebServlet("/user/info.do")
public class UserInfoController extends HttpServlet{
	private static final long serialVersionUID = 8350955991797036251L;

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
		String userId = req.getParameter("id");
		
		req.setAttribute("user", userService.getUser(userId));
		 
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/userinfo.jsp");
		dispatcher.forward(req, resp);
	}
	
	

}
