package com.nothing.none.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {
    
    @PostMapping("/login")
    public String login() {
        return "Login";
    }

    @PostMapping("/register")
    public String register(){
        return "Register";
    }
}
