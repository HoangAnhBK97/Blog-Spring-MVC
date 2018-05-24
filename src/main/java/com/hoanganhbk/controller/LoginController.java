package com.hoanganhbk.controller;

import com.hoanganhbk.entity.User;
import com.hoanganhbk.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/login")
@SessionAttributes("username")
public class LoginController {
    @Autowired
    UserService userService;

    @GetMapping
    public String Default() {
        return "Login";
    }

    @PostMapping
    public String Login(@RequestParam String username, @RequestParam String password, ModelMap modelMap) {
        int check = userService.userRegisterValidate(username, password);
        if(check == -1) {
            modelMap.addAttribute("warning", "Username and Password does not match ");
            return "Login";
        } else {
            if(check == 1) {
                modelMap.addAttribute("username", username);
                User user = userService.findUserByUsername(username);
                if(user.isRole()) {
                    return "redirect:/admin";
                } else {
                    return "redirect:/";
                }
            } else {
                modelMap.addAttribute("username", username);
                return "redirect:/";
            }
        }
    }
}
