<%--
  Created by IntelliJ IDEA.
  User: hoanganh
  Date: 5/20/18
  Time: 11:10 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Login</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/Login/main.css"/>' />
    <link rel="icon" href='<c:url value="/resources/black.png"/>' type="image/x-icon"/>
</head>
<body class="login">
    <div id="particles-js"></div>
    <div class="container">
        <div class="login-container-wrapper clearfix">
            <div class="logo">
                <i class="fa fa-sign-in"></i>
            </div>
            <div class="welcome"><strong>Welcome,</strong> please login</div>

            <c:choose>
                <c:when test="${warning != null}">
                    <div class="alert alert-danger">
                        <strong>Warning : </strong> ${warning}
                    </div>
                </c:when>
            </c:choose>


            <form class="form-horizontal login-form" method="post">
                <div class="form-group relative">
                    <input id="login_username" name="username" class="form-control input-lg" type="text" placeholder="Username" autofocus required>
                    <i class="fa fa-user"></i>
                </div>
                <div class="form-group relative password">
                    <input id="login_password" name="password" class="form-control input-lg" type="password" placeholder="Password" required>
                    <i class="fa fa-lock"></i>
                </div>
                <div class="form-group">
                    <button type="submit" class="btn btn-success btn-lg btn-block">Login</button>
                </div>
                <div class="checkbox pull-left">
                    <label><input type="checkbox"> Remember</label>
                </div>
                <div class="checkbox pull-right">
                    <label> <a class="forget" href="/register" title="forget">Register now</a> </label>
                </div>
            </form>
        </div>

        <h4 class="text-center">
            <a target="_blank" href="/">
                HoangAnh &copy; Blog 2018
            </a>
        </h4>
    </div>
    <script src='<c:url value="/resources/Login/particles.js" /> '></script>
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
    <script src='<c:url value="/resources/Login/main.js"/> '></script>
</body>
</html>
