<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>修改與移除</title>
        <style type="text/css">
            .tg  {
                border-collapse:collapse;
                border-spacing:0;
                border-color:#ccc;
            }
            .tg td{
                font-family:Arial, sans-serif;
                font-size:14px;padding:10px 5px;
                border-style:solid;
                border-width:1px;overflow:hidden;
                word-break:normal;
                border-color:#ccc;color:#333;background-color:#fff;
            }
            .tg th{
                font-family:Arial, sans-serif;
                font-size:14px;
                font-weight:normal;padding:10px 5px;
                border-style:solid;
                border-width:1px;overflow:hidden;
                word-break:normal;
                border-color:#ccc;color:#333;
                background-color:#f0f0f0;
            }
            .tg .tg-4eph
            {
                background-color:#f9f9f9
            }
        </style>
    </head>
    <body>
        <h3>所有帳號</h3>
        <c:if test="${!empty listPersons}">
            <table class="tg">
                <tr>
                    <th width="80">pid</th>
                    <th width="120">username</th>
                    <th width="120">password</th>
                    <th width="120">email</th>
                    <th width="60">修改</th>
                    <th width="60">移除</th>
                </tr>
                <c:forEach items="${listPersons}" var="person">
                    <tr>
                        <td>${person.pid}</td>
                        <td>${person.username}</td>
                        <td>${person.password}</td>
                        <td>${person.email}</td>
                        <td><a href="<c:url value='/edit/${person.pid}' />" >修改</a></td>
                        <td><a href="<c:url value='/remove/${person.pid}' />" >移除</a></td>
                    </tr>
                </c:forEach>
            </table>
        </c:if>
        <br>    
        <form action="/mapGame/persons" role="form">
            <input type="submit" value="註冊頁面">
        </form>   
        <br> 
        <form action="/mapGame/login" role="form">
            <input type="submit" value="登入頁面">
        </form>            
    </body>
</html>
