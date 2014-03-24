<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>게시글 목록</title>
</head>
<body>
	<h2>게시글 목록</h2>
	<br />
	<form method="post" action="write.xhtml?boardNo=${boardNo}">

	<table>
		<thead>
			<tr>
				<td>게시글 번호</td>
				<td>제목</td>
				<td>날짜</td>
				<td>글쓴이</td>
			</tr>
		</thead>
		<c:forEach var="article" items="${articles}">
			<tr>
				<td class='alignCenter'>${article.articleNo}</td>
				<td class='alignCenter'><a href="${ctx}/board/article.xhtml?articleNo=${article.articleNo}">${article.subject}</a></td>
				<td class='alignCenter'>${article.regDate}</td>
				<td class='alignCenter'>${article.author.name}</td>
			</tr>
		</c:forEach>
	</table>
	<input type="submit" value="글쓰기"/>
	</form>
</body>
</html>