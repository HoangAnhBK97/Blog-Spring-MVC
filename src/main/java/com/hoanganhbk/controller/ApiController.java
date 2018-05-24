package com.hoanganhbk.controller;

import com.hoanganhbk.entity.Comment;
import com.hoanganhbk.entity.Post;
import com.hoanganhbk.entity.User;
import com.hoanganhbk.service.CommentService;
import com.hoanganhbk.service.PostService;
import com.hoanganhbk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Controller
@RequestMapping("/api")
@SessionAttributes("username")
public class ApiController {
    @Autowired
    ServletContext servletContext;

    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

    @PostMapping("/upload")
    @ResponseBody
    public String uploadImage(MultipartHttpServletRequest request) {
        String path = servletContext.getRealPath("/resources/Image/");
        Iterator<String> listNames = request.getFileNames();
        MultipartFile mf = request.getFile(listNames.next());
        File fileSave = new File(path + mf.getOriginalFilename());
        try {
            mf.transferTo(fileSave);
        }  catch (IllegalStateException e) {
            e.printStackTrace();
            System.out.println("Co loi " + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Co loi IO : " + e.getMessage());
        }
        System.out.println(path +mf.getOriginalFilename());
        return "";
    }

    @GetMapping("deletePost")
    @ResponseBody
    public String deletePost(@RequestParam int idPost) {
        postService.deletePost(idPost);
        return "";
    }

    @GetMapping("addComment")
    @ResponseBody
    public String addComment(@RequestParam String content, @RequestParam int idPost, HttpSession session) {
        Comment comment = new Comment();
        comment.setContent(content);
        Post post = postService.findPostById(idPost);
        comment.setPost(post);
        String username = session.getAttribute("username").toString();
        User user = userService.findUserByUsername(username);
        comment.setUser(user);
        Timestamp timestamp = new Timestamp(System.currentTimeMillis());
        comment.setCreatedAt(timestamp);
        commentService.addComment(comment);
        System.out.println(content);
        String html = " <li>";
        html += "<div class=\"comment-main-level\">";
        html += "<div class=\"comment-avatar\"><img src=\"http://i9.photobucket.com/albums/a88/creaticode/avatar_1_zps8e1c80cd.jpg\" alt=\"\"></div>";
        html += " <div class=\"comment-box\">" ;
        html += "<div class=\"comment-head\">";
        html += " <h6 class=\"comment-name by-author\"><a href=\"http://creaticode.com/blog\">"+user.getFullName()+"</a></h6>";
        html += "<span>on "+timestamp+"</span>";
        html += "<i class=\"fa fa-remove\"></i>";
        html += "</div>";
        html += "<div class=\"comment-content\">"+content+"</div>";
        html += "</div></div></li>";
        return html;
    }

    @GetMapping("deleteComment")
    @ResponseBody
    public String deleteComment(int idComment) {
        commentService.deleteComment(idComment);
        return "";
    }

    @GetMapping("searchPost")
    @ResponseBody
    public String searchPost(@RequestParam String search_data, @RequestParam int id_page) {
        String html = "";
        List<Post> listPost = new ArrayList<Post>();
        if(search_data != null && !search_data.equals("")) {
            listPost = postService.searchPosts(search_data);
            if(listPost.size() > 0) {
                for(Post post : listPost) {
                    html += " <div class=\"post-preview\">";
                    html += "<div class=\"row\">";
                    html += "<div class=\"col-sm-4\">";
                    html += "<img src='/resources/Image/"+post.getImage()+"' alt=\"Image\" width=\"250px\" height=\"185px\"/>";
                    html += " </div>";
                    html += "<div class=\"col-sm-8\">";
                    html += "<a href=\"/post/"+post.getIdPost()+"\">";
                    html += " <h2 class=\"post-title\">";
                    html += post.getTitle();
                    html += "</h2></a>";
                    if(post.getContent().length() > 250) {
                        html += "<h6 class=\"post-subtitle\">";
                        html += post.getContent().substring(0,250);
                        html += "</h6>";
                    } else {
                        html += "<h6 class=\"post-subtitle\">";
                        html += post.getContent();
                        html += "</h6>";
                    }
                    html += "<p class=\"post-meta\">Posted by";
                    html += " <a href=\"#\">"+post.getUser().getUsername()+"</a>";
                    html += "on "+post.getCreatedAt()+"</p>";
                    html += "</div> </div></div><hr>";
                }
            } else {
                html = "No result";
            }
        } else if(search_data.trim().equals("")) {
            listPost = postService.getListPostByIndex((id_page-2)*3,3);
            if(listPost.size() > 0) {
                for(Post post : listPost) {
                    html += " <div class=\"post-preview\">";
                    html += "<div class=\"row\">";
                    html += "<div class=\"col-sm-4\">";
                    html += "<img src='/resources/Image/"+post.getImage()+"' alt=\"Image\" width=\"250px\" height=\"185px\"/>";
                    html += " </div>";
                    html += "<div class=\"col-sm-8\">";
                    html += "<a href=\"/post/"+post.getIdPost()+"\">";
                    html += " <h2 class=\"post-title\">";
                    html += post.getTitle();
                    html += "</h2></a>";
                    if(post.getContent().length() > 250) {
                        html += "<h6 class=\"post-subtitle\">";
                        html += post.getContent().substring(0,250);
                        html += "</h6>";
                    } else {
                        html += "<h6 class=\"post-subtitle\">";
                        html += post.getContent();
                        html += "</h6>";
                    }
                    html += "<p class=\"post-meta\">Posted by";
                    html += " <a href=\"#\">"+post.getUser().getUsername()+"</a>";
                    html += "on "+post.getCreatedAt()+"</p>";
                    html += "</div> </div></div><hr>";
                }
                if (listPost.size() > (id_page-2)*3) {
                    html += "<div class=\"clearfix\">";
                    html += "<a class=\"btn btn-primary float-right\" href=\"/page/"+id_page+"\">Older Posts &rarr;</a>";
                    html += "</div>";
                }
            } else {
                html = "No result";
            }
        }
        return html;
    }
}
