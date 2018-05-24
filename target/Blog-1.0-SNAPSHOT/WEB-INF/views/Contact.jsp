<%--
  Created by IntelliJ IDEA.
  User: hoanganh
  Date: 5/20/18
  Time: 12:11 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Contact Me</title>
    <jsp:include page="Header.jsp"/>
</head>
<body>
    <jsp:include page="TopMenu.jsp"/>

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('<c:url value="/resources/FrontEnd/img/contact-bg.jpg"/>')">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 mx-auto">
                    <div class="page-heading">
                        <h1>Contact Me</h1>
                        <span class="subheading">Have questions? I have answers.</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <p>You can find me on : </p>
                <ul>
                    <li>Facebook : <a href="https://www.facebook.com/hoanganh.hust">my facebook</a></li>
                    <li>Email : anhnguyenhoang1997@gmail.com</li>
                    <li>Github : <a href="https://github.com/HoangAnhBK97">https://github.com/HoangAnhBK97/</a></li>
                </ul>
            </div>
        </div>
    </div>

    <hr>

    <jsp:include page="Footer.jsp"/>
</body>
</html>
