package edu.bistu.loginweb.controller;

import edu.bistu.loginweb.domain.User;
import edu.bistu.loginweb.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RequestMapping("/user/")
@Controller
public class UserController {
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("login")
    public String login(String username,String password){
        log.info("登录的用户名为{}",username);
        log.info("登录的密码为{}",password);
        if(StringUtils.isEmpty(username)){
            return "用户名不为空";
        }
        if(StringUtils.isEmpty(password)){
            return "密码不能为空";
        }
        User userinfo=userMapper.selectUser(username);
        log.info("登录用户名是:{}",userinfo.getUsername());
        log.info("登录密码是:{}",userinfo.getPassword());

        if(password.equals(userinfo.getPassword())){
            return "index";
        }else{
            return "log-1";
        }

        //return "登录失败";
    }
    @RequestMapping("register")
    public String register(String username,String password,String password2){

        log.info("username:{}",username);
        log.info("password:{}",password);
        if(StringUtils.isEmpty(username)){
            return "用户名不为空";
        }
        if(StringUtils.isEmpty(password)){
            return "密码不能为空";
        }

        User userinfo=userMapper.selectUser(username);
        if(userinfo!=null){
            return "用户名已存在，注册失败";
        }

        if(!password.equals(password2)){
            return "两次输入密码不一致";
        }

        int userResult=userMapper.saveUser(username,password);

        if(userResult==0){
            return "注册失败";
        }
        return "注册成功";

    }
}
