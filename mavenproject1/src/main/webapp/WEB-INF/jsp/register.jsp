<%-- 
    Document   : index
    Created on : 2020/7/30, 上午 12:46:47
    Author     : admin
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="domain.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <h1>${message}</h1>
<form action="/myweb/login.jsp" role="form">
    <input type="submit" value="返回登入">
</form>         
<form action="/myweb/register.jsp" role="form">
    <input type="submit" value="返回註冊">
</form> 
    </body>
</html>
