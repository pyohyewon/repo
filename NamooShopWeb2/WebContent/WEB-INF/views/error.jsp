<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Error</title>
<link href='./css/error.css' rel='stylesheet' type='text/css'/>
</head>
<body>
	<div id='error'>
		<h1><%= exception.getMessage() %></h1>
		<a href="javascript:history.back();">이전으로</a>
	</div>
</body>
</html>