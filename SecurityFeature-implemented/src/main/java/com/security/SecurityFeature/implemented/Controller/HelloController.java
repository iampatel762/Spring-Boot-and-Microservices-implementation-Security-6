package com.security.SecurityFeature.implemented.Controller;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @GetMapping("/")
    public String greet(HttpServletRequest req){
        return "welcome to security feature\n"+req.getSession().getId();
    }
}
