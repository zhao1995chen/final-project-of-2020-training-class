<%-- 
    Document   : sessionattr
    Created on : 2020/7/30, 下午 03:06:03
    Author     : Chang
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        session.setAttribute("userName","John")<br>
        <% session.setAttribute("userName", "John");%>
        session.setAttribute("userName","John")<br>
        <% session.setAttribute("userName", "John2");%>
        session.removeAttribute("userName","John2")<br>
        <% session.removeAttribute("userName");%>
        目前有<%=getServletContext().getAttribute("users")%>個用戶。<br>
        after session.invalidate()<br>
        <% session.invalidate();%>
        目前有<%=getServletContext().getAttribute("users")%>個用戶。

    </body>
</html>
