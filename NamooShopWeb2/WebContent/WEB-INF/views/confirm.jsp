<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>

<html>
<head>
<title>주문 상품 목록</title>
<link href='./css/order.css' rel='stylesheet' type='text/css'/>
<script src='./script/script.js' type='text/javascript'></script>
</head>
<body>
	<div id='order'>
		<form action="complete.do" method="post">
			<h4>[${loginName}님]로그인 되었습니다.</h4>
			<h2>주문 상품</h2>
			<table>
				<thead class='alignCenter'>
					<tr>
						<td>상품번호</td>
						<td>상품명</td>
						<td>가격</td>
					</tr>
				</thead>
				<c:forEach var="product" items="${products}">
					<tr>
						<td class='alignCenter'>${product.serialNo}<input type='hidden' name='products' value='${product.serialNo}'></td>
						<td>${product.name}</td>
						<td class='alignRight'><fmt:formatNumber value="${product.price}" type="NUMBER" groupingUsed="TRUE"></fmt:formatNumber>원</td>
					</tr>
				</c:forEach>
			</table>
			<h2 class='textRight'>주문금액:<fmt:formatNumber value="${orderPrice}" type="NUMBER" groupingUsed="TRUE"></fmt:formatNumber>원</h2>
			<br /> <br />
			<h2>주문정보 확인</h2>
			<table>
				<tr>
					<td class='alignCenter'>결제방법</td>
					<td>${pay}</td>
				</tr>
				<tr>
					<td class='alignCenter'>배송지주소</td>
					<td>${address}</td>
				</tr>
			</table>
			<br />
			<input type='submit' value='신청완료' class='button' />
			<button onclick='modify(); return false;' class='button'>수정</button>
		</form>
	</div>
</body>
</html>
