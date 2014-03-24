package com.namoosori.board.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.board.service.facade.UserService;
import com.namoosori.board.service.factory.NamooBoardServiceFactory;
@WebServlet("/user/remove.do")
public class RemoveController extends HttpServlet{
	private static final long serialVersionUID = -2582258926036237070L;

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
		userService.removeUser(req.getParameter("id"));
		
		resp.sendRedirect("./list.do");
	}
	

}
