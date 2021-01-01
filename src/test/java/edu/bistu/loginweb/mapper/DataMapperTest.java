package edu.bistu.loginweb.mapper;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class DataMapperTest {
    @Autowired
    private DataMapper dataMapper;

    @Test
    void Test(){
        dataMapper.selectAll().forEach(System.out::println);
    }
}