package com.namoosori.shop.web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.namoosori.namooshop.domain.Product;
import com.namoosori.namooshop.service.factory.NamooShopServiceFactory;
import com.namoosori.namooshop.service.logic.CustomerServiceLogic;
import com.namoosori.namooshop.service.logic.ProductServiceLogic;
@WebServlet("/order.xhtml")
public class OrderFormServlet extends HttpServlet{

	private static final long serialVersionUID = -3668707929348084198L;

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
		if(session.getAttribute("loginId") == null) {
			resp.sendRedirect("login.xhtml");
			return;
		}
		
		NamooShopServiceFactory factory = NamooShopServiceFactory.getInstance();
		ProductServiceLogic productService = (ProductServiceLogic) factory.getProductService();
		CustomerServiceLogic customerService = (CustomerServiceLogic) factory.getCustomerService();
		
		resp.setContentType("text/html; charset=utf-8"); 	
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>주문 상품 목록</title>");
		writer.println("<link href='./css/order.css' rel='stylesheet' type='text/css'/>");
		writer.println("</head>");
		
		writer.println("<body><div id='order'>");
		writer.println("<form action=\"confirm.xhtml\" method=\"post\">");
		String userId = (String) session.getAttribute("loginId");
		String name = customerService.getCustomer(userId).getName();
		writer.println("<h3> ["+name+" 님]로그인 되었습니다.</h3>");
		writer.println("<h2>주문 상품</h2>");
		writer.println("<table>");
		writer.println("<thead class='alignCenter'><tr>");
	    writer.println("<td>상품번호</td>");
	    writer.println("<td>상품명</td>");
	    writer.println("<td>가격</td>");
	    writer.println("</tr></thead>");
		String[] products = req.getParameterValues("products");
		int price =0;

		for(String productName : products) {
			Product product= productService.getProduct(Integer.parseInt(productName));
			writer.println("<tr><td class='alignCenter'>"+product.getSerialNo()+"<input type='hidden' name='products' value='"+product.getSerialNo()+"'></td>");
			writer.println("<td>"+product.getName()+"</td>");
			writer.println("<td class='alignRight'>" + String.format("%,d", product.getPrice()) + "원</td>");
			price+=product.getPrice();
		}		
		writer.println("</table>");
		writer.println("<h2 class='textRight'>주문금액:"+String.format("%,d",price)+"원</h2><br />");
		
		writer.println("<br /><h2>주문정보 입력</h2>");
		writer.println("<table>");
		writer.println("<tr>");
	    writer.println("<td class='alignCenter'>결제방법</td>");
	    writer.println("<td><input type='radio' name='pay' value='신용카드' />신용카드 <input type='radio' name='pay' value='실시간 이체'/>실시간 이체</td>");
	    writer.println("</tr>");
	    writer.println("<tr>");		
	    writer.println("<td class='alignCenter'>배송지주소</td>");
	    writer.println("<td><input type = 'text' name = 'address' id='inputText' /></td>");
	    writer.println("</tr>");	
		writer.println("</table>");
		writer.println("<br /><input type='submit' value='주문신청' class='button' />");
		writer.println("</form>");
		writer.println("</div>");
		writer.println("</body>");
		writer.println("</html>");
	}
	
	

}
