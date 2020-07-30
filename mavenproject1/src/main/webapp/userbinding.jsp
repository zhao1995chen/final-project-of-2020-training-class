<%-- 
    Document   : userbinding
    Created on : 2020/7/30, 下午 01:52:07
    Author     : Chang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="domain.*"%>
<%@page import="java.util.*"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            String username = request.getParameter("username");           
            session.setMaxInactiveInterval(120);   //設定其過期的時限為 2分鐘
            UserInfo user = UserInfo.getInstance();
            ArrayList list = user.getList();    //取得存放所有用戶的 Vector
            UserSessionBinding usb = new UserSessionBinding();
            usb.setUsername(username);
            user.addUser(username);   //加入至 list
            session.setAttribute("user", usb);   //此處發生 binding
            session.invalidate();
        %>
        <h1>Session Object Binding</h1>
    </body>
</html>
