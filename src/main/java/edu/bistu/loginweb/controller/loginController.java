package edu.bistu.loginweb.controller;

import edu.bistu.loginweb.domain.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;

@Controller
public class loginController {
    @RequestMapping("/")
    public String index(){
        return "login-1";
    }
//    @RequestMapping("/")
//    public HashMap index(){
//        HashMap<String, String> result = new HashMap<String, String>();
//        result.put("name","zhangsan");
//        return result;
//    }
//    @RequestMapping("/")
//    @ResponseBody
//    public User index(){
//        User user=new User();
//        user.setID(122);
//        user.setUsername("yanjiusheng");
//        user.setPassword("8888888");
//        return user;
//    }

}

//    @RequestMapping("/")
//    public HashMap index(){
//        HashMap<String, String> result = new HashMap<String, String>();
//        result.put("name","zhangsan");
//        return result;
//    }
//    }
//
//    @GetMapping("/")
//    public Object index(){
//        User user=new User();
//        user.setID(10);
//        user.setUsername("zhang san");
//        user.setPassword("123456");
//        return user;
//    }
