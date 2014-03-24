<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>회원 목록</title>
</head>
<body>
	<div id='list'>
		<form action="join.do" method="post">

			<h2>회원 목록</h2>
			<br/>
			<a href="${ctx}/board/boardregist.xhtml">게시판 등록</a>
			<a href="${ctx}/board/boardlist.xhtml">게시판 목록</a>
			<table>
				<thead class='alignCenter'>
					<tr>
						<td>ID</td>
						<td>이름</td>
						<td>이메일</td>
						<td>상세보기</td>
					</tr>
				</thead>

				<c:forEach var="user" items="${users}">
					<tr>
						<td class='alignCenter'>${user.userId}</td>
						<td class='alignCenter'>${user.name}</td>
						<td>${user.email}</td>
						<td class='alignRight'><button onclick="location.href='${ctx}/user/info.do?id=${user.userId}'; return false;">상세보기</button>
 						</td>
					</tr>
				</c:forEach>
			</table>
			<br /> <input class='button' type="submit" value="회원가입" />
		</form>
	</div>
</body>
</html>