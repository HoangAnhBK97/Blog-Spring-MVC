package com.hoanganhbk.controller;

import com.hoanganhbk.entity.Comment;
import com.hoanganhbk.entity.User;
import com.hoanganhbk.service.CommentService;
import com.hoanganhbk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@RequestMapping("/admin/comment")
@SessionAttributes("username")
public class CommentController {
    @Autowired
    CommentService commentService;

    @Autowired
    UserService userService;

    @GetMapping
    public String Default(ModelMap modelMap, HttpSession session) {
        if(session.getAttribute("username") != null) {
            User user = userService.findUserByUsername(session.getAttribute("username").toString()) ;
            if (user.isRole()) {
                List<Comment> listComments = commentService.getAllComment();
                modelMap.addAttribute("listComments", listComments);
                return "Admin/Comments";
            } else {
                return "redirect:/";
            }
        } else {
            return "redirect:/login";
        }
    }
}
