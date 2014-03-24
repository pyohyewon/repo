package com.namoosori.board.web.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.board.service.facade.BoardService;
import com.namoosori.board.service.factory.NamooBoardServiceFactory;
@WebServlet("/board/article.xhtml")
public class ArticleController extends HttpServlet{
	private static final long serialVersionUID = -2025823380548288015L;

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
		int articleNo = Integer.parseInt(req.getParameter("articleNo"));
		String content = boardService.getArticle(articleNo).getContent();
		req.setAttribute("content", content);
		
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/article.jsp");
		dispatcher.forward(req, resp);
	}
	

}
