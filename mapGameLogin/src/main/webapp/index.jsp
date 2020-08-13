<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%String basePath=request.getContextPath(); %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>註冊</title>
</head>

<body>
<h2>註冊</h2>
<hr/>
<form method="POST" action="register">
<table>
	<tr>
	<td><label for="username">用戶:</label></td>
	<td><input type="text" name="username" id="username" /></td>
	</tr>
	<tr>
	<td><label for="password">密碼:</label></td>
	<td><input type="password" name="password" id="password" /></td>
	</tr>
	<tr>
	<td><label for="email">信箱:</label></td>
	<td><input type="email" name="email" id="email"/></td>
	<tr>
	<td colspan="2"><input type="submit" value="註冊" /></td>
	</tr>
</table>
</form>
</body>
</html>
