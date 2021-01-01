package edu.bistu.loginweb.service.impl;

import edu.bistu.loginweb.domain.CovidData;
import edu.bistu.loginweb.service.DataService;
import edu.bistu.loginweb.vo.DataVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;
@Slf4j
@SpringBootTest
class DataServiceimplTest {

    @Autowired
    DataService dataService;

    @Test
    private void test(){
        DataVO result = dataService.findData(1, 100);
        log.info("总共有数据{}",result.getCount());

        //result.getData().forEach(System.out::println);

    }



}