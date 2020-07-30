<%@page import="domain.*"%>
<!DOCTYPE html>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" import="java.util.*" isELIgnored="false"%>
<html>
<head>
    <meta charset="utf-8">
    <title>user_Login</title>
</head>
<body>
<form action="/myweb/login" role="form">
    帳號：<input type="text" name="username" value="abc"><br/>
    密碼：<input type="text" name="password" value="abc"><br/>
    <input type="submit" value="登入">
</form>
<form action="/myweb/sreach" role="form">
    <input type="submit" value="查詢">
</form>    

</body>
</html>