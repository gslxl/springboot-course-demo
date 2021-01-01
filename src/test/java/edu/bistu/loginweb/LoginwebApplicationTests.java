package edu.bistu.loginweb;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@MapperScan("edu.bistu.loginweb.mapper")
@SpringBootTest
class LoginwebApplicationTests {

    @Test
    void contextLoads() {
    }

}
