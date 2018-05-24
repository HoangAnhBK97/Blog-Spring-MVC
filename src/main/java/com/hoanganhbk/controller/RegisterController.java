package com.hoanganhbk.controller;

import com.hoanganhbk.entity.User;
import com.hoanganhbk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Timestamp;


@Controller
@RequestMapping("/register")
public class RegisterController {
    @Autowired
    UserService userService;

    @GetMapping
    public String Default() {
        return "Register";
    }

    @PostMapping
    public String addUser(@RequestParam String fullname, @RequestParam String username, @RequestParam String password,
                         ModelMap modelMap) {
        if(userService.isExist(username)) {
            modelMap.addAttribute("warning", "User is exist");
            return "Register";
        } else {
            User user = new User();
            user.setFullName(fullname);
            user.setUsername(username);
            user.setPassword(password);
            Timestamp timestamp = new Timestamp(System.currentTimeMillis());
            user.setCreatedAt(timestamp);
            user.setRole(false);
            boolean kt = userService.addUser(user);
            return "redirect:/login";
        }
    }
}
