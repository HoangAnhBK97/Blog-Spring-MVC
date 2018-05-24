<%--
  Created by IntelliJ IDEA.
  User: hoanganh
  Date: 5/20/18
  Time: 12:06 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>About me</title>
    <jsp:include page="Header.jsp"/>
</head>
<body>
    <jsp:include page="TopMenu.jsp"/>

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('<c:url value="/resources/FrontEnd/img/about.png"/>')">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 mx-auto">
                    <div class="page-heading">
                        <h1>About Me</h1>
                        <span class="subheading">This is what I do.</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Main Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto">
                <p>
                    Hello guy, I'm Hoang Anh, a student of Ha Noi University of Science and Technology. My major is
                    Electronics and Telecommunications, but I have a passion for programing. So I'm improving my skills
                    to become a full-stack developer.
                </p>
                <p>
                    I think the best way to improving my self is share and be shared my knowledge and experiences with
                    other people. That's reason I created this blog. I hope you support me <3
                </p>
            </div>
        </div>
    </div>

    <hr>
    <jsp:include page="Footer.jsp"/>
</body>
</html>
