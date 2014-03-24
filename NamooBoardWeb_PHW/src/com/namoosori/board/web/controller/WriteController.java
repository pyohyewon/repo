package com.namoosori.board.web.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.board.domain.Article;
import com.namoosori.board.service.facade.BoardService;
import com.namoosori.board.service.facade.UserService;
import com.namoosori.board.service.factory.NamooBoardServiceFactory;
@WebServlet("/board/write.do")
public class WriteController extends HttpServlet{
	private static final long serialVersionUID = 5223516849945480114L;

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
		UserService userService = NamooBoardServiceFactory.getInstance().getUserService();
		 
		int boardNo = Integer.parseInt(req.getParameter("boardNo"));
		String subject = req.getParameter("subject");
		String content = req.getParameter("content");
		String userId = req.getParameter("userId");
		
		Article article = new Article();
		article.setSubject(subject);
		article.setContent(content);
		article.setAuthor(userService.getUser(userId));

		
		boardService.saveArticle(boardNo, article);
		resp.sendRedirect(req.getServletContext().getContextPath()+"/board/articlelist.xhtml?boardNo="+boardNo);

	}
	

}
