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
    <title>Comment Manager</title>
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
            <li class="breadcrumb-item active">Comments</li>
        </ol>

        <div class="card mb-3">
            <div class="card-header">
                <i class="fa fa-table" style="margin-top: 10px;"></i> List Comments
            </div>
            <div class="card-body">
                <div class="table-responsive">
                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                        <thead>
                        <tr>
                            <th>ID</th>
                            <th>Post</th>
                            <th>Content</th>
                            <th>Start date</th>
                            <th>Posted by</th>
                            <th></th>
                        </tr>
                        </thead>
                        <tfoot>
                        <tr>
                            <th>ID</th>
                            <th>Post</th>
                            <th>Content</th>
                            <th>Start date</th>
                            <th>Posted by</th>
                            <th></th>
                        </tr>
                        </tfoot>
                        <tbody>
                        <c:forEach var="comment" items="${listComments}">
                            <tr>
                                <td>${comment.getIdComment()}</td>
                                <td>${comment.getPost().getTitle()}</td>
                                <td>${comment.getContent()}</td>
                                <td>${comment.getCreatedAt()}</td>
                                <td>${comment.getUser().getUsername()}</td>
                                <td>
                                    <button class="btn btn-danger btn-delete-comment" id_post="${comment.getIdComment()}">Delete</button>
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
