<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hoanganh
  Date: 5/19/18
  Time: 11:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!-- Navigation -->
<nav class="navbar navbar-expand-lg navbar-light fixed-top" id="mainNav">
    <div class="container">
        <a class="navbar-brand" href="/">HoangAnhBK</a>
        <button class="navbar-toggler navbar-toggler-right" type="button" data-toggle="collapse" data-target="#navbarResponsive" aria-controls="navbarResponsive" aria-expanded="false" aria-label="Toggle navigation">
            Menu
            <i class="fa fa-bars"></i>
        </button>
        <div class="collapse navbar-collapse" id="navbarResponsive">
            <ul class="navbar-nav ml-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/about">About</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/contact">Contact</a>
                </li>
                <c:choose>
                    <c:when test="${username != null}">
                        <li class="nav-item login">
                            <a class="nav-link" href=""><i class="fa fa-user"></i><span>Hi,</span>${username}</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/logout" pastyle="margin-right: -100px;"><i class="fa fa-sign-in"></i>Logout</a>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <li class="nav-item login">
                            <a class="nav-link" href="/login"><i class="fa fa-sign-in"></i>Login</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link" href="/register" style="margin-right: -100px;"><i class="fa fa-lock"></i>Sign Up</a>
                        </li>
                    </c:otherwise>
                </c:choose>
            </ul>
        </div>
    </div>
</nav>
