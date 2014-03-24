<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>글쓰기</title>
</head>
<body>
	<form action="write.do?boardNo=${param.boardNo}" method="post">
		<table>
			<tr>
				<td>글쓴이:</td>
				<td><input type="hidden" name="userId" value="${loginName}"/>${loginName}</td>
			</tr>
			<tr>
				<td>제목:</td>
				<td><input type="text" name="subject" /></td>
			</tr>
			<tr>
				<td>내용:</td>
				<td><textarea rows="10" cols="50" name="content"></textarea></td>
			</tr>
			<tr></tr>
		</table>
		<input type="submit" value="등록" />
	</form>
</body>
</html>