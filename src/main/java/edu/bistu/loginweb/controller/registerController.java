package edu.bistu.loginweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class registerController {
    @RequestMapping("/user/inregister")
    public String index(){
        return "user-setting";
    }
}
