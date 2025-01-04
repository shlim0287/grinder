package com.grinder.web.main;

import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String main() {
        return "/main/index";
    }

    @GetMapping("/register")
    public String register(){return "/main/register";}

    @GetMapping("/login")
    public String login() {
        return "login";
    }
}
