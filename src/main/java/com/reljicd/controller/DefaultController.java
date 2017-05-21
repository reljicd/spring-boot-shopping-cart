package com.reljicd.controller;

import com.reljicd.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DefaultController {

    @Autowired
    private UserService userService;

    @GetMapping("/home")
    public String admin() {
        return "/home";
    }

    @GetMapping("/403")
    public String error403() {
        return "/403";
    }

}
