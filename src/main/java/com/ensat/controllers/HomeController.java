package com.ensat.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Homepage controller.
 */
@Controller
public class HomeController {

    @RequestMapping({"/","/login"})
    String login() {
        return "login/login";
    }
    
    @RequestMapping("/admin/home")
    String adminHome() {
        return "admin/home";
    }
    
    @RequestMapping("/app1/home")
    String app1Home() {
        return "app1/home";
    }

}
