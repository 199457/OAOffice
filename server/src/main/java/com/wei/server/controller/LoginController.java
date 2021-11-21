package com.wei.server.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
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

    // @Secured("ROLE_admin") // 判断是否有 admin 角色
    @PreAuthorize("hasRole('admin')") // 判断是否有 admin 角色
    @PostMapping("/toMain")
    public String index() {
        return "redirect:main.html";
    }

    @PostMapping("/toError")
    public String error() {
        return "redirect:error.html";
    }
}
