<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 등록</title>
</head>
<body>
	<form action="boardregist.do" method="post">
		<h2>게시판 등록</h2>
		<table>
			<tr>
				<td>게시판 이름</td>
				<td><input type="text" name="boardName"></td>
			</tr>
			<tr>
				<td>관리자 ID</td>
				<td><input type="hidden" name="managerId" value="${loginName}"/>${loginName}</td>
			</tr>
		</table>
		<input type="submit" value="등록하기"/>
	</form>
</body>
</html>