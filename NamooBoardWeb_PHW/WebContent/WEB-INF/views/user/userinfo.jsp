<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src='../script/script.js' type='text/javascript'></script>
<title>상세정보</title>
</head>
<body>
<form action="remove.do" method="post">
	<table>
		<tr>
			<td>ID</td>
			<td>${user.userId}<input type="hidden" name="id" value="${user.userId}"></td>
		</tr>
		<tr>
			<td>비밀번호</td>
			<td>${user.password}</td>
		</tr>
		<tr>
			<td>이름</td>
			<td>${user.name}</td>
		</tr>
		<tr>
			<td>이메일</td>
			<td>${user.email}</td>
		</tr>
	</table>
	<input type="submit" value="삭제하기"/> 
	<button onclick='modify(); return false;' class='button'>뒤로가기</button>
	</form>
</body>
</html>