package com.namoosori.board.web.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.board.domain.Article;
import com.namoosori.board.service.facade.BoardService;
import com.namoosori.board.service.factory.NamooBoardServiceFactory;
@WebServlet("/board/articlelist.xhtml")
public class ArticleListController extends HttpServlet{

	private static final long serialVersionUID = 3370843485373760357L;

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
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		BoardService boardService = NamooBoardServiceFactory.getInstance().getBoardService();
		List<Article> articles = boardService.getArticles(boardNo);
		req.setAttribute("boardNo", boardNo);
		req.setAttribute("articles", articles);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/views/board/articlelist.jsp");
		dispatcher.forward(req, resp);
		
		
	}
	
	

}
