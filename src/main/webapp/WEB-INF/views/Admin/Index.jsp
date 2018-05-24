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
    <title>Administrator Page</title>
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
                <li class="breadcrumb-item active">Users</li>
            </ol>

            <div class="card mb-3">
                <div class="card-header">
                    <i class="fa fa-table" style="margin-top: 10px;"></i> List Users
                    <button class="btn btn-primary" style="float: right;">Add User</button>
                </div>
                <div class="card-body">
                    <div class="table-responsive">
                        <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                            <thead>
                            <tr>
                                <th>ID</th>
                                <th>Full Name</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Start date</th>
                                <th>Role</th>
                            </tr>
                            </thead>
                            <tfoot>
                            <tr>
                                <th>ID</th>
                                <th>Full Name</th>
                                <th>Username</th>
                                <th>Password</th>
                                <th>Start date</th>
                                <th>Role</th>
                            </tr>
                            </tfoot>
                            <tbody>
                            <c:forEach var="user" items="${listUser}">
                                <tr>
                                    <td>${user.getIdUser()}</td>
                                    <td>${user.getFullName()}</td>
                                    <td>${user.getUsername()}</td>
                                    <td>${user.getPassword()}</td>
                                    <td>${user.getCreatedAt()}</td>
                                    <c:choose>
                                        <c:when test="${user.isRole() == false}">
                                            <td>Member</td>
                                        </c:when>
                                        <c:otherwise>
                                            <td>Admin</td>
                                        </c:otherwise>
                                    </c:choose>
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
