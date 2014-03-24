package com.namoosori.board.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namoosori.board.domain.User;
import com.namoosori.board.service.facade.UserService;
import com.namoosori.board.service.factory.NamooBoardServiceFactory;

@WebServlet("/user/list.do")
public class UserListController extends HttpServlet{

	private static final long serialVersionUID = 1503129561084751689L;

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
			resp.sendRedirect("loginForm.do");
			return;
		}
		UserService userService = NamooBoardServiceFactory.getInstance().getUserService();
		
		List<User> users = userService.getAllUsers();
		req.setAttribute("users", users);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/user/userlist.jsp");
		dispatcher.forward(req, resp);
		
	}
	
	

}
