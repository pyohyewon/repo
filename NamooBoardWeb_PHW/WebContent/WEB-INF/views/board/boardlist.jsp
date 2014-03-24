<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시판 목록</title>
</head>
<body>
	<h2>게시판 목록</h2>
	<br />
	<table>
		<thead>
			<tr>
				<td>게시판 번호</td>
				<td>게시판 이름</td>
			</tr>
		</thead>
		<c:forEach var="board" items="${boards}">
			<tr>
				<td class='alignCenter'>${board.boardNo}</td>
				<td class='alignCenter'><a href="${ctx}/board/articlelist.xhtml?boardNo=${board.boardNo}">${board.name}</a></td>
				<td class='alignCenter'>${board.representiveManager}</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>