<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
<table border="2" width="70%" cellpadding="2">  
<tr><th>pid</th><th>username</th><th>email</th><th>password</th><th>payList</th></tr>  
   <c:forEach var="Personallnformation" items="${list}">   
   <tr>  
   <td>${Personallnformation.pid}</td>  
   <td>${Personallnformation.username}</td>  
   <td>${Personallnformation.email}</td>  
   <td>${Personallnformation.password}</td>  
   <td>${Personallnformation.payList}</td>  
   </tr>  
   </c:forEach>  
   </table>
<form action="/myweb/login.jsp" role="form">
    <input type="submit" value="返回登入">
</form>         
<form action="/myweb/register.jsp" role="form">
    <input type="submit" value="返回註冊">
</form> 
    </body>
</html>
