package com.hoanganhbk.controller;

import com.hoanganhbk.entity.Post;
import com.hoanganhbk.entity.User;
import com.hoanganhbk.service.PostService;
import com.hoanganhbk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.List;

@Controller
@RequestMapping("/admin/post")
@SessionAttributes("username")
public class PostController {
    @Autowired
    PostService postService;

    @Autowired
    UserService userService;

    @GetMapping
    public String Default(ModelMap modelMap, HttpSession session) {
        if(session.getAttribute("username") != null) {
            String username = session.getAttribute("username").toString();
            User user = userService.findUserByUsername(username);
            if(user.isRole()) {
                List<Post> listPost = postService.getListPost();
                modelMap.addAttribute("listPost", listPost);
                return "Admin/Posts";
            } else {
                return "redirect:/";
            }
        } else {
            return "redirect:/login";
        }

    }

    @GetMapping("{id}")
    public String GetEditPost(HttpSession session, @PathVariable int id, ModelMap modelMap) {
        if(session.getAttribute("username") != null) {
            String username = session.getAttribute("username").toString();
            User user = userService.findUserByUsername(username);
            if (user.isRole()) {
                Post post = postService.findPostById(id);
                modelMap.addAttribute("post", post);
                return "Admin/EditPost";
            } else {
                return "Home";
            }
        } else {
            return "redirect:/login";
        }
    }

    @GetMapping("/add")
    public String addNewPost(HttpSession session) {
        if(session.getAttribute("username") != null) {
            User user = userService.findUserByUsername(session.getAttribute("username").toString());
            if(user.isRole()) {
                return "Admin/NewPost";
            } else {
                return "redirect:/";
            }
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("{id}")
    public String EditPost(HttpSession session, ModelMap modelMap, @RequestParam int idPost, @RequestParam String title,
                           @RequestParam String image, @RequestParam String content) {
        if(session.getAttribute("username") != null) {
            String username = session.getAttribute("username").toString();
            User user = userService.findUserByUsername(username);
            if (user.isRole()) {
                Post post = new Post();
                post.setIdPost(idPost);
                post.setTitle(title);
                post.setContent(content);
                post.setCreatedAt(postService.findPostById(idPost).getCreatedAt());
                if(image == null || image == "") {
                    post.setImage(postService.findPostById(idPost).getImage());
                } else {
                    post.setImage(image);
                }
                post.setUser(postService.findPostById(idPost).getUser());
                postService.editPost(post);
                return "redirect:/admin/post";
            } else {
                return "Home";
            }
        } else {
            return "redirect:/login";
        }
    }

    @PostMapping("/add")
    public String addPost(@RequestParam String title, @RequestParam String image, @RequestParam String content,
                          HttpSession session) {
        if(session.getAttribute("username") != null) {
            User user = userService.findUserByUsername(session.getAttribute("username").toString());
            if(user.isRole()) {
                Post post = new Post();
                post.setTitle(title);
                post.setImage(image);
                post.setContent(content);
                Timestamp timestamp = new Timestamp(System.currentTimeMillis());
                post.setCreatedAt(timestamp);
                post.setUser(user);
                postService.addPost(post);
                return "redirect:/admin/post";
            } else {
                return "redirect:/";
            }
        } else {
            return "redirect:/";
        }
    }
}
