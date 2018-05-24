package com.hoanganhbk.controller;

import com.hoanganhbk.entity.Comment;
import com.hoanganhbk.entity.Post;
import com.hoanganhbk.entity.User;
import com.hoanganhbk.service.CommentService;
import com.hoanganhbk.service.PostService;
import com.hoanganhbk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/")
@SessionAttributes("username")
public class HomeController {
    @Autowired
    PostService postService;

    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    @GetMapping
    public String Home(HttpSession session, ModelMap modelMap) {
        if(session.getAttribute("username") != null) {
            modelMap.addAttribute("username", session.getAttribute("username"));
        }
        List<Post> listPost = postService.getListPostByIndex(0,3);
        int counts = postService.getListPost().size();
        modelMap.addAttribute("listPost", listPost);
        modelMap.addAttribute("id", 2);
        modelMap.addAttribute("counts", counts);
        return "Home";
    }

    @GetMapping("page/{id}")
    public String Page(@PathVariable int id, ModelMap modelMap, HttpSession session) {
        if(session.getAttribute("username") != null) {
            modelMap.addAttribute("username", session.getAttribute("username"));
        }
        int start = (id-1)*3;
        List<Post> listPost = postService.getListPostByIndex(start,start+3);
        int counts = postService.getListPost().size();
        modelMap.addAttribute("listPost", listPost);
        modelMap.addAttribute("id", (id+1));
        modelMap.addAttribute("counts", counts);
        return "Home";
    }

    @GetMapping("post/{id}")
    public String DetailPost(@PathVariable int id, ModelMap modelMap, HttpSession session) {
        Post post = postService.findPostById(id);
        modelMap.addAttribute("post", post);
        List<Comment> listComment = commentService.getListComment(id);
        modelMap.addAttribute("listComment", listComment);
        User user = new User();
        modelMap.addAttribute("countComment", listComment.size());
        if(session.getAttribute("username") != null) {
            user = userService.findUserByUsername(session.getAttribute("username").toString());
            modelMap.addAttribute("username", session.getAttribute("username"));
        }
        modelMap.addAttribute("user", user);
        return "DetailPost";
    }

    @GetMapping("about")
    public String About() {
        return "About";
    }

    @GetMapping("contact")
    public String Contact() {
        return "Contact";
    }
}
