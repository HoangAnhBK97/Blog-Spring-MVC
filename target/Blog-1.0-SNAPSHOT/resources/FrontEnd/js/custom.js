$(document).ready(function(){
    $(".btn-comment").click(function(){
        var content = $("textarea.commentcontent").val();
        var idPost = $(this).attr("id_post");
        idPost = parseInt(idPost)
        $.ajax({
            url: "http://localhost:8080/api/addComment",
            type: "GET",
            data: {
                content: content,
                idPost: idPost
            },
            success: function (value) {
                $("#comments-list").append(value);
            }
        })
    })

    $("#search_post").on("input",function(){
        var search_data = $("#search_post").val()
        var id_page = $(this).attr("id_page")
        if(search_data !=null || search_data != "" ) {
            $("#content_page").empty();
        } else {
            search_data = "";
        }
        id_page = parseInt(id_page)
        $.ajax({
             url: "/api/searchPost",
             type: "GET",
             data: {
                 search_data: search_data,
                 id_page: id_page
             },
             success: function(value){
                 $("#content_page").html(value);
             }
         });
    })
})