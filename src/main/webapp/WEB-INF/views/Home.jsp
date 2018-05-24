<%--
  Created by IntelliJ IDEA.
  User: hoanganh
  Date: 5/19/18
  Time: 11:05 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <jsp:include page="Header.jsp"/>
</head>
<body style="background-image: linear-gradient(to top, #fff1eb 0%, #ace0f9 100%);">
    <jsp:include page="TopMenu.jsp"/>

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('<c:url value="/resources/FrontEnd/img/home.jpg"/>')">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 mx-auto">
                    <div class="site-heading">
                        <img src='<c:url value="/resources/FrontEnd/img/avatar.jpeg"/>' class="img-circle"
                             alt="Cinque Terre" width="150" height="150" style="border-radius: 50%">
                        <h1 style="font-size:40px;">Nguyễn Hoàng Anh</h1>
                        <span class="subheading">Every day I become a better person, Not for anyone, but for myself</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <div class="container">
        <div class="input-group" style="margin-bottom: 30px; margin-top: -30px; width: 70%;">
            <input type="text" class="form-control" placeholder="Search" id="search_post" id_page="${id}">
        </div>
    </div>

    <!-- Main Content -->
    <div class="container">
        <div class="row">
            <div class="col-lg-8 col-md-10 mx-auto" id="content_page">
                <c:forEach var="post" items="${listPost}">
                    <div class="post-preview">
                        <div class="row">
                            <div class="col-sm-4">
                                <img src='/resources/Image/${post.getImage()}' alt="Image" width="250px" height="185px"/>
                            </div>
                            <div class="col-sm-8">
                                <a href="/post/${post.getIdPost()}">
                                    <h2 class="post-title">
                                        ${post.getTitle()}
                                    </h2>
                                </a>
                                <c:choose>
                                    <c:when test="${post.getContent().length() > 250}">
                                        <h6 class="post-subtitle">
                                                ${post.getContent().substring(0,250)}
                                        </h6>
                                    </c:when>
                                    <c:otherwise>
                                        <h6 class="post-subtitle">
                                                ${post.getContent()}
                                        </h6>
                                    </c:otherwise>
                                </c:choose>
                                <p class="post-meta">Posted by
                                    <a href="#">${post.getUser().getUsername()}</a>
                                    on ${post.getCreatedAt()}</p>
                            </div>
                        </div>
                    </div>
                    <hr>
                </c:forEach>
                <!-- Pager -->
                <c:if test="${counts > (id-1)*3}">
                    <div class="clearfix">
                        <a class="btn btn-primary float-right" href="/page/${id}">Older Posts &rarr;</a>
                    </div>
                </c:if>
            </div>
        </div>
    </div>

    <hr>

    <jsp:include page="Footer.jsp"/>
</body>
</html>
