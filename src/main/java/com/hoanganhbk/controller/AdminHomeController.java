package com.hoanganhbk.controller;

import com.hoanganhbk.entity.User;
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
@RequestMapping("/admin")
@SessionAttributes("username")
public class AdminHomeController {
    @Autowired
    UserService userService;

    @GetMapping
    public String Default(ModelMap modelMap, HttpSession session) {
        if(session.getAttribute("username") != null) {
            User user = userService.findUserByUsername(session.getAttribute("username").toString()) ;
            if (user.isRole()) {
                List<User> listUser = userService.getListUsers();
                modelMap.addAttribute("listUser", listUser);
                return "Admin/Index";
            } else {
                return "redirect:/";
            }
        } else {
            return "redirect:/login";
        }
    }
}
