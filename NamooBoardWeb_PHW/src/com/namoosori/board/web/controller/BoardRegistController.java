package com.namoosori.board.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.board.service.facade.BoardService;
import com.namoosori.board.service.factory.NamooBoardServiceFactory;
@WebServlet("/board/boardregist.do")
public class BoardRegistController extends HttpServlet{

	private static final long serialVersionUID = 696752918820975915L;

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
		String boardName = req.getParameter("boardName");
		String managerId = req.getParameter("managerId");
		
		BoardService boardService = NamooBoardServiceFactory.getInstance().getBoardService();
		boardService.createBoard(boardName, managerId);
		
		resp.sendRedirect("../user/list.do");
	}
	
	

}
