<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>로그인</title>
</head>
<body>
	<form action="login.do" method="post">
		<h2>로그인</h2>
		<c:choose>
			<c:when test="${loginUserId != null}">
				<h5>[!] 로그인 정보가 일치하지 않습니다. 다시 입력하세요.</h5>
			</c:when>
		</c:choose>

		<table class='alignCenter'>
			<tr>
				<td>로그인 ID</td>
				<td><input class='inputText' type='text' name='loginId'	value='${loginUserId}' /></td>
			</tr>
			<tr>
				<td>패스워드</td>
				<td><input class='inputText' type='password' name='password' value='${userPassword}' /></td>
			</tr>
		</table>
		<br /> <input type='submit' value='로그인' class='button' />
		<button onclick="location.href='${ctx}/user/join.do'; return false;">회원가입</button>
	</form>
</body>
</html>