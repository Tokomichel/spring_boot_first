package com.produit.security;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SecurityController {

    @GetMapping("/accessRefuse")
    public String accessDenied() {
        return "error";
    }
}
