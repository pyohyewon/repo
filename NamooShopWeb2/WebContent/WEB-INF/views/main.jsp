<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="namoo" uri="../namoosori.tld" %>
<%@ taglib prefix="my" uri="../pricetag.tld" %>
<!DOCTYPE html>

<html>
<head>
<title>상품 목록</title>
<link href='./css/main.css' rel='stylesheet' type='text/css' />
<script src='./script/script.js' type='text/javascript'></script>
</head>
<body>

	<div id='main'>
		<form action="order.do" method="post">
			<div>
				<h4>[${loginName}님]로그인 되었습니다.</h4>
				<input type='button' class="button" id="logout" value="로그아웃"
					onclick="location.href='logout.do'">
			</div>
			<h2>상품 목록</h2>
			<table>
				<thead class='alignCenter'>
					<tr>
						<td></td>
						<td>상품번호</td>
						<td>상품명</td>
						<td>가격</td>
						<td>평점</td>
					</tr>
				</thead>

				<c:forEach var="product" items="${products}">
					<tr>
						<td class='alignCenter'><input type='checkbox'
							name='products' id='check' value='${product.serialNo}' /></td>
						<td class='alignCenter'>${product.serialNo}</td>
						<td>${product.name}</td>
						<td class='alignRight'><my:currency value="${product.price}" />원</td>
						<td class='alignCenter'><namoo:convertStar
								count="${product.like}" /></td>
					</tr>
				</c:forEach>
			</table>
			<br /> <input class='button' type="submit"
				onclick="return checkForm();" value="주문하기" />
		</form>
	</div>
</body>
</html>
