package com.namoosori.board.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.board.domain.Board;
import com.namoosori.board.service.facade.BoardService;
import com.namoosori.board.service.factory.NamooBoardServiceFactory;
@WebServlet("/board/boardlist.xhtml")
public class BoardListController extends HttpServlet{
	private static final long serialVersionUID = 5949676744244394714L;
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
		BoardService boardService = NamooBoardServiceFactory.getInstance().getBoardService();
		
		List<Board> boards = boardService.getAllBoards();
		req.setAttribute("boards", boards);


		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/boardlist.jsp");
		dispatcher.forward(req, resp);
		
	}
	

}
