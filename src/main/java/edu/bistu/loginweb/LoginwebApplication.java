package edu.bistu.loginweb;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


//用来扫描注入我们的mapper类，在edu.bistu.loginweb.mapper这个路径下的作为mapper注入进来
@MapperScan("edu.bistu.loginweb.mapper")
@SpringBootApplication
public class LoginwebApplication {

    public static void main(String[] args) {
        SpringApplication.run(LoginwebApplication.class, args);
    }

}
