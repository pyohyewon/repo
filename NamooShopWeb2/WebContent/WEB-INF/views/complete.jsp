<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<title>주문 완료</title>
<link href='./css/complete.css' rel='stylesheet' type='text/css'/>
</head>
<body>
	<div id='complete'>
		<form action="main.xhtml" method="post">
			<h3>${loginName}님상품 주문이 완료되었습니다.</h3>
			<input id='submit' type='submit' value='확인' />
		</form>
	</div>
</body>
</html>
