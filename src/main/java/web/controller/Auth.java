package web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class Auth {

    @GetMapping("/login")
    public String showLogin (){
        return "auth/login";
    }

    @GetMapping("/logout")
    public String snowLogout(){
        return "auth/logout";
    }
}
