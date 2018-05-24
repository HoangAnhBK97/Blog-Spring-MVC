<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hoanganh
  Date: 5/22/18
  Time: 10:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <jsp:include page="Header.jsp"/>
</head>
<body style="background-image: linear-gradient(to top, #fff1eb 0%, #ace0f9 100%);">
    <jsp:include page="TopMenu.jsp"/>

    <!-- Page Header -->
    <header class="masthead" style="background-image: url('/resources/Image/${post.getImage()}'); background-repeat: no-repeat;
            background-size: cover;">
        <div class="overlay"></div>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 mx-auto">
                    <div class="post-heading">
                        <h1>${post.getTitle()}</h1>
                        <span class="meta">Posted by
                <a href="#">${post.getUser().getUsername()}</a>
                on ${post.getCreatedAt()}</span>
                    </div>
                </div>
            </div>
        </div>
    </header>

    <!-- Post Content -->
    <article>
        <div class="container">
            <div class="row">
                <div class="col-lg-8 col-md-10 mx-auto">
                    <p>${post.getContent()}</p>
                </div>
            </div>
        </div>
    </article>
    <hr/>
    <div class="container">
        <div class="comments">
            <div id="listcomments">
                <h4>List of comments :</h4>
            </div>
            <div id="content-comments">
                <c:choose>
                    <c:when test="${countComment == 0 || countComment == null}">
                        <div class="container">
                            <p>No comments ....</p><hr/>
                        </div>
                        <c:choose>
                            <c:when test="${username != null}">
                                <div class="container">
                                    <div class="form-group">
                                        <label for="comment">Comment:</label>
                                        <textarea class="form-control commentcontent" rows="5" id="comment"></textarea>
                                    </div>
                                    <button class="btn btn-primary btn-comment" id_post="${post.getIdPost()}">Comment</button>
                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="container">
                                    <h3>You must be <a href="/login">login</a> to comment this post.</h3>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:when>
                    <c:otherwise>
                        <div class="container">
                            <div class="comments-container">

                                <ul id="comments-list" class="comments-list">
                                    <c:forEach var="comment" items="${listComment}">
                                        <li>
                                            <div class="comment-main-level">
                                                <!-- Avatar -->
                                                <div class="comment-avatar"><img src="http://i9.photobucket.com/albums/a88/creaticode/avatar_1_zps8e1c80cd.jpg" alt=""></div>
                                                <!-- Contenedor del Comentario -->
                                                <div class="comment-box">
                                                    <div class="comment-head">
                                                        <h6 class="comment-name by-author"><a href="http://creaticode.com/blog">${comment.getUser().getFullName()}</a></h6>
                                                        <span>on ${comment.getCreatedAt()}</span>
                                                        <c:if test="${comment.getUser().getIdUser() == user.getIdUser()}">
                                                            <i class="fa fa-remove btn-delete-comment-2" id_post="${comment.getIdComment()}"></i>
                                                        </c:if>
                                                    </div>
                                                    <div class="comment-content">
                                                            ${comment.getContent()}
                                                    </div>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                        <c:choose>
                            <c:when test="${username != null}">
                                <div class="container">
                                    <div class="form-group">
                                        <label for="id_comment">Comment:</label>
                                        <textarea class="form-control commentcontent" rows="5" id="id_comment"></textarea>
                                    </div>
                                    <button class="btn btn-primary btn-comment" id="btn-comment" id_post="${post.getIdPost()}" >Comment</button>

                                </div>
                            </c:when>
                            <c:otherwise>
                                <div class="container">
                                    <p>You must be <a href="/login">login</a> to comment this post.</p>
                                </div>
                            </c:otherwise>
                        </c:choose>
                    </c:otherwise>
                </c:choose>
            </div>
        </div>
    </div>

    <jsp:include page="Footer.jsp"/>
    <script src='<c:url value="/resources/BackEnd/js/custome.js"/>' ></script>
</body>
</html>
