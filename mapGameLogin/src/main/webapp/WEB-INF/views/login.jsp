<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ page session="false" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="robots" content="none">
        <meta name="viewport" content="width=device-width, initial-scale=1.0, user-scalable=0, minimal-ui">
        <meta name="description" content="admin login">
        <title>User - MapGame</title>
        <link rel="stylesheet" href="http://admin.yutoshield.com/vendor/tcg/voyager/assets/css/app.css">
        <style>
            input:invalid{
                border-color: #900;
                background-color: #FDD;
            }
            input:focus:invalid {
                outline: none;
            }
            body {
                background-image:url('http://admin.yutoshield.com/vendor/tcg/voyager/assets/images/bg.jpg');
                background-color: #FFFFFF;
            }
            body.login .login-sidebar {
                border-top:5px solid #22A7F0;
            }
            @media (max-width: 767px) {
                body.login .login-sidebar {
                    border-top:0px !important;
                    border-left:5px solid #22A7F0;
                }
            }
            body.login .form-group-default.focused{
                border-color:#22A7F0;
            }
            .login-button, .bar:before, .bar:after{
                background:#22A7F0;
            }
        </style>
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,700" rel="stylesheet">
        <script src="chrome-extension://jhffgcfmcckgmioipfnmbannkpncfipo/util.js"></script>
        <script src="chrome-extension://jhffgcfmcckgmioipfnmbannkpncfipo/pagejs.js"></script>
    </head>
    <body class="login">
        <div class="container-fluid">
            <div class="row">
                <div class="faded-bg animated"></div>
                <div class="hidden-xs col-sm-7 col-md-8">
                    <div class="clearfix">
                        <div class="col-sm-12 col-md-10 col-md-offset-2">
                            <div class="logo-title-container">
                                <img class="img-responsive pull-left flip logo hidden-xs animated fadeIn" src="http://admin.yutoshield.com/vendor/tcg/voyager/assets/images/logo-icon-light.png" alt="Logo Icon">
                                <div class="copy animated fadeIn">
                                    <h1>MapGmae登入</h1>
                                    <p>User</p>
                                </div>
                            </div> 
                        </div>
                    </div>
                </div>
                <c:url var="addAction" value="/login/in" ></c:url>
                <form:form action="${addAction}" commandName="person">
                    <div class="col-xs-12 col-sm-5 col-md-4 login-sidebar">
                        <div class="login-container">
                            <p>輸入帳號:</p>

                            <div class="form-group form-group-default" id="emailGroup">
                                <label>帳號</label>
                                <div class="controls">
                                    <input type="username" name="username" path="username" placeholder="Username" class="form-control" required="">                                  
                                </div>
                            </div>
                            <div class="form-group form-group-default" id="passwordGroup">
                                <label>密碼</label>
                                <div class="controls">
                                    <input type="password" name="password" path="password" placeholder="Password" class="form-control" required="">                             
                                </div>
                            </div>
                            <button type="submit" class="btn btn-block login-button">
                                <span class="signingin hidden"><span class="voyager-refresh"></span> Logging in...</span>
                                <span class="signin">登入</span>                        
                            </button>        
                            <div style="clear:both"></div>                                
                        </form:form>                        
                        </form>                      
                        <form action="/mapGame/persons" role="form">
                            <button type="submit" class="btn btn-block login-button">
                                <span class="signingin hidden"><span class="voyager-refresh"></span> Logging in...</span>
                                <span class="signin">註冊帳號</span>                        
                            </button>
                        </form> 
                    </div> 
                </div> 
            </div>             
        </div>                
    </body>
</html>

