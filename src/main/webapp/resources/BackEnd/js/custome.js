$(document).ready(function() {
   var files = []
   $("#image").change(function(event){
       files = event.target.files;
       forms = new FormData();
       forms.append("file", files[0]);
       $.ajax({
           url: "http://localhost:8080/api/upload",
           type: "POST",
           data: forms,
           contentType: false,
           processData: false,
           enctype: "multipart/form-data",
           success: function (value) {
               
           }
       });
   });

   $(".btn-delete").click(function(){
       var idPost = $(this).attr("id_post");
       $.ajax({
           url: "http://localhost:8080/api/deletePost",
           type: "GET",
           data: {
               idPost: idPost
           },
           success: function (value) {

           }
       })
       $(this).closest("tr").remove();
   });

    $(".btn-delete-comment").click(function(){
        var idComment = $(this).attr("id_post");
        alert(idComment);
        $.ajax({
            url: "http://localhost:8080/api/deleteComment",
            type: "GET",
            data: {
                idComment: idComment
            },
            success: function (value) {

            }
        })
        $(this).closest("tr").remove();
    });
    $(".btn-delete-comment-2").click(function(){
        var idComment = $(this).attr("id_post");
        alert(idComment);
        $.ajax({
            url: "http://localhost:8080/api/deleteComment",
            type: "GET",
            data: {
                idComment: idComment
            },
            success: function (value) {

            }
        })
        $(this).closest("li").remove();
    });
});