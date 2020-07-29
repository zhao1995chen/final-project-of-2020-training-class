<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Emp Form</title>
    </head>
    <body>
     <form:form method="post" action="save">    
        <table >    
         <tr>    
          <td>username : </td>   
          <td><form:input path="username"  /></td>  
         </tr>    
         <tr>    
          <td>email :</td>    
          <td><form:input path="email" /></td>  
         </tr>   
         <tr>    
          <td>password :</td>    
          <td><form:input path="password" /></td>  
         </tr>   
         <tr>    
          <td>payList :</td>    
          <td><form:input path="payList" /></td>  
         </tr>           
         <tr>    
          <td colspan="2"><input type="submit" onclick="Login()" value="Save" /></td>    
         </tr>    
        </table>    
       </form:form>    
        <div id="div1"> Result </div>

<script>
          function Login(){
              var id=$("#pid").val();
              var use=$("#username").val();
              var pass=$("#password").val();
              var mail=$("#email").val();
              var pay=$("#payList").val();
             
              $.ajax({
                  url: "registeredServlet",
                  data: {"pid":id,"username":use ,"password":pass,"email":mail,"payList":pay},
                  type: "post",
                  dataType: 'html',
                  success: function (msg) {
                      $("#div1").html(msg);
                  },
                  error: function (xhr, ajaxOptions, thrownError) {
                      alert(xhr.status);
                      alert(thrownError);
                  }
              });
          }
   </script> 
    </body>
</html>
 
