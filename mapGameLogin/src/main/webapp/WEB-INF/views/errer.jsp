<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>失敗</title>
    </head>
    <body>
        <h1>${message}</h1>
        <form action="/mapGame/login" role="form">
            <input type="submit" value="返回登入頁面">
        </form> 
    </body>
</html>
