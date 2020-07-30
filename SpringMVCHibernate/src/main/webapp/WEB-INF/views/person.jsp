<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>新增帳號</title>
        <style type="text/css">   
            input:invalid{
                border-color: #900;
                background-color: #FDD;
            }
            input:focus:invalid {
                outline: none;
            }
            .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
            .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
            .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
            .tg .tg-4eph{background-color:#f9f9f9}
        </style>
    </head>

    <body>
        <h1>
            註冊帳號
        </h1>

        <c:url var="addAction" value="/person/add" ></c:url>

        <form:form action="${addAction}" commandName="person">
            <table>
                <c:if test="${!empty person.username}">
                    <tr>
                        <td>
                            <form:label path="pid">
                                <spring:message text="ID"/>
                            </form:label>
                        </td>
                        <td>
                            <form:input path="pid" readonly="true" size="8"  disabled="true" />
                            <form:hidden path="pid" />
                        </td> 
                    </tr>
                </c:if>
                <tr>
                    <td>
                        <form:label path="username">
                            <spring:message text="Name"/>
                        </form:label>
                    </td>
                    <td>
                        <div class="controls">
                            <input type="username" name="username" path="username" placeholder="Username" class="form-control" required="">                             
                        </div>
                    </td> 
                </tr>
                <tr>
                    <td>
                        <form:label path="password">
                            <spring:message text="Password"/>
                        </form:label>
                    </td>
                    <td>
                        <div class="controls">
                            <input type="password" name="password" path="password" placeholder="Password" class="form-control" required="">                             
                        </div>
                    </td>
                </tr>
                <tr>
                    <td>
                        <form:label path="email">
                            <spring:message text="Email"/>
                        </form:label>
                    </td>
                    <td>
                        <div class="controls">
                            <input type="email" name="email" path="email" placeholder="Email" class="form-control" required="">                             
                        </div>
                    </td>
                </tr>        
                <tr>
                    <td colspan="2">
                        <c:if test="${empty person.username}">
                            <input type="submit"
                                   value="<spring:message text="確定註冊"/>" />
                        </c:if>
                    </td>
                </tr>
            </table>	
        </form:form>      
        <br>             
        <form action="/mapGame/jq" role="form">
            <input type="submit" value="帳號修改">
        </form>
        <form action="/mapGame/login" role="form">
            <input type="submit" value="登入頁面">
        </form>  
    </body>
</html>
