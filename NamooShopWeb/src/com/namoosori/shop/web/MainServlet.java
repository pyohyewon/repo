package com.namoosori.shop.web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.namoosori.namooshop.domain.Product;
import com.namoosori.namooshop.service.factory.NamooShopServiceFactory;
import com.namoosori.namooshop.service.logic.ProductServiceLogic;

@WebServlet("/main.xhtml")
public class MainServlet extends HttpServlet{
	private static final long serialVersionUID = -5441914164986289841L;

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
		resp.setContentType("text/html; charset=utf-8"); 		
		PrintWriter writer = resp.getWriter();
		NamooShopServiceFactory factory = NamooShopServiceFactory.getInstance();
		ProductServiceLogic productService = (ProductServiceLogic) factory.getProductService();
		
		List<Product> products = productService.getAllProducts();
		
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>상품 목록</title>");
		writer.println("<link href='./css/main.css' rel='stylesheet' type='text/css'/>");
		writer.println("</head>");
		writer.println("<body><div id='main'>");
		writer.println("<form action=\"order.do\" method=\"post\">");
		writer.println("<h2>상품 목록</h2>");
	    writer.println("<table>");
	    writer.println("<thead class='alignCenter'><tr>");
	    writer.println("<td></td>");
	    writer.println("<td>상품번호</td>");
	    writer.println("<td>상품명</td>");
	    writer.println("<td>가격</td>");
	    writer.println("<td>평점</td>");
	    writer.println("</tr></thead>");
	    for(Product product : products) {
	    	writer.println("<tr><td class='alignCenter'><input type='checkbox' name='products' value='"+product.getSerialNo()+"'/></td>");	    	
	    	writer.println("<td class='alignCenter'>"+product.getSerialNo()+"</td>");
	    	writer.println("<td>"+product.getName()+"</td>");
	    	writer.println("<td class='alignRight'>" + String.format("%,d", product.getPrice()) + "원</td>");
	    	writer.println("<td class='alignCenter'>"+convertStar(product.getLike())+"</td>");
	    }
	    writer.println("</table>");
	    writer.println("<br />");
	    writer.println("<input class='button' type=\"submit\" value=\"주문하기\" />");
	    writer.println("</form>");
	    writer.println("</div></body>");
	    writer.println("</html>");
		
			
	}
	private String convertStar(int like) {
		//
		String Star = "";
		for (int i = 1; i <= 5; i++) {
			if (i<=like) {
				Star += "★";
			} else {
				Star += "☆";
			}
		}
		return Star;
	}
 
}
