package com.mub.roomwebdemospring2essential.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String getLogin() {
        return "Login";
    }

    @GetMapping("/logout")
    public String getLogout() {
        return "Logout";
    }

}

