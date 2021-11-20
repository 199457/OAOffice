package com.wei.server.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

    // @GetMapping("/login")
    // public String login() {
    //     System.out.println("login");
    //     return "redirect:login.html";
    // }

    @PostMapping("/toMain")
    public String index() {
        return "redirect:main.html";
    }

    @PostMapping("/toError")
    public String error() {
        return "redirect:error.html";
    }
}
