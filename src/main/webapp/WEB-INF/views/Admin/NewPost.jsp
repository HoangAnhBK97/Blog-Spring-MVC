<%--
  Created by IntelliJ IDEA.
  User: hoanganh
  Date: 5/22/18
  Time: 10:43 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add a new post</title>
    <jsp:include page="Header.jsp"/>
    <!-- Include Editor style. -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.5.1/css/froala_editor.pkgd.min.css" rel="stylesheet" type="text/css"
    />
    <link href="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.5.1/css/froala_style.min.css" rel="stylesheet" type="text/css"
    />
</head>
<body class="fixed-nav sticky-footer bg-dark" id="page-top">
    <jsp:include page="Menu.jsp"/>
    <div class="content-wrapper">
        <div class="container-fluid">
            <ol class="breadcrumb">
                <li class="breadcrumb-item">
                    <i class="fa fa-home"></i><a href="#">Admin</a>
                </li>
                <li class="breadcrumb-item active">New Post</li>
            </ol>
        </div>
        <div class="container">
            <h3>Add a new post</h3>
            <form action="" method="post">
                <div class="form-group">
                    <label for="title">Title :</label>
                    <input type="text" class="form-control" id="title" name="title">
                </div>
                <div class="input-group mb-3">
                    <div class="input-group-prepend">
                        <span class="input-group-text">Upload</span>
                    </div>
                    <div class="custom-file">
                        <input type="file" class="custom-file-input" id="image" name="image">
                        <label class="custom-file-label" for="image">Choose file</label>
                    </div>
                </div>
                <div class="form-group">
                    <label for="content">Content:</label>
                    <textarea class="form-control" rows="5" id="content" name="content"></textarea>
                </div>
                <button type="submit" class="btn btn-default">Add</button>
            </form>
        </div>
    </div>
    <jsp:include page="Footer.jsp"/>
    <!-- Include Editor JS files. -->
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/froala-editor/2.5.1//js/froala_editor.pkgd.min.js"></script>

    <!-- Initialize the editor. -->
    <script>
        $(function () {
            $('textarea').froalaEditor()
        });
    </script>
</body>
</html>
