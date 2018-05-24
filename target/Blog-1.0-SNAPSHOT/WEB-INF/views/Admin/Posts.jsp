<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hoanganh
  Date: 5/22/18
  Time: 12:08 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Post Manager</title>
    <jsp:include page="Header.jsp"/>
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
<jsp:include page="Menu.jsp"/>
<div class="content-wrapper">
    <div class="container-fluid">
        <ol class="breadcrumb">
            <li class="breadcrumb-item">
                <i class="fa fa-home"></i><a href="#">Admin</a>
            </li>
            <li class="breadcrumb-item active">Posts</li>
        </ol>

        <div class="card mb-3">
            <div class="card-header">
                <i class="fa fa-table" style="margin-top: 10px;"></i> List Posts
                <a href="/admin/post/add"><button class="btn btn-primary" style="float: right;">Add New Post</button></a>
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Image</th>
                            <th>Content</th>
                            <th>Start date</th>
                            <th>Posted by</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>ID</th>
                            <th>Title</th>
                            <th>Image</th>
                            <th>Content</th>
                            <th>Start date</th>
                            <th>Posted by</th>
                            <th></th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <c:forEach var="post" items="${listPost}">
                            <tr>
                                <td>${post.getIdPost()}</td>
                                <td>${post.getTitle()}</td>
                                <td>${post.getImage()}</td>
                                <c:choose>
                                    <c:when test="${post.getContent().length() > 250}">
                                        <td>${post.getContent().substring(0,250)}</td>
                                    </c:when>
                                    <c:otherwise>
                                        <td>${post.getContent()}</td>
                                    </c:otherwise>
                                </c:choose>
                                <td>${post.getCreatedAt()}</td>
                                <td>${post.getUser().getUsername()}</td>
                                <td>
                                    <a href="/admin/post/${post.getIdPost()}"><button class="btn btn-success">Edit</button></a>
                                    <button class="btn btn-danger btn-delete" id_post="${post.getIdPost()}">Delete</button>
                                </td>
                            </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
            <div class="card-footer small text-muted">Updated yesterday at 11:59 PM</div>
        </div>
    </div>
</div>
<jsp:include page="Footer.jsp"/>
</body>
</html>
