package eu.morozik.transportagency.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class AuthController {

    @GetMapping("/login")
    public String getLogin(){
        return "login";
    }

    @GetMapping("/success")
    public String getSuccessPage(){
        return "success";
    }
}
